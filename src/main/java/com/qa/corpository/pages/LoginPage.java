package com.qa.corpository.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.corpository.base.BasePage;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	private WebDriver driver;

	// By Locators
	private By username = By.cssSelector("#input-email");
	private By pword = By.cssSelector("#input-password");
	private By loginBtn = By.xpath("//input[@type = 'submit' and @value = 'Login']");
	private By forgotLink = By.xpath("//a[text() = 'Forgotten Password']");
	private By headerMenu = By.xpath("//span[@class = 'hidden-xs hidden-sm hidden-md']");
	private By rightMenu = By.xpath("//div[@class = 'list-group']/a");
	private By footerSections = By.xpath("//div[@class = 'col-sm-3']/h5");
	private By searchField = By.xpath("//input[@name = 'search' and @class = 'form-control input-lg']");
	private By register = By.linkText("Register");

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Checking Login page title")
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	@Step("Checking availability of search field")
	public boolean isSearchFieldAvailable() {
		return driver.findElement(searchField).isDisplayed();
	}

	@Step("Checking forgot password link")
	public boolean isForgotPasswordLinkExist() {
		return driver.findElement(forgotLink).isDisplayed();
	}

	@Step("Checking header menu count")
	public int getHeaderMenuCount() {
		return driver.findElements(headerMenu).size();
	}

	@Step("Checking header menu list")
	public List<String> getHeaderMenuList() {
		List<String> allMenu = new ArrayList<String>();
		List<WebElement> elem = driver.findElements(headerMenu);
		for (WebElement e : elem) {
			allMenu.add(e.getText());
		}

		return allMenu;
	}

	@Step("Checking Footer Section count")
	public int getFooterSectionCount() {
		return driver.findElements(footerSections).size();
	}

	@Step("Checking Footer Section list")
	public List<String> getFooterSectionList() {
		List<String> sections = new ArrayList<String>();
		List<WebElement> elem = driver.findElements(footerSections);
		for (WebElement e : elem) {
			sections.add(e.getText());
		}

		return sections;
	}

	@Step("Getting right menu count")
	public int getRightMenucount() {
		return driver.findElements(rightMenu).size();
	}

	@Step("Getting Right Menu list")
	public List<String> getRightMenuList() {
		List<String> allMenu = new ArrayList<String>();
		List<WebElement> allRightMenu = driver.findElements(rightMenu);

		for (WebElement elem : allRightMenu) {
			allMenu.add(elem.getText());
		}

		return allMenu;

	}

	@Step("Perform Login By using username : {0} and password : {1}")
	public AccountsPage doLogin(String uname, String password) {
		driver.findElement(username).sendKeys(uname);
		driver.findElement(pword).sendKeys(password);
		driver.findElement(loginBtn).click();

		return new AccountsPage(driver);
	}

	@Step("Navigate To Registration Page")
	public RegistrationPage navigateToRegister() {
		driver.findElement(register).click();
		return new RegistrationPage(driver);
	}

}
