package qa.cakesclub.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SettingSubMenuSelection {
	
	public void selectSubMenu(WebDriver driver,String subMenuName,int settingSubMenuFunctionality){
		
		// select the SubMenuItem
				int row_count = driver.findElements(By.xpath("//div[@id='subMenuItemsDiv']/table/tbody/tr")).size();
				int subMenuFound = 0;
				for(int i=1;i<=row_count;i++){
					String actSubMenuName = driver.findElement(By.xpath("//div[@id='subMenuItemsDiv']/table/tbody/tr["+i+"]/td[1]")).getText();
					// For "Edit" click
					if(settingSubMenuFunctionality==1){
						if(actSubMenuName.equals(subMenuName)){
							driver.findElement(By.xpath("//div[@id='subMenuItemsDiv']/table/tbody/tr["+i+"]/td[2]/a[1]")).click();
							subMenuFound = 1;
							break;
						}
						
					}
					// For "Delete" click
					else if(settingSubMenuFunctionality==2){
						if(actSubMenuName.equals(subMenuName)){
							driver.findElement(By.xpath("//div[@id='subMenuItemsDiv']/table/tbody/tr["+i+"]/td[2]/a[2]")).click();
							subMenuFound = 1;
							break;
						}
						
					}
					
					
				
				else{
					Assert.fail("Error: You have entered wrong input");
				}
				
				}

				if(subMenuFound == 0){
					Assert.fail("Error: The SubMenu with name "+subMenuName+" not found.");
				}
				

	}
	}



