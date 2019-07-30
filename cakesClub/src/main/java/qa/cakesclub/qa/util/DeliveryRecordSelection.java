package qa.cakesclub.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DeliveryRecordSelection {
	public void selectDlvryTypeRecord(WebDriver driver,String dlvryType,int dlvryFunctionality){
		// select the Delivery Type
		int row_count = driver.findElements(By.xpath("//tbody[@id='delivery-body']/tr")).size();
		int dlvryTypeFound = 0;
		int page_Count = driver.findElements(By.xpath("//ul[@class='pagination']/li")).size();
		outerloop:
		// Clicking on the next number page.
		for(int i =2;i<page_Count;i++){
			driver.findElement(By.xpath("//ul[@class='pagination']/li["+i+"]")).click();
		for(int j=1;j<=row_count;j++){
			String dlvTypeName = driver.findElement(By.xpath("//tbody[@id='delivery-body']/tr["+j+"]/td[1]")).getText();
			System.out.println(dlvTypeName);
			
			// For "Edit" click
			if(dlvryFunctionality==1){
				if(dlvTypeName.equals(dlvryType)){
								
					driver.findElement(By.xpath("//tbody[@id='delivery-body']/tr["+j+"]/td[5]/a[contains(@onclick,'EditDelivery')]")).click();
					dlvryTypeFound = 1;		
					break outerloop;
				}
//										
					}
//				break outerloop;
//			}
//			}
			// For "Delete" click
			else if(dlvryFunctionality==2){
				if(dlvTypeName.equals(dlvryType)){					
					dlvryTypeFound = 1;
					driver.findElement(By.xpath("//tbody[@id='delivery-body']/tr["+j+"]/td[5]/a[contains(@onclick,'deleteDelivery')]")).click();
					break outerloop;
				}
//					
			}
			else{
				Assert.fail("ERROR: You have entered wrong input.");
			}
		}
			if(dlvryTypeFound == 0){
				Assert.fail("ERROR: Delivery Type not found in the List.");
				
			}
		}
		}
	}

					
				
				
			


