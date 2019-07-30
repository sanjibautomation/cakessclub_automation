package com.cakesclub.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.cakesclub.qa.base.TestBase;


public class DeliveryDetailsPage extends TestBase{
	//Page Factory
	//Add record objects
	@FindBy(xpath="//div[@class='container deliveryView']/button[@onclick='AddDeliveryType()']")
	WebElement addDeliveryRecordBtn;
	@FindBy(xpath="//div[@class='container deliveryView']/div[2]/div/h6[text()='Delivery Types']")
	WebElement dlvryPageName;
	@FindBy(id="deliveryChange")
	WebElement addDelTypeDrpDown;
	@FindBy(id="start_time")
	WebElement addStartTime;
	@FindBy(id="end_time")
	WebElement addEndTime;
	@FindBy(id="charge")
	WebElement addChargeTxtBox;
	@FindBy(xpath="//button[@class='btn btn-primary btn-sm btn-save float-right']")
	WebElement DeliveryRecordSaveBtn;
	
	//Update record objects
	@FindBy(id="deliveryChange")
	WebElement updDelTypeDrpDown;
	@FindBy(id="start_time")
	WebElement updStartTime;
	@FindBy(id="end_time")
	WebElement updEndTime;
	@FindBy(id="charge")
	WebElement updChargeTxtBox;
	@FindBy(xpath="//button[@class='btn btn-primary btn-sm btn-save float-right']")
	WebElement updDeliveryRecordSaveBtn;
	
	// Initialize the Page Objects
		public DeliveryDetailsPage(){
			PageFactory.initElements(driver, this);
		}
	// Actions
	public String dlvryDetailsPageValidation(){
		return dlvryPageName.getText();
	}
	
	
	public void addDeliveryRecord() throws InterruptedException{
		addDeliveryRecordBtn.click();
		Select itemList=new Select(addDelTypeDrpDown);
		itemList.selectByVisibleText("Morning Delivery");
		addStartTime.sendKeys("09:00AM");
		addEndTime.sendKeys("11:00AM");
		addChargeTxtBox.sendKeys("100");
		Thread.sleep(2000);
		DeliveryRecordSaveBtn.click();
		
	}
	public void updateDeliveryRecord(){
		Select itemList = new Select(updDelTypeDrpDown);
		itemList.selectByVisibleText("Morning Delivery");
		updStartTime.clear();
		updStartTime.sendKeys("09:40AM");
		updEndTime.clear();
		updEndTime.sendKeys("11:45AM");
		updChargeTxtBox.clear();
		updChargeTxtBox.sendKeys("1000");
		updDeliveryRecordSaveBtn.click();
	}
	public void deleteDeliveryRecord(){
		driver.switchTo().alert().accept();
	}
	
}
