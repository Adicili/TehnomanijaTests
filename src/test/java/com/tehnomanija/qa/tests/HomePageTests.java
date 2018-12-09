package com.tehnomanija.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tehnomanija.qa.basetest.BaseTest;
import com.tehnomanija.qa.pages.HomePage;
import com.tehnomanija.qa.util.TestUtil;

public class HomePageTests extends BaseTest{
	
	TestUtil testUtil;
	HomePage homePage;
	String sheetName = "Users";
	
	public HomePageTests() {		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		testUtil = new TestUtil();
	}
	
	/*@DataProvider
	public Object[][] getTestData(){
		Object data[][] = testUtil.getTestData(sheetName);
		return data;
	}*/
	
	
	@Test
	public void VerifyIfUserIsLoggedIn(){
 		homePage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.UserNameDisplayed("mirko"), "User name is not displayed!!");		
	}
	
	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}

}
