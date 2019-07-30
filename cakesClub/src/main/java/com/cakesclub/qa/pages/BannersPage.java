package com.cakesclub.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cakesclub.qa.base.TestBase;

public class BannersPage extends TestBase{
	
	// PageFactory
	
	@FindBy(xpath="//div[@class='bannersView']/div[2]/button")
	WebElement addBnrsBtn;
	@FindBy(xpath="//form[@id='newBannerForm']/input[@name='name']")
	WebElement bnrName;
	@FindBy(xpath="//form[@id='newBannerForm']/textarea[@name='description']")
	WebElement bnrDescription;
	@FindBy(xpath="//form[@id='newBannerForm']/input[@name='banner']")
	WebElement bnrImage;
	@FindBy(xpath="//form[@id='newBannerForm']/input[@type='submit']")
	WebElement bnrSaveBtn;
	@FindBy(xpath="//form[@id='newBannerForm']/a[text()='Cancel']")
	WebElement bnrCancelBtn;
	@FindBy(xpath="//div[@class='bannersView']/div[2]/div/div[@class='card-header']/h6[text()='Banners']")
	WebElement bnrPageName;
	// Update Locator
	@FindBy(xpath="//form[@id='updateBannerForm']/input[@name='name']")
	WebElement updBnrName;
	@FindBy(xpath="//form[@id='updateBannerForm']/textarea[@name='description']")
	WebElement updBnrDesc;
	@FindBy(xpath="//form[@id='updateBannerForm']/input[@name='banner']")
	WebElement updBnrImg;
	@FindBy(xpath="//form[@id='updateBannerForm']/input[@type='submit']")
	WebElement UpdBnrSaveBtn;
	// View Locator
	@FindBy(xpath="//a[contains(text(),'Back to Banners')]")
	WebElement backToBnrBtn;
	// Search Locator
	@FindBy(xpath="//div[@id='example_filter']//following::input[@type='search']")
	WebElement bnrSrchBox;
	
	//Initialize the Page Objects
	public BannersPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateBnrsPageName(){
		return bnrPageName.getText();
		
	}
	public BannersPage addBanners(String name,String description,String image){		
		addBnrsBtn.click();
		bnrName.sendKeys(name);
		bnrDescription.sendKeys(description);
		bnrImage.sendKeys(image);
		bnrSaveBtn.click();
		return new BannersPage();
	}
	public BannersPage activeBanner(){
		return new BannersPage();
	}
	public BannersPage defaultBanner(){
		return new BannersPage();
	}
	
	public BannersPage updateBanners(String updName,String updDesc,String updImage){
		updBnrName.clear();
		updBnrName.sendKeys(updName);
		updBnrDesc.clear();
		updBnrDesc.sendKeys(updDesc);
		updBnrImg.sendKeys(updImage);
		UpdBnrSaveBtn.click();
		
		return new BannersPage();
		
	}
	public BannersPage deleteBanners(){
		driver.switchTo().alert().accept();
		return new BannersPage();
	}
	public BannersPage viewBanners() throws InterruptedException{
		Thread.sleep(2000);
		backToBnrBtn.click();
		return new BannersPage();
	}
	public void searchBanners(String srchBnr){
		bnrSrchBox.sendKeys(srchBnr);
	}
	

}
