package com.tehnomanija.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tehnomanija.qa.basetest.BaseTest;
import com.tehnomanija.qa.util.TestUtil;

public class HomePage extends BaseTest {
	
	TestUtil testUtil;
	
	//Home Page Repository

	@FindBy(className = "user-name")
	WebElement profilTabLokator;
	
	@FindBy(css = ".input-field.hasLabel.js-input-field.js-header-email")
	WebElement emailFieldLokator;

	@FindBy(css = ".input-field.hasLabel.js-input-field.js-header-password")
	WebElement passFieldLokator;
	
	@FindBy(css = ".wish-list-wrap.js-wish-list-wrap")
	WebElement wishListLokator;
	
	@FindBy(className = "login-button")
	WebElement loginBtnLokator;
	
	@FindBy(xpath = "//a[contains(text(), 'Moj nalog')]")
	WebElement mojNalogBtnLokator;
	
	
	public HomePage() {
		testUtil = new TestUtil();
		PageFactory.initElements(driver, this);			
	}

	public void Login(String email, String password) {
		actions.moveToElement(profilTabLokator).build().perform();
		emailFieldLokator.sendKeys(email);
		passFieldLokator.sendKeys(password);
		loginBtnLokator.click();
	}
	
	public boolean UserNameDisplayed(String expectedUserName){
		
		testUtil.Sleep(2);
	
		String userName = profilTabLokator.getText().toLowerCase();
		
		if(userName.equals(expectedUserName)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
}
