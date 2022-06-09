package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	// Page factory or Object Repository
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement pass;
	
	@FindBy(linkText="Login")
	WebElement login;
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	WebElement logo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);//initializing page objects
	}
	
	
	
	
	

	

}
