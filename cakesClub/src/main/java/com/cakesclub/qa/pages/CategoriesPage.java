package com.cakesclub.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cakesclub.qa.base.TestBase;

public class CategoriesPage extends TestBase{
	
	// Page factory
	// Locator for Add,Edit and delete
	
	@FindBy(xpath="//div[@class='card-header']/h6[text()='Categories']")
	WebElement ctryPageName;
	@FindBy(xpath="//button[@onclick='AddCategory()']")
	WebElement addCtryBtn;
	@FindBy(id="txtCategory")
	WebElement ctryTextBox;
	@FindBy(xpath="//form[@id='newCategoryForm']//button[contains(text(),'Submit')] ")
	WebElement saveCtryBtn;
	@FindBy(xpath="//button[@onclick='AddSubCategory()']")
	WebElement addSubCtryBtn;
	@FindBy(xpath="//button[@onclick='EditCategory()']")
	WebElement editBtn;
	@FindBy(xpath="//button[@onclick='DeleteCategory()']")
	WebElement deleteBtn;
	// update category Locator
	@FindBy(xpath="//form[@id='editCategoryForm']/child::input[@id='catName']")
	WebElement updCtryTextBox;
	@FindBy(xpath="//form[@id='editCategoryForm']/child::button[text()='Submit']")
	WebElement updSaveBtn;
	//Add SubCategory Locator
	@FindBy(id="txtCategory")
	WebElement subctryTextBox;
	@FindBy(xpath="//form[@id='newCategoryForm']//button[contains(text(),'Submit')] ")
	WebElement savesubCtryBtn;
	//Update SubCategory Locator
	@FindBy(xpath="//form[@id='editCategoryForm']/input[@id='catName']")
	WebElement updateSubctryTextBox;
	@FindBy(xpath="//form[@id='editCategoryForm']/button[text()='Submit']")
	WebElement updSaveSubctryBtn;
	//Delete SubCategory Locator
	@FindBy(xpath="//button[@onclick='DeleteCategory()']")
	WebElement deleteSubctryBtn;
	
	

	//Initialize the Page Objects
		public CategoriesPage(){
			PageFactory.initElements(driver, this);
		}
	// Actions
		public String validateCategoryPage(){
			return ctryPageName.getText();
		}
		public CategoriesPage addCategoryPage(String catName){
			addCtryBtn.click();
			ctryTextBox.sendKeys(catName);
			saveCtryBtn.click();
			return new CategoriesPage();
		}
		public void updateCategoryPage(String categoryName){
			updCtryTextBox.clear();
			updCtryTextBox.sendKeys(categoryName);
			updSaveBtn.click();
			
			
		}
		public CategoriesPage deleteCategoryPage(){
			driver.switchTo().alert().accept();
			return new CategoriesPage();
		}
		public void addSubCategoryPage(String subCategoryName){
			subctryTextBox.sendKeys(subCategoryName);
			savesubCtryBtn.click();
		}
		public void updateSubCategoryPage(String subCategoryName){
			updateSubctryTextBox.clear();
			updateSubctryTextBox.sendKeys(subCategoryName);
			updSaveSubctryBtn.click();
			
		}
		public void deleteSubCategoryPage(){
			driver.switchTo().alert().accept();
		}
		
}
