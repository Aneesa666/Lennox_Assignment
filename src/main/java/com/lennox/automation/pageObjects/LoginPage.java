package com.lennox.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lennox.automation.common.ExcelUtils;
import com.lennox.automation.common.WebElementUtil;

public class LoginPage {
	public WebDriver driver;

	private By email = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("email"));
	private By password = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("password"));
	private By signIn = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("logIn"));

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement clickSignIn() {
		return driver.findElement(signIn);
	}
}