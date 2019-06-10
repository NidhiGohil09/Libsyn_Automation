package com.libsyn.configuration;

import java.awt.TrayIcon.MessageType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class configFileReader {
	private static Properties properties;
	private final String propertyFilePath = "resource//base.properties";
	static BufferedReader customPropertyReader;

	public configFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("chromedriverpath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public static String getCustomProperty(String propertyName) throws IOException {
		String customPropertyFilePath = properties.getProperty("customPropertyFile");
		try {
			customPropertyFilePath = "resource//" + customPropertyFilePath;
			customPropertyReader = new BufferedReader(new FileReader(customPropertyFilePath));
			properties.load(customPropertyReader);
			String propertyValue = properties.getProperty(propertyName);
			return propertyValue;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + customPropertyFilePath);
		}
	}

	// Method to verify element on screen
	public static void verifyElemet(WebElement webElement, String elementName) throws Exception {
		if (webElement.isDisplayed()) {
			Reporter.log(elementName + " is Present on screen");
		} else {
			Reporter.log(elementName + " is not Present on screen");
			WebDriver driver= new ChromeDriver();
			String imagePath=getCustomProperty("imagefilepath");
			takeSnapShot(driver,imagePath);
		}
	

	}
	//Method to take screenshot

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

}
