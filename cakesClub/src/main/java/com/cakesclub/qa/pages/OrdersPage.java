package com.cakesclub.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cakesclub.qa.base.TestBase;

public class OrdersPage extends TestBase {
	//Page Objects
	@FindBy(xpath="//h6[contains(text(),'Orders')]")
	WebElement OrdersPageName;
	@FindBy(xpath="//div[@id='paymentDetailsModal']//following::button")
	WebElement paymentPopUpCloseBtn;
	@FindBy(xpath="//a[text()='Back']")
	WebElement viewOrdBackBtn;
	@FindBy(xpath="//div[@id='example_orders_wrapper']//following::input[@type='search']")
	WebElement searchOrder;
	@FindBy(xpath="//div[@id='example1_orders_filter']//following::input[@type='search']")
	WebElement searchFailedOrder;
	
	@FindBy(xpath="//div[@id='orders-body']//following::a[text()='Failed orders']")
	WebElement failedOrdTab;
	
	public OrdersPage(){
		PageFactory.initElements(driver, this);
	}
	
	// Actions:
	public String validateOrdersPageName(){
		return OrdersPageName.getText();
	}
	public OrdersPage paymentOrders() throws InterruptedException{
		Thread.sleep(5000);
		paymentPopUpCloseBtn.click();
		return new OrdersPage();
		
	}
	public OrdersPage viewOrders() throws InterruptedException{
		Thread.sleep(5000);
		viewOrdBackBtn.click();
		return new OrdersPage();
		
	}
	// Track Order page is showing order
//	public OrdersPage trackOrders() throws InterruptedException{
//		Thread.sleep(5000);
//	
//		return new OrdersPage();
//		
//	}
	
	public OrdersPage searchOrder(){
		searchOrder.sendKeys(prop.getProperty("ReqSearchOrder"));
		return new OrdersPage();
	}
	public void failedViewOrder() throws InterruptedException{
		failedOrdTab.click();
		int row_Count = driver.findElements(By.xpath("//tbody[@id='offer-products-body']/tr")).size();
		int page_count = driver.findElements(By.xpath("//div[@id='example1_orders_wrapper']/div[3]/div[2]/div/ul[@class='pagination']/li")).size();
		int orderFound = 0;
		String reqOrderID = prop.getProperty("ReqOrderId");
		outerloop:
		// Clicking on the next number page.
				for(int i =2;i<page_count;i++){
					driver.findElement(By.xpath("//div[@id='example1_orders_wrapper']/div[3]/div[2]/div/ul[@class='pagination']/li["+i+"]")).click();
				for(int j=1;j<=row_Count;j++){					
					String orderID = driver.findElement(By.xpath("//tbody[@id='offer-products-body']/tr["+j+"]/td[1]")).getText();
	
					
					// Click on view Order					
						if(orderID.equals(reqOrderID)){
							orderFound = 1;	
						driver.findElement(By.xpath("//tbody[@id='offer-products-body']/tr["+j+"]/td[4]/input[@type='button']")).click();
						Thread.sleep(5000);
						viewOrdBackBtn.click();
						break outerloop;
					}
					}
					
						}
		if(orderFound == 0){
			Assert.fail("ERROR: The orderID with name "+reqOrderID+" not found.");
		}
							
					
	
}
	
	public void searchFailedOrder(){
		failedOrdTab.click();
		searchFailedOrder.sendKeys(prop.getProperty("reqSearchFailedOrder"));
	}
	}
