package com.cakesclub.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cakesclub.qa.base.TestBase;

public class CustomersPage extends TestBase{
	@FindBy(xpath="//a[text()='Account Users']")
	public WebElement activeUserTab;
	@FindBy(xpath="//div[@id='customers-body']/div/div/h6")
	WebElement pageName;
	@FindBy(xpath="//div[@id='products-body']//following::a[text()='Back']")
	WebElement BackBtn;
	@FindBy(xpath="//div[@id='example1_filter']//following::input")
	WebElement accUserSearch;
	
	public CustomersPage(){
		PageFactory.initElements(driver, this);
	}

	// Actions	
	public String validatePageName(){
	activeUserTab.click();
	return pageName.getText();
	}
	
	public void viewAccUsersPage(){
	BackBtn.click();
	}
	public void orderAccUsersPage(){
		
	}
	public void accUserSearchFunctionality(){
		activeUserTab.click();
		accUserSearch.sendKeys(prop.getProperty("ReqAccUserSrchValue"));
	}

}
