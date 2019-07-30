package qa.cakesclub.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PaidOrderSelection {
	public void selectOrder(WebDriver driver,String ordID,int orderFunctionality) throws InterruptedException{
		int row_Count = driver.findElements(By.xpath("//tbody[@id='category-body']/tr")).size();
		int page_count = driver.findElements(By.xpath("//div[@id='example_orders_paginate']/ul[@class='pagination']/li")).size();
		int orderFound = 0;
		outerloop:
		// Clicking on the next number page.
				for(int i =2;i<page_count;i++){
					driver.findElement(By.xpath("//div[@id='example_orders_paginate']/ul[@class='pagination']/li["+i+"]")).click();
				for(int j=1;j<=row_Count;j++){
					String orderID = driver.findElement(By.xpath("//tbody[@id='category-body']/tr["+j+"]/td[1]")).getText();
					// Click on payment Details
					if(orderFunctionality == 1){
						if(orderID.equals(ordID)){
						driver.findElement(By.xpath("//tbody[@id='category-body']/tr["+j+"]/td[4]/a")).click();
						orderFound = 1;							
						break outerloop;
					}
					}
					// Click on View Order
					if(orderFunctionality == 2){
						if(orderID.equals(ordID)){
							driver.findElement(By.xpath("//tbody[@id='category-body']/tr["+j+"]/td[6]/input[@type='button']")).click();
							orderFound = 1;							
							break outerloop;
						}
						
					}
					
					// Click on Track Order
					if(orderFunctionality == 3){
						if(orderID.equals(ordID)){
							driver.findElement(By.xpath("//tbody[@id='category-body']/tr["+j+"]/td[7]/a[text()='Track Order']")).click();
							orderFound = 1;							
							break outerloop;
						}
						
					}
				}	
		}
		if(orderFound == 0){
			Assert.fail("ERROR: The OrderId with name "+ordID+" is not found.");
		}
	}

}
