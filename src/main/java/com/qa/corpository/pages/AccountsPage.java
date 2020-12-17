package com.qa.corpository.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.corpository.base.BasePage;

public class AccountsPage extends BasePage {

	private WebDriver driver;

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}

	private By sections = By.xpath("//div[@id = 'content']/h2");
	private By header = By.xpath("//a[text() = 'Your Store']");
	private By searchField = By.xpath("//input[@name = 'search' and @class = 'form-control input-lg']");
	private By searchIcon = By.xpath("//button[@type = 'button' and @class = 'btn btn-default btn-lg']");
	private By searchResult = By.cssSelector(".product-layout .product-thumb");
	private By resultItems = By.cssSelector(".product-thumb h4 a");

	public String verifyAccountPageTitle() {
		return driver.getTitle();
	}

	public int verifyAccountSectionCount() {
		return driver.findElements(sections).size();
	}

	public boolean verifySearchfieldAvailability() {
		return driver.findElement(searchField).isDisplayed();
	}

	public boolean verifySearchButtonIsEnabled() {
		return driver.findElement(searchIcon).isEnabled();
	}

	public List<String> verifyAccountSections() {

		List<String> Sections = new ArrayList<String>();
		List<WebElement> sectionList = driver.findElements(sections);
		for (WebElement section : sectionList) {
			Sections.add(section.getText());
		}

		return Sections;
	}

	public String verifyHeader() {
		return driver.findElement(header).getText();
	}

	public boolean doSearchProdcuct(String productName) {

		driver.findElement(searchField).clear();
		driver.findElement(searchField).sendKeys(productName);
		driver.findElement(searchIcon).click();
		if (driver.findElements(searchResult).size() > 0) {
			return true;
		}

		return false;
	}

	public ProductInfoPage selectProductFromResults(String productName) {
		List<WebElement> productResultList = driver.findElements(resultItems);
		for (WebElement resultList : productResultList) {
			if (resultList.getText().equalsIgnoreCase(productName))
				resultList.click();
			break;
		}

		return new ProductInfoPage(driver);
	}

}
