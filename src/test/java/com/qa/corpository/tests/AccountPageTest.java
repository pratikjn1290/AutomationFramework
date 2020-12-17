package com.qa.corpository.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.corpository.base.BaseTest;
import com.qa.corpository.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("US:300 Design Account Page Test")
@Story("US:301 Account page functioanlity")
public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void AccountPagesetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}	
	@Test(priority = 1)
	@Description("This will check title of the Accounts page")
	public void accountPageTitleTest() {

		String title = accountPage.verifyAccountPageTitle();
		Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
	}

	@Test(priority = 2)
	@Description("This will check Account Section count")
	public void accountPageSectionCountTest() {
		Assert.assertTrue(accountPage.verifyAccountSectionCount() > 0);
	}

	@Test(priority = 3)
	@Description("This will check section list of Accounts page")
	public void accountPageSectionListTest() {
		Assert.assertEquals(accountPage.verifyAccountSections(), Constants.sectionList());
	}

	@Test(priority = 4)
	@Description("This will check headers on Accounts page")
	@Severity(SeverityLevel.NORMAL)
	public void accountPageHeaderTest() {

		String header = accountPage.verifyHeader();
		Assert.assertEquals(header, Constants.ACCOUNT_PAGE_HEADER);
	}

	@Test(priority = 5)
	@Severity(SeverityLevel.NORMAL)
	@Description("This will check availability of search field on Accounts page")
	public void accountSearchFieldAvailablityTest() {
		Assert.assertTrue(accountPage.verifySearchfieldAvailability());
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 6)
	@Description("This will check search field is enabled Accounts page")
	public void accountSearchFieldEnabledTest() {
		Assert.assertTrue(accountPage.verifySearchButtonIsEnabled());
	}

	@Test(priority = 7)
	@Severity(SeverityLevel.NORMAL)
	@Description("This will check product search of the Accounts page")
	public void productSearchTest() {
		Assert.assertTrue(accountPage.doSearchProdcuct("iMac"));
	}

}
