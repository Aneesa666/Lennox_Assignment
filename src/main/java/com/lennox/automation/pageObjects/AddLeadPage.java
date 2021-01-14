package com.lennox.automation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lennox.automation.common.ExcelUtils;
import com.lennox.automation.common.WebElementUtil;

public class AddLeadPage {
	public WebDriver driver;
	private By firstName = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("firstName"));
	private By lastName = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("lastName"));
	private By emailID = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("emailID"));
	private By phoneNo = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("phoneNo"));
	private By schedulingReqDate = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("schedulingReqDate"));
	private By schedulingDateNav = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("schedulingDateNav"));
	private By schedulingDatePick = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("schedulingDatePick"));
	private By schedulingReqTime = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("schedulingReqTime"));
	private By addDocument = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("addDocument"));
	private By selectOption = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("selectOption"));
	private By selectFile = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("selectFile"));
	private By addToLead = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("addToLead"));
	private By addImage = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("addImage"));
	private By saveLead = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("saveLead"));
	private By navLink = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("navLink"));
	private By successMsg = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("successMsg"));
	
	public AddLeadPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFirstName() {
		return driver.findElement(firstName);
	}

	public WebElement getlastName() {
		return driver.findElement(lastName);
	}

	public WebElement getEmailID() {
		return driver.findElement(emailID);
	}

	public WebElement getPhoneNo() {
		return driver.findElement(phoneNo);
	}

	public WebElement getSchedulingReqDate() {
		return driver.findElement(schedulingReqDate);
	}

	public WebElement getSchedulingDateNav() {
		return driver.findElement(schedulingDateNav);
	}
	
	public List<WebElement> getSchedulingDatePick() {
		return driver.findElements(schedulingDatePick);
	}
	
	public WebElement getSchedulingReqTime() {
		return driver.findElement(schedulingReqTime);
	}

	public WebElement clickAddDocument() {
		return driver.findElement(addDocument);
	}

	public WebElement clickSelectOption() {
		return driver.findElement(selectOption);
	}

	public WebElement clickSelectFile() {
		return driver.findElement(selectFile);
	}

	public WebElement clickaddToLead() {
		return driver.findElement(addToLead);
	}

	public WebElement clickAddImage() {
		return driver.findElement(addImage);
	}

	public WebElement getSaveLead() {
		return driver.findElement(saveLead);
	}

	public WebElement getNavLink() {
		return driver.findElement(navLink);
	}	
	public WebElement getSuccessMsg() {
		return driver.findElement(successMsg);
	}
}