package com.lennox.automation.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lennox.automation.common.ExcelUtils;
import com.lennox.automation.pageObjects.AddLeadPage;
import com.lennox.automation.pageObjects.HomePage;
import com.lennox.automation.pageObjects.LandingPage;
import com.lennox.automation.pageObjects.LoginPage;
import com.lennox.automation.pageObjects.SearchLeadPage;

import junit.framework.Assert;
import resources.Base;


public class SaveLead extends Base {
	public WebDriver driver;
	private Robot robot;
	private Select select;
	private Actions actions;
	
	public static Logger log = LogManager .getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		ExcelUtils.locatorProps();
		ExcelUtils.readBrowserProps();
		ExcelUtils.readEnvProps();
		ExcelUtils.testDataProps();
		driver = initializeDriver();
	}

	@Test
	public void navigateToBaseUrl() throws IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(ExcelUtils.values.get("url"));
		LandingPage landingPage = new LandingPage(driver);
		LoginPage loginPage = landingPage.getLogin();
		loginPage.getEmail().sendKeys(ExcelUtils.values.get("userid"));
		loginPage.getPassword().sendKeys(ExcelUtils.values.get("password"));
		loginPage.clickSignIn().click();
		log.info("Successfully navigated to Home Page after login.");
		Assert.assertEquals(driver.getTitle(), "Homepage | LennoxPROs.com");
	}

	@Test
	public void navigateToSearchLeadPage() throws IOException, InterruptedException {
		actions = new Actions(driver);
		HomePage homePage = new HomePage(driver);
		homePage.clickMenu().click();
		homePage.clicksalesTool().click();
		homePage.clickbuildAProposal().click();
		Thread.sleep(5000);
		actions.moveToElement(homePage.clickselectLead()).click().build().perform();

	}

	@Test
	public void saveLead() throws IOException, InterruptedException, AWTException {

		robot = new Robot();
		actions = new Actions(driver);
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;		
		String expectedMsg ="Lead Saved Successfully";
		
		AddLeadPage addLeadPage = new AddLeadPage(driver);
		SearchLeadPage searchLeadPage = new SearchLeadPage(driver);
		Assert.assertTrue(searchLeadPage.checkSearchBar().isDisplayed());
		
		log.info("Successfully navigated to Search Leads Page.");
		actions.moveToElement(searchLeadPage.clickAddLead()).click().build().perform();	
					
		for (int i = 0; i < ExcelUtils.testDataValues.size(); i++) {			
			addLeadPage.getFirstName().sendKeys(ExcelUtils.testDataValues.get("TestData" + i).getFirstName());
			System.out.println(ExcelUtils.testDataValues.get("TestData" + i).getFirstName());
			addLeadPage.getlastName().sendKeys(ExcelUtils.testDataValues.get("TestData" + i).getLastName());
			addLeadPage.getEmailID().sendKeys(ExcelUtils.testDataValues.get("TestData" + i).getEmail());
			addLeadPage.getPhoneNo().sendKeys(ExcelUtils.testDataValues.get("TestData" + i).getPhone());
			
			addLeadPage.getSchedulingReqDate().click();
				
			String reqDate=ExcelUtils.testDataValues.get("TestData" + i).getRequestDate();
			String reqDay=reqDate.split("/")[0];
			int reqMonth=Integer.parseInt(reqDate.split("/")[1]);
			int reqYear=Integer.parseInt(reqDate.split("/")[2]);					
			int totalClick = (reqYear-currentYear)*12 + (reqMonth-currentMonth);
			
			for ( int j=0;j<totalClick;j++) {
				addLeadPage.getSchedulingDateNav().click();
			}
			
			List<WebElement> dateList = addLeadPage.getSchedulingDatePick();
			
			for(int k=0;k<dateList.size();k++)
			{
				if (dateList.get(k).getText().equals(reqDay)) {				
					dateList.get(k).click();
				}
			}
			
			Select dropTime=new Select(addLeadPage.getSchedulingReqTime());
			dropTime.selectByVisibleText(ExcelUtils.testDataValues.get("TestData" + i).getRequestTime());
			
			if (StringUtils.isNotEmpty(ExcelUtils.testDataValues.get("TestData" + i).getDocumentPath())) {
				actions.moveToElement(addLeadPage.clickAddDocument()).click().build().perform();
				Thread.sleep(5000);
				select = new Select(addLeadPage.clickSelectOption());
				select.selectByVisibleText(ExcelUtils.testDataValues.get("TestData" + i).getOption());
				actions.moveToElement(addLeadPage.clickSelectFile()).click().build().perform();
				robot.setAutoDelay(2000);
				StringSelection data = new StringSelection(ExcelUtils.testDataValues.get("TestData" + i).getDocumentPath());
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(data, null);
				robot.setAutoDelay(1000);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_V);
				robot.setAutoDelay(1000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				actions.moveToElement(addLeadPage.clickaddToLead()).click().build().perform();
			}
			if (StringUtils.isNotEmpty(ExcelUtils.testDataValues.get("TestData" + i).getImagePath())) {
				actions.moveToElement(addLeadPage.clickAddImage()).click().build().perform();			
				StringSelection data = new StringSelection(ExcelUtils.testDataValues.get("TestData" + i).getImagePath());
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(data, null);
				robot.setAutoDelay(1000);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_V);
				robot.setAutoDelay(1000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			}
			
			actions.moveToElement(addLeadPage.getSaveLead()).click().build().perform();	
			Assert.assertEquals(addLeadPage.getSuccessMsg().getText(),expectedMsg);
			log.info("Lead got saved successfully.");					
			if( i < ExcelUtils.testDataValues.size()-1 ) {
				actions.moveToElement(addLeadPage.getNavLink()).click().build().perform();
				actions.moveToElement(searchLeadPage.clickAddLead()).click().build().perform();	
			}
		}
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}