package com.Chamara.Amazon.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverHelper {
	static WebDriverHelper wDHelper;
	public static WebDriver driver;

	private WebDriverHelper() {

	}

	public static WebDriverHelper getWebDriverHelper() {
		if (wDHelper == null) {
			wDHelper = new WebDriverHelper();
		}
		return wDHelper;
	}

	public static WebDriver startUpWebDriver(String browser, String path) {
		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", path);
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void enterURL(String url) throws InterruptedException {
		driver.navigate().to(url);
		Thread.sleep(5000);
	}
	
	public static WebDriver getWebDriver() {
		return driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public static void scrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) WebDriverHelper.getWebDriver();
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

}
