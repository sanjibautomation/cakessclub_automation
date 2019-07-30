package qa.cakesclub.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BannerSelection {
	public void selectBanner(WebDriver driver,String bnrName,int bnrFunctionality){
		// select the Banner
		int row_count = driver.findElements(By.xpath("//tbody/tr")).size();
		int bannerFound = 0;
		int page_Count = driver.findElements(By.xpath("//ul[@class='pagination']/li")).size();
		outerloop:
		// Clicking on the next number page.
		for(int i =2;i<page_Count;i++){
			driver.findElement(By.xpath("//ul[@class='pagination']/li["+i+"]")).click();
		for(int j=1;j<=row_count;j++){
			String bannerName = driver.findElement(By.xpath("//tbody/tr["+j+"]/td[1]")).getText();
			// Default Banner Status
			String actDefaultStatus = driver.findElement(By.xpath("//tbody/tr["+j+"]/td[4]")).getText();
			String reqDefaultStatus = "First Banner";
			// Active/Inactive Status
			//WebElement InactiveBanner = driver.findElement(By.xpath("//tbody/tr["+j+"]/td[3]/a[@class='text-danger']"));
			//WebElement ActiveBanner = driver.findElement(By.xpath("//tbody/tr["+j+"]/td[3]/a[@class='text-success']"));
			// For "Active/Inactive" click
			if(bnrFunctionality==1){
				if(bannerName.equals(bnrName)){
					bannerFound = 1;					
					driver.findElement(By.xpath("//td[text()='"+bnrName+"']//following::a[1]")).click();
					if(!actDefaultStatus.equals(reqDefaultStatus)){
						String actSuccessMsg = driver.findElement(By.xpath("//div[@class='alert-messages']/div")).getText();
						String reqSuccessMsg = "Success! Status Changed successfully.";
						if(actSuccessMsg.contains(reqSuccessMsg)){
						System.out.println("Status Changed Successfully.");
						break outerloop;
						}
					}
					else{
						String actWarningMsg = driver.findElement(By.xpath("//div[@class='alert-messages']/div")).getText();
						String reqWarningMsg = "Success! Default banner cannot be inactive.";
						if(actWarningMsg.contains(reqWarningMsg)){
							System.out.println("Default Status Cannot be set as inactive.");
							break outerloop;
							}						
					}
				break outerloop;
			}
			}
			// For "Default Banner" click
			else if(bnrFunctionality==2){
				if(bannerName.equals(bnrName)){
					driver.findElement(By.xpath("//td[text()='"+bnrName+"']//following::a[2]")).click();
					bannerFound = 1;
						String actDefSuccessMsg = driver.findElement(By.xpath("//div[@class='alert-messages']/div")).getText();
						String reqDefSuccessMsg = "Success! Default Banner Changed successfully.";
						if(actDefSuccessMsg.contains(reqDefSuccessMsg)){
							System.out.println("Default Banner Changed Successfully.");
							break outerloop;
						}
						String actDefWarningMsg = driver.findElement(By.xpath("//div[@class='alert-messages']/div")).getText();
						String reqDefWarningMsg = "Error!Inactive banner cannot use as default banner!";
						if(actDefWarningMsg.contains(reqDefWarningMsg)){
							System.out.println("Inactive banner cannot use as default banner.");
							break outerloop;
						}
					
					break outerloop;
				}
				
			}
			// For "Edit" button click
			else if(bnrFunctionality==3){
			if(bannerName.equals(bnrName)){
				driver.findElement(By.xpath("//td[text()='"+bnrName+"']//following::a[3]")).click();
				bannerFound = 1;
				break outerloop;
			}
			
		}
			// For "view" button click
		else if(bnrFunctionality==4){
			if(bannerName.equals(bnrName)){
				driver.findElement(By.xpath("//td[text()='"+bnrName+"']//following::a[4]")).click();
				bannerFound = 1;
				break outerloop;
			}
			
		}
			// For "delete" button click
		else if(bnrFunctionality==5){
			if(bannerName.equals(bnrName)){
				driver.findElement(By.xpath("//td[text()='"+bnrName+"']//following::a[5]")).click();
				bannerFound = 1;
				break outerloop;
			}
			
		}
		
		else{
			Assert.fail("Error: You have entered wrong input");
		}
		
		}
		}

		if(bannerFound == 0){
			Assert.fail("Error: The Banner with name "+bnrName+" not found.");
		}
		
	}

}

