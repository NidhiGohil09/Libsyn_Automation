package com.libsyn.configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.libsyn.configuration.configFileReader;

/**
 * @author nugohil
 *
 */

public class BasePage extends configFileReader {
	private static final int TIMEOUT = 5;
	private static final int POLLING = 100;
	static configFileReader configFileReader = null;
	protected static WebDriver driver;
	private static WebDriverWait wait;

	public BasePage() {
		/*
		 * setDriver(); //driver=BasePage.driver; OpenApplication();
		 */
	}

	protected void waitForElementToAppear(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	protected void waitForElementToDisappear(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	protected void waitForTextToDisappear(By locator, String text) {
		wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
	}
	/*
	 * protected String verifyPresent(WebElement element) { return
	 * element.isDisplayed() ? element.getText()+"is Present " :
	 * element.getText()+"is not Present "; }
	 */

	protected void waitForPageToLoad() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void OpenApplication() {
		setDriver();
		String url = configFileReader.getApplicationUrl();
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void setDriver() {
		configFileReader = new configFileReader();
		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);

	}

	public static void closeBroswer() {
		driver.quit();
	}

}
