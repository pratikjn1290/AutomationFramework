package com.qa.corpository.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.corpository.base.BaseTest;
import com.qa.corpository.utils.Constants;

public class AddToCartTest extends BaseTest {

	@BeforeClass
	public void addToCartPageSetUp() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 0)
	public void verifyAddToCartPageTitleTest() {
		addToCartPage = productInfoPage.navigateToViewCart();
		String title = addToCartPage.addToCartTitle();
		Assert.assertEquals(title, Constants.ADDTOCARTPAGE_TITLE);
	}

	@Test(priority = 1)
	public void verifyProductNameTest() {
		String result = addToCartPage.getProductName("MacBook Pro");
		Assert.assertEquals(result, "MacBook Pro");

	}

	@Test(priority = 2)
	public void verifyProductModelTest() {
		String model = addToCartPage.getProductModel();
		Assert.assertEquals(model, "Model 18");

	}

	@Test(priority = 3)
	public void verifyProductQuantityTest() {

		String quantity = addToCartPage.getProductQuantity();
		Assert.assertEquals(quantity, "1");

	}

	@Test(priority = 4)
	public void verifyProductPriceTest() {

		String price = addToCartPage.getProductPriceTotal();
		Assert.assertEquals(price, "$2,000.00");
	}

	@Test(priority = 5)
	public void verifyProductUnitPriceTest() {
		String unitPrice = addToCartPage.getProductUnit();
		Assert.assertEquals(unitPrice, "$2,000.00");
	}

}
