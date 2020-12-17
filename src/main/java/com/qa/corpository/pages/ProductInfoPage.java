package com.qa.corpository.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.corpository.base.BasePage;

public class ProductInfoPage extends BasePage {

	private WebDriver driver;

	/**
	 * Locators for Product Info
	 */

	private By productImage = By.cssSelector(".thumbnails li img");
	private By productNameHeader = By.xpath("//div[@class = 'col-sm-4']/h1");
	private By productMetaData = By.cssSelector("#content .list-unstyled:nth-of-type(1) li");
	private By productPrice = By.cssSelector("#content .list-unstyled:nth-of-type(2) li");
	private By quantity = By.id("input-quantity");
	private By addToCartBtn = By.id("button-cart");
	private By successMessage = By.xpath("//div[@class = 'alert alert-success alert-dismissible']");
	private By viewCartDetails = By.xpath("//ul[@class = 'list-inline']/li//span[text()= 'Shopping Cart']");

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getProductInfoPageTitle(String prodName) {
		return driver.getTitle();
	}

	public int getImageCount()

	{
		return driver.findElements(productImage).size();
	}

	public HashMap<String, String> getProductInformation() {
		HashMap<String, String> productInfo = new HashMap<String, String>();
		productInfo.put("name", driver.findElement(productNameHeader).getText().trim());

		List<WebElement> productMedaDataList = driver.findElements(productMetaData);
		for (WebElement productInfoData : productMedaDataList) {
			productInfo.put(productInfoData.getText().split(":")[0].trim(),
					productInfoData.getText().split(":")[1].trim());

		}

		List<WebElement> productPriceData = driver.findElements(productPrice);
		productInfo.put("price", productPriceData.get(0).getText().trim());
		productInfo.put("ExTaxPrice", productPriceData.get(1).getText().split(":")[1].trim());

		return productInfo;
	}

	public void selectQuantity(String quantityValue) {
		driver.findElement(quantity).clear();
		driver.findElement(quantity).sendKeys(quantityValue);
	}

	public boolean addToCart() {
		driver.findElement(addToCartBtn).click();
		String title = driver.findElement(successMessage).getText();
		if (title.contains("Success:")) {
			return true;
		}

		return false;
	}

	public AddToCartPage navigateToViewCart() {
		driver.findElement(viewCartDetails).click();
		return new AddToCartPage(driver);

	}

}
