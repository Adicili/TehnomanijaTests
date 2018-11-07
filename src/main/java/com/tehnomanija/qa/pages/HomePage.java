package com.tehnomanija.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tehnomanija.qa.basetest.BaseTest;

public class HomePage extends BaseTest {
	
	//Home Page Repository

	@FindBy(className = "user-name")
	WebElement profilTabLokator;
	
	@FindBy(css = ".input-field.hasLabel.js-input-field.js-header-email")
	WebElement emailFieldLokator;

	@FindBy(css = ".input-field.hasLabel.js-input-field.js-header-password")
	WebElement passFieldLokator;
	
	@FindBy(css = ".wish-list-wrap.js-wish-list-wrap")
	WebElement LoginBtnTabLokator;
	
	@FindBy(xpath = "//a[contains(text(), 'Moj nalog')]")
	WebElement MojNalogBtnLokator;
	
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);			
	}

	public void Login() {
		actions.moveToElement(profilTabLokator);
		emailFieldLokator.sendKeys(prop.getProperty("username"));
		passFieldLokator.sendKeys(prop.getProperty("password"));
		LoginBtnTabLokator.click();
	}
	
	public void UserNameDisplayed() {
		
		
	}
	
	
}
