package com.lennox.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lennox.automation.common.ExcelUtils;
import com.lennox.automation.common.WebElementUtil;

public class HomePage {
	public WebDriver driver;

	private By menu = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("menu"));
	private By salesTool = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("salesTool"));
	private By buildAProposal = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("buildAProposal"));
	private By selectLead = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("selectLead"));

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement clickMenu() {
		return driver.findElement(menu);
	}

	public WebElement clicksalesTool() {
		return driver.findElement(salesTool);
	}

	public WebElement clickbuildAProposal() {
		return driver.findElement(buildAProposal);
	}

	public WebElement clickselectLead() {
		return driver.findElement(selectLead);
	}
}