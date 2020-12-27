package com.qa.corpository.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.corpository.pages.AccountsPage;
import com.qa.corpository.pages.AddToCartPage;
import com.qa.corpository.pages.LoginPage;
import com.qa.corpository.pages.ProductInfoPage;
import com.qa.corpository.pages.RegistrationPage;

public class BaseTest {

	public BasePage basePage;
	public Properties prop;
	public LoginPage loginPage;
	public AccountsPage accountPage;
	public RegistrationPage registerPage;
	public ProductInfoPage productInfoPage;
	public AddToCartPage addToCartPage;
	public WebDriver driver;

	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {
		basePage = new BasePage();
		prop = basePage.init_prop();
		String browser = prop.getProperty("browser");
		if(browserName != null)
		{
			browser = browserName;
		}
		driver = basePage.init_driver(browser);
		loginPage = new LoginPage(driver);
		accountPage = new AccountsPage(driver);
		productInfoPage = new ProductInfoPage(driver);
		driver.get(prop.getProperty("url"));

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
