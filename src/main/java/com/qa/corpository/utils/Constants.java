package com.qa.corpository.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public static final String EXCEL_PATH = ".\\src\\main\\java\\com\\qa\\corpository\\testdata\\TutorialsNinjaTestData.xlsx";
	public static final String REGISTER_SHEETNAME = "Registration";
	public static final String REGISTRATION_SUCCESS_MESSAGE = "Your Account Has Been Created!";
	public static final String ADDTOCARTPAGE_TITLE = "Shopping Cart";
	
	public static final int PRODMODEL = 1;
	public static final int PRODQUANTITY = 2;
	public static final int PRODUNITPRICE = 3;
	public static final int PRODTOTAL = 4;
		// Login Page List and Other Constants
	public static final String LOGIN_PAGE_TITLE = "Account Login";

	public static List<String> headerMenuList() {
		List<String> menulist = new ArrayList<String>();
		menulist.add("Currency");
		menulist.add("123456789");
		menulist.add("My Account");
		menulist.add("Wish List (0)");
		menulist.add("Shopping Cart");
		menulist.add("Checkout");

		return menulist;
	}

	public static List<String> rightMenuList() {
		List<String> rightMenuList = new ArrayList<String>();
		rightMenuList.add("Login");
		rightMenuList.add("Register");
		rightMenuList.add("Forgotten Password");
		rightMenuList.add("My Account");
		rightMenuList.add("Address Book");
		rightMenuList.add("Wish List");
		rightMenuList.add("Order History");
		rightMenuList.add("Downloads");
		rightMenuList.add("Recurring payments");
		rightMenuList.add("Reward Points");
		rightMenuList.add("Returns");
		rightMenuList.add("Transactions");
		rightMenuList.add("Newsletter");

		return rightMenuList;
	}

	public static List<String> footerSectionList() {
		List<String> sections = new ArrayList<String>();
		sections.add("Information");
		sections.add("Customer Service");
		sections.add("Extras");
		sections.add("My Account");

		return sections;
	}

	// Constants and some other methods for accounts page

	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String ACCOUNT_PAGE_HEADER = "Your Store"; 

	public static List<String> sectionList() {
		List<String> sections = new ArrayList<String>();
		sections.add("My Account");
		sections.add("My Orders");
		sections.add("My Affiliate Account");
		sections.add("Newsletter");

		return sections;
	}

}
