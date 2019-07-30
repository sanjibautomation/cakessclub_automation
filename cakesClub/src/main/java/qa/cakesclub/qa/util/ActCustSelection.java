package qa.cakesclub.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ActCustSelection {
	public void SelectCustomer(WebDriver driver, String custMobile, int custFunctionality){		
		driver.findElement(By.xpath("//a[text()='Account Users']")).click();
		int row_Count = driver.findElements(By.xpath("//table[@id='example1']/tbody/tr")).size();		
		int page_count = driver.findElements(By.xpath("//div[@id='example1_paginate']/ul/li")).size();
		int actCustFound = 0;
		outerloop:
		// Clicking on the next number page.
			for(int i =2;i<page_count;i++){
				driver.findElement(By.xpath("//div[@id='example1_paginate']/ul/li["+i+"]/a")).click();
			for(int j=1;j<=row_Count;j++){
				String actCustMobileNo = driver.findElement(By.xpath("//table[@id='example1']/tbody/tr["+j+"]/td[3]")).getText();				
				// Click on view button
				if(custFunctionality == 1){
					if(actCustMobileNo.equals(custMobile)){
					driver.findElement(By.xpath("//table[@id='example1']/tbody/tr["+j+"]/td[4]/button[text()='View']")).click();
					actCustFound = 1;							
					break outerloop;
				}
				}
				// Click on orders button
				if(custFunctionality == 2){
					if(actCustMobileNo.equals(custMobile)){
						driver.findElement(By.xpath("//table[@id='example1']/tbody/tr["+j+"]/td[4]/button[text()='Orders']")).click();
						actCustFound = 1;							
						break outerloop;
					}
					
				}
				
				
			}	
	}
	if(actCustFound == 0){
		Assert.fail("ERROR: The active customer mobile number with number "+custMobile+" is not found.");
	}
}
}


