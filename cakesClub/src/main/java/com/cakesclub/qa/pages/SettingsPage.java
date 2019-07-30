package com.cakesclub.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cakesclub.qa.base.TestBase;

public class SettingsPage extends TestBase {
	
	// Page Factory
	//Add MenuItem Locators
	@FindBy(xpath="//button[@class='btn btn-primary btn-sm']")
	WebElement addSettingBtn;
	@FindBy(xpath="//div[@class='settings-div']/div/div/h6[text()='Navbar Settings']")
	WebElement SetPageName;
	@FindBy(xpath="//input[@id='menuItem']")
	WebElement menuTxtBox;
	@FindBy(xpath="//form[@id='addMenuItemForm']/button[text()='Submit']")
	WebElement menuSubmitBtn;
	
	//update Menu Item Locators
	@FindBy(xpath="//form[@id='editMenuItemForm']/input[@id='name']")
	WebElement updateMenuTxtBox;
	@FindBy(xpath="//form[@id='editMenuItemForm']/button[@type='submit']")
	WebElement updateSubmitBtn;
	
	// Add SubMenu Item Locators
	@FindBy(xpath="//button[contains(text(),'Add Sub Menu Item')]")
	WebElement addSubMenuBtn;
	@FindBy(xpath="//form[@id='addsubMenuItemForm']//input[@name='name']")
	WebElement subMenuTxtBox;
	@FindBy(xpath="//form[@id='addsubMenuItemForm']//button[@type='submit']")
	WebElement subMenuSubmitBtn;
	
	// Update Sub menu Item Locators
	@FindBy(xpath="//form[@id='editSubMenuItemForm']/input[@id='sub_name']")
	WebElement updateSubMenuTxtBox;
	@FindBy(xpath="//form[@id='editSubMenuItemForm']/button[@type='submit']")
	WebElement updateSubMenuSubmitBtn;
	
	
	//Initialize the Page Objects
	public SettingsPage(){
		PageFactory.initElements(driver, this);
	}
	// Actions
	public String stgPageValidation(){
		return SetPageName.getText();
	}
	public void addMenuItemPage(String menuText){
		addSettingBtn.click();
		menuTxtBox.sendKeys(menuText);
		menuSubmitBtn.click();
		
	}
	public void updateMenuItemPage(String updMenuText){
		updateMenuTxtBox.clear();
		updateMenuTxtBox.sendKeys(updMenuText);
		updateSubmitBtn.click();
	}
	public void deleteMenuItemPage(){
		driver.switchTo().alert().accept();
	}
	public void addSubMenuItemPage(String subMenu){
		addSubMenuBtn.click();
		subMenuTxtBox.sendKeys(subMenu);
		subMenuSubmitBtn.click();
	}
	public void updateSubMenuItemPage(String updSubmenu){		
		updateSubMenuTxtBox.clear();
		updateSubMenuTxtBox.sendKeys(updSubmenu);
		updateSubMenuSubmitBtn.click();
		
	}
	public void deleteSubMenuItemPage(){
		driver.switchTo().alert().accept();
		
	}
	
	
	

}
