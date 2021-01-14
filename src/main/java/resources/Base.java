package resources;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.lennox.automation.common.ExcelUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	

	public WebDriver initializeDriver() throws IOException {
		
		String browserName = ExcelUtils.values.get("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().version("87.0.4280.88").setup();
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.addArguments("start-maximized");
			driver = new ChromeDriver(chromeoptions);

		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().version("v0.9.0").setup();
			FirefoxOptions firefoxoptions = new FirefoxOptions();
			firefoxoptions.addArguments("start-maximized");
			driver = new FirefoxDriver(firefoxoptions);
		} else if (browserName.equals("IE")) {
			
		}
		return driver;
	}
}