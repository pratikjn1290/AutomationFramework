package com.qa.corpository.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.corpository.base.BaseTest;
import com.qa.corpository.utils.Constants;
import com.qa.corpository.utils.ExcelUtils;

public class RegistrationTest extends BaseTest {

	@BeforeClass
	public void registrationSetup() {
		registerPage = loginPage.navigateToRegister();
	}

	@DataProvider
	public Object[][] getRegistrationData() {
		Object[][] data = ExcelUtils.getData(Constants.REGISTER_SHEETNAME);
		return data;
	}

	@Test(dataProvider = "getRegistrationData")
	public void verifyUserRegistrationDetails(String firstname, String LastName, String EmailId, String Number, String PassWord, String SubScribe) {
		registerPage.accountRegistration(firstname, LastName, EmailId, Number, PassWord, SubScribe);
	}

}
