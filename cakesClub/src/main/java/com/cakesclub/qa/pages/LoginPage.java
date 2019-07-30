package com.cakesclub.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cakesclub.qa.base.TestBase;

public class LoginPage extends TestBase{
	// Page Factory
	@FindBy(id="email")
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	//Initializing the page objects
	 public LoginPage(){
		 PageFactory.initElements(driver, this);
	 }
	//Actions
	 public String validateLoginPageTitle(){
		 return driver.getTitle();
	 } 
	public DashBoardPage login(String un,String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new DashBoardPage();
		
	}
	 
	

}
