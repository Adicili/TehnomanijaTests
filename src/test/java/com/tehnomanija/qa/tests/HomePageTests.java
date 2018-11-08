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
	
	HomePage homePage;
	String sheetName = "Users";
	
	public HomePageTests() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
	}
	
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(dataProvider = "getTestData")
	public void VerifyIfUserIsLoggedIn(String email, String password, String username){
 		homePage.Login(email, password);
		Assert.assertTrue(homePage.UserNameDisplayed(username), "User name is not displayed!!");		
	}
	
	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}

}
