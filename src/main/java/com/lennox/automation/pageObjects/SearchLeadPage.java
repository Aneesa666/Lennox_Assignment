package com.lennox.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.lennox.automation.common.ExcelUtils;
import com.lennox.automation.common.WebElementUtil;

public class SearchLeadPage {
	public WebDriver driver;

	private By searchBar = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("searchBar"));
	private By addLead = WebElementUtil.formWebElement(ExcelUtils.locatorValues.get("addLead"));

	public SearchLeadPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement checkSearchBar() {
		return driver.findElement(searchBar);
	}

	public WebElement clickAddLead() {
		return driver.findElement(addLead);
	}
}