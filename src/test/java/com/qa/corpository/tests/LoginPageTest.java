package com.qa.corpository.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.corpository.base.BaseTest;
import com.qa.corpository.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("US:200 Login feature")
@Story("US:201 Design Login page test")
public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	@Description("This will check login page title")
	@Severity(SeverityLevel.NORMAL)
	public void verifyLoginPageTitleTest() {

		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	@Description("This will check availability of search field")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void verifySerachFieldAvaibility() {
		Assert.assertTrue(loginPage.isSearchFieldAvailable());
	}

	// Header Menu test case

	@Test(priority = 3)
	@Description("This will check header menu link")
	@Severity(SeverityLevel.NORMAL)
	public void verifyHeaderMenuLink() {
		Assert.assertTrue(loginPage.getHeaderMenuCount() > 0);
	}

	@Test(priority = 4)
	@Description("This will check Header Menu List")
	@Severity(SeverityLevel.NORMAL)
	public void verifyHeaderMenuList() {
		List<String> menuLinkList = loginPage.getHeaderMenuList();
		Assert.assertEquals(menuLinkList, Constants.headerMenuList());
	}

	// Right Menu test case

	@Test(priority = 5)
	@Description("This will checkRigh side Menu")
	@Severity(SeverityLevel.NORMAL)
	public void verifyRightMenucount() {
		Assert.assertTrue(loginPage.getRightMenucount() > 0);
	}

	@Test(priority = 6)
	@Description("This will check right menu list")
	@Severity(SeverityLevel.NORMAL)
	public void verifyRightMenuList() {
		Assert.assertEquals(loginPage.getRightMenuList(), Constants.rightMenuList());
	}

	// Footer Menu test case

	@Test(priority = 7)
	@Description("This will check Footer Section count")
	@Severity(SeverityLevel.MINOR)
	public void verifyFooterSectioncount() {
		Assert.assertTrue(loginPage.getFooterSectionCount() > 0);
	}

	@Test(priority = 8)
	@Description("This will check Footer Section List")
	@Severity(SeverityLevel.MINOR)
	public void verifyFooterSectionList() {
		Assert.assertEquals(loginPage.getFooterSectionList(), Constants.footerSectionList());
	}

	@Test(priority = 9)
	@Description("This will check login with valid username and password Test")
	@Severity(SeverityLevel.BLOCKER)
	public void verifyLoginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
