package com.cakesclub.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cakesclub.qa.base.TestBase;

public class ReviewsPage extends TestBase{
	
	// Page Factory
	@FindBy(xpath="//h6[contains(text(),'Unverified Reviews')]")
	WebElement revPageName;

	@FindBy(xpath="//input[@type='search' and @name='name']")
	WebElement revSearch;

	@FindBy(xpath="//tbody[@id='tbl-reviews-body']//following::a")
	WebElement verifyButton;

	@FindBy(xpath="//a[text()='Unverified Reviews']")
	WebElement unverifiedRevTab;
	@FindBy(xpath="//div[@id='menu1']//following::input[@type='search']")
	WebElement unVerSearchBtn;
	@FindBy(xpath="//div[@id='example_wrapper']/div/div[2]/div[@id='example_filter']/label/input[@type='search']")
	WebElement verSearchBtn;

	public ReviewsPage(){
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	
	public String validateReviewPage(){	
		unverifiedRevTab.click();
		return revPageName.getText();
	}
	
	public void verifyBtnFunctionality(){
		unverifiedRevTab.click();
		int row_Count = driver.findElements(By.xpath("//div[@id='menu1']//following::tbody[@id='tbl-reviews-body']/tr")).size();
		int page_count = driver.findElements(By.xpath("//div[@id='example1_paginate']/ul[@class='pagination']/li")).size();
		int reviewFound = 0;
		String reqReviewerName = prop.getProperty("reqReviewerName");
		String reqProductName = prop.getProperty("reqProName");
		
		outerloop:
		// Clicking on the next number page.
				for(int i =2;i<page_count;i++){	
					driver.findElement(By.xpath("//div[@id='example1_paginate']/ul[@class='pagination']/li["+i+"]")).click();
				for(int j=1;j<=row_Count;j++){
					String actReviewerName = driver.findElement(By.xpath("//div[@id='menu1']//following::tbody[@id='tbl-reviews-body']/tr["+j+"]/td[1]")).getText();					
					String actProdName = driver.findElement(By.xpath("//div[@id='menu1']//following::tbody[@id='tbl-reviews-body']/tr["+j+"]/td[2]")).getText();
				
					
					// Click on verify Button					
						if(actReviewerName.equals(reqReviewerName) && (actProdName.equals(reqProductName))){
						driver.findElement(By.xpath("//tbody[@id='tbl-reviews-body']/tr["+j+"]/td[5]/a")).click();
						reviewFound = 1;							
						break outerloop;
					
					}
				}
			}
		if(reviewFound == 0){
			Assert.fail("ERROR: The Reviewer name "+reqReviewerName+" and the product name "+reqProductName+" not found.");
		}
	}
	public void VerSearchPage(){
		 verSearchBtn.sendKeys(prop.getProperty("reqSrcProdName"));
		 
		
	}
	public void unvrySearchPage(){
		unverifiedRevTab.click();
		unVerSearchBtn.sendKeys(prop.getProperty("reqUnvrfySrchProdName"));
		
	}
}
