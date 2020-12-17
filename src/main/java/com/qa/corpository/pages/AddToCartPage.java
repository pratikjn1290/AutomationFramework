package com.qa.corpository.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.corpository.base.BasePage;

public class AddToCartPage extends BasePage {

	private WebDriver driver;
	private String productNamedata;

	private By productName = By.xpath("//div[@class = 'table-responsive']//a[text() = '" + productNamedata + "']");
	private By prodModel = By.xpath("//div[@class = 'table-responsive']//a[text() = '" + productNamedata
			+ "']//parent::td//following-sibling::td[1]");
	private By prodQuantity = By.xpath("//div[@class = 'table-responsive']//a[text() = '" + productNamedata
			+ "']//parent::td//following-sibling::td[2]");
	private By unitPrice = By.xpath("//div[@class = 'table-responsive']//a[text() = '" + productNamedata
			+ "']//parent::td//following-sibling::td[3]");
	private By total = By.xpath("//div[@class = 'table-responsive']//a[text() = '" + productNamedata
			+ "']//parent::td//following-sibling::td[4]");

	private By checkOutBtn = By.xpath("//a[text() = 'Checkout' and @class = 'btn btn-primary']");

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String addToCartTitle() {
		return driver.getTitle();
	}

	public String getProductName(String prodName) {
		productNamedata = prodName;
		String productNames = driver.findElement(productName).getText();
		return productNames;
	}

	public String getProductModel() {
		String pModel = driver.findElement(prodModel).getText();
		return pModel;
	}

	public String getProductUnit() {
		String pPrice = driver.findElement(unitPrice).getText();
		return pPrice;
	}

	public String getProductQuantity() {
		String productQuantity = driver.findElement(prodQuantity).getText();
		return productQuantity;
	}

	public String getProductPriceTotal() {
		String productPrice = driver.findElement(total).getText();
		return productPrice;
	}

	public CheckOutPage navigateTocheckOut() {
		driver.findElement(checkOutBtn).click();
		return new CheckOutPage(driver);
	}

}