package com.cakesclub.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cakesclub.qa.base.TestBase;

public class BranchesPage extends TestBase{
	// Page Factory
	@FindBy(xpath="//div[@class='branchView container']/div[2]/div/div/h6")
	WebElement branchPageName; 
	@FindBy(xpath="//button[@onclick='addBranch()']")
	WebElement addBranchBtn;
	@FindBy(xpath="//input[@id='name']")
	WebElement branchName;
	@FindBy(xpath="//input[@name='address']")
	WebElement branchAdres;
	@FindBy(xpath="//input[@name='area']")
	WebElement branchArea;
	@FindBy(xpath="//input[@id='state']")
	WebElement branchState;
	@FindBy(xpath="//input[@id='longitude']")
	WebElement branchLongitude;
	@FindBy(xpath="//input[@id='phone_number']")
	WebElement branchPhNum;
	@FindBy(xpath="//input[@id='city']")
	WebElement branchCity;
	@FindBy(xpath="//input[@id='pincode']")
	WebElement branchPinCode;
	@FindBy(xpath="//input[@id='latitude']")
	WebElement branchLatitude;
	@FindBy(xpath="//button[@id='saveAddress']")
	WebElement saveButton;
	
	//Update locators
	@FindBy(xpath="//form[@id='editBranchAddressForm']/div/div/div/input[@id='name']")
	WebElement updBranchName;
	@FindBy(xpath="//form[@id='editBranchAddressForm']/div/div/div/input[@id='phone_number']")
	WebElement updPhoneNumber;
	@FindBy(xpath="//form[@id='editBranchAddressForm']/div/div/div/input[@name='address']")
	WebElement updAddress;
	@FindBy(xpath="//form[@id='editBranchAddressForm']/div/div/div/input[@id='city']")
	WebElement updCity;
	@FindBy(xpath="//form[@id='editBranchAddressForm']/div/div/div/input[@name='area']")
	WebElement updArea;
	@FindBy(xpath="//form[@id='editBranchAddressForm']/div/div/div/input[@id='state']")
	WebElement updState;
	@FindBy(xpath="//form[@id='editBranchAddressForm']/div/div/div/input[@id='pincode']")
	WebElement updPincode;
	@FindBy(xpath="//form[@id='editBranchAddressForm']/div/div/div/input[@id='longitude']")
	WebElement updLongitude;
	@FindBy(xpath="//form[@id='editBranchAddressForm']/div/div/div/input[@id='latitude']")
	WebElement updLatitude;
	@FindBy(xpath="//form[@id='editBranchAddressForm']/div/button[@id='saveAddress']")
	WebElement updSaveBtn;
	
	
	public BranchesPage(){
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	public String validatepageTitle(){
		return branchPageName.getText();
			}
	public void addBranchType(String name, String adress, String area, String state, String longitude, String phNum, String city, String pincode, String latitude){
		addBranchBtn.click();
		branchName.sendKeys(name);
		branchAdres.sendKeys(adress);
		branchArea.sendKeys(area);
		branchState.sendKeys(state);
		branchLongitude.sendKeys(longitude);
		branchPhNum.sendKeys(phNum);
		branchCity.sendKeys(city);
		branchPinCode.sendKeys(pincode);
		branchLatitude.sendKeys(latitude);
		saveButton.click();
		
	}
	public void updateBranchType(String updname, String updadress, String updarea,  String updstate, String updlongitude, String updphNum, String updcity, String updpincode, String updlatitude){
		updBranchName.clear();
		updBranchName.sendKeys(updname);
		updPhoneNumber.clear();
		updPhoneNumber.sendKeys(updphNum);
		updAddress.clear();
		updAddress.sendKeys(updadress);
		updCity.clear();
		updCity.sendKeys(updcity);
		updArea.clear();
		updArea.sendKeys(updarea);
		updState.clear();
		updState.sendKeys(updstate);
		updPincode.clear();
		updPincode.sendKeys(updpincode);
		updLongitude.clear();
		updLongitude.sendKeys(updlongitude);
		updLatitude.clear();
		updLatitude.sendKeys(updlatitude);
		updSaveBtn.click();
	}
	public void deleteBranchType(){
		
		driver.switchTo().alert().accept();
	}
	

}
