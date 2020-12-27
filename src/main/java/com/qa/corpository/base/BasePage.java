package com.qa.corpository.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.corpository.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionManager;

	/**
	 * This method is used to initialize browser
	 * 
	 * @param browser
	 * @return
	 */

	public static ThreadLocal<WebDriver> ltDriver = new ThreadLocal<WebDriver>();

	public WebDriver init_driver(String browser) {

		System.out.println("Browser value is: " + browser);
		optionManager = new OptionsManager(prop);
	
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteWebDriver(browser);
			} else {
				ltDriver.set(new ChromeDriver(optionManager.getChromeOptions()));
			}
		}

		else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteWebDriver(browser);
			} else {
				ltDriver.set(new FirefoxDriver(optionManager.getFirefoOptions()));
			}
		}

		else {
			System.out.println("Enter proper browser name" + browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
	//	getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return ltDriver.get();
	}

	/*
	 * it return properties reference This method is used to load the properties
	 * from config.properties
	 */

	public Properties init_prop() {

		prop = new Properties();
		File file = new File(".\\src\\main\\java\\com\\qa\\corpository\\config\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;

	}

	/*
	 * This method is responsible for Get screenshot
	 * 
	 */
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public void init_remoteWebDriver(String browser) {

		System.out.println("Running on Remote Grid System");

		if (browser.equalsIgnoreCase("Chrome")) {

			DesiredCapabilities cp = DesiredCapabilities.chrome();
			cp.setJavascriptEnabled(true);
			cp.setCapability(ChromeOptions.CAPABILITY, optionManager.getChromeOptions());
			try {
				ltDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cp));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (browser.equalsIgnoreCase("Firefox")) {

			DesiredCapabilities cp = DesiredCapabilities.firefox();
			cp.setJavascriptEnabled(true);
			cp.setCapability(FirefoxOptions.FIREFOX_OPTIONS, optionManager.getFirefoOptions());
			try {
				ltDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cp));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}