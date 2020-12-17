package com.qa.corpository.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.corpository.base.BasePage;
import com.qa.corpository.utils.Constants;

public class RegistrationPage extends BasePage {

	private WebDriver driver;

	public RegistrationPage(WebDriver driver) {

		this.driver = driver;

	}

	// Locators for login page

	private By firstName = By.cssSelector("#input-firstname");
	private By lastName = By.cssSelector("#input-lastname");
	private By eMail = By.cssSelector("#input-email");
	private By telePhone = By.cssSelector("#input-telephone");
	private By password = By.cssSelector("#input-password");
	private By confirmPassword = By.cssSelector("#input-confirm");
	private By subscribeYes = By.xpath("//label[@class = 'radio-inline'][position() = 1]/input");
	private By subscribeNo = By.xpath("//label[@class = 'radio-inline'][position() = 2]/input");
	private By termCheckBox = By.xpath("//input[@type = 'checkbox' and @name = 'agree']");
	private By continueBtn = By.xpath("//input[@type = 'submit' and @class = 'btn btn-primary']");
	private By accountSuccess = By.xpath("//div[@id = 'content' and @class = 'col-sm-9']/h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.xpath("//a[@class = 'list-group-item' and text() = 'Register']");

	public boolean accountRegistration(String fname, String lName, String emailId, String number, String pword,
			String subScribe) {
		driver.findElement(firstName).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lName);
		driver.findElement(eMail).sendKeys(emailId);
		driver.findElement(telePhone).sendKeys(number);
		driver.findElement(password).sendKeys(pword);
		driver.findElement(confirmPassword).sendKeys(pword);

		if (subScribe.equalsIgnoreCase("yes")) {
			driver.findElement(subscribeYes).click();
		} else {
			driver.findElement(subscribeNo).click();
		}

		driver.findElement(termCheckBox).click();
		driver.findElement(continueBtn).click();
		String title = driver.findElement(accountSuccess).getText();
		if (title.contains(Constants.REGISTRATION_SUCCESS_MESSAGE)) {
			driver.findElement(logoutLink).click();
			driver.findElement(registerLink).click();
			return true;
		} else {
			return false;
		}
	}
}
