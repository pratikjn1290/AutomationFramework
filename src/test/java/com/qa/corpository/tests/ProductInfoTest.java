package com.qa.corpository.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.corpository.base.BaseTest;

public class ProductInfoTest extends BaseTest {

	@BeforeClass
	public void ProductInfoSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 0)
	public void productInfo_TitleTest() {
		accountPage.doSearchProdcuct("iMac");
		productInfoPage = accountPage.selectProductFromResults("iMac");
		Assert.assertEquals(productInfoPage.getProductInfoPageTitle("iMac"), "iMac");
	}

	@Test(priority = 1)
	public void verifyProductDetailsTest() {

		Assert.assertTrue(accountPage.doSearchProdcuct("Macbook Pro"));
		productInfoPage = accountPage.selectProductFromResults("Macbook Pro");

		Assert.assertTrue((productInfoPage.getImageCount() > 0));
		Map<String, String> prodInfo = productInfoPage.getProductInformation();
		System.out.println(prodInfo);
		Assert.assertEquals(prodInfo.get("name"), "MacBook Pro");
		Assert.assertEquals(prodInfo.get("Brand"), "Apple");
		Assert.assertEquals(prodInfo.get("price"), "$2,000.00");
		Assert.assertEquals(prodInfo.get("Product Code"), "Product 18");
		Assert.assertEquals(prodInfo.get("Reward Points"), "800");
	}

	@Test(priority = 2)
	public void verifyAddToCartTest() {
		productInfoPage.selectQuantity("1");
		Assert.assertTrue(productInfoPage.addToCart());
	}

}
