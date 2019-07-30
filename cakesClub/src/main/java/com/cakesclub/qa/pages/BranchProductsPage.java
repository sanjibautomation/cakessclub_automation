package com.cakesclub.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cakesclub.qa.base.TestBase;

public class BranchProductsPage extends TestBase{
	
	// Page Objects
	
	@FindBy(xpath="//div[@class='branchView container']/div/div/div/h6")
	WebElement brnProPageName;
	@FindBy(id="branch_id")
	WebElement branchDropdown;
	@FindBy(xpath="//div[@id='branches-body']//following::input[@type='search']")
	WebElement searchBox;
	
	public BranchProductsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateBranProdsPagename(){
		return brnProPageName.getText();
		
	}
	
	public void addBranchProductPage(){
		
		Select branchList = new Select(branchDropdown);
		branchList.selectByVisibleText(prop.getProperty("SelectBranch"));	
		
	}
	public void deleteBranchProdsPageName(){
		Select branchList =  new Select(branchDropdown);
		branchList.selectByVisibleText(prop.getProperty("SelectBranch"));	
	}
	public void updateStockPageName(){
		Select branchList =  new Select(branchDropdown);
		branchList.selectByVisibleText(prop.getProperty("SelectBranch"));
	}
	public void searchFunctionality(){
		searchBox.sendKeys(prop.getProperty("SearchProductName"));
	}

}
