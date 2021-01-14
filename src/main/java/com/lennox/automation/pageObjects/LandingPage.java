package com.lennox.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lennox.automation.common.ExcelUtils;
import com.lennox.automation.common.WebElementUtil;

public class LandingPage {

	WebDriver driver;

	private By signin = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("signIn"));

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLogin() {
		driver.findElement(signin).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
}