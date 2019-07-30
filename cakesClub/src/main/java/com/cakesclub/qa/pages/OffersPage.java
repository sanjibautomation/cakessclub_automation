package com.cakesclub.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cakesclub.qa.base.TestBase;

public class OffersPage extends TestBase{
	
	// Page Factory
	
	@FindBy(xpath="//h6[contains(text(),'Offers by category')]")
	WebElement ofrsPageName;
	@FindBy(xpath="//input[@name='discountType' and @value='1']")
	WebElement discByPerRadBtn;
	@FindBy(xpath="//input[@name='discountType' and @value='2']")
	WebElement discByValRadBtn;
	@FindBy(xpath="//input[@id='discount_val' ]")
	WebElement discValueTxtBox;
	@FindBy(xpath="//input[@id='datepick']")
	WebElement expDateBox;
	@FindBy(xpath="//form[@id='offersForm']//following::button[@type='submit']")
	WebElement OfrsCatSaveBtn;
	
	public OffersPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateOffersPageName(){
		//ofrsByCatTab.click();
		return ofrsPageName.getText();
	}
	
	public void updateOfferByCat() throws InterruptedException{
		//Based on the check box selection, check the another check box and update the offer details
		if(discByPerRadBtn.isSelected()){
			discByValRadBtn.click();
			discValueTxtBox.clear();
			discValueTxtBox.sendKeys("30");
			expDateBox.clear();
			driver.findElement(By.xpath("//div[@id='datetimepicker1']/div/div")).click();
			Thread.sleep(3000);
		
			//expDateBox.sendKeys("07/25/2019 12:09:59");
			driver.findElement(By.cssSelector("#datepick")).sendKeys("2019-07-25");
			OfrsCatSaveBtn.click();
		}
		else{
			
		}
		discByPerRadBtn.click();
		discValueTxtBox.clear();
		discValueTxtBox.sendKeys("30");
		expDateBox.clear();
		driver.findElement(By.xpath("//div[@id='datetimepicker1']/div/div")).click();
		Thread.sleep(3000);
		
		//expDateBox.sendKeys("2019-07-28 11:09:59");
		driver.findElement(By.cssSelector("#datepick")).sendKeys("2019-07-25");
		OfrsCatSaveBtn.click();
	}
	
}
