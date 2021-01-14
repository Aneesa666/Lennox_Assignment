package com.lennox.automation.common;

import org.openqa.selenium.By;

import com.lennox.automation.model.LocatorDto;

public class WebElementUtil {
	public static By formWebElement(LocatorDto locatorDto) {
		if (locatorDto.getLocatorValue().equalsIgnoreCase("xpath")) {
			return By.xpath(locatorDto.getLocatorName());
		} else if (locatorDto.getLocatorValue().equalsIgnoreCase("cssSelector")) {
			return By.cssSelector(locatorDto.getLocatorName());
		} else if (locatorDto.getLocatorValue().equalsIgnoreCase("linkText")) {
			return By.linkText(locatorDto.getLocatorName());
		}
		else if (locatorDto.getLocatorValue().equalsIgnoreCase("id")) {
					return By.id(locatorDto.getLocatorName());		
		}
		return null;
	}
}