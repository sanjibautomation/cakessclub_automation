package qa.cakesclub.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SettingMenuSelection {
	public void selectMenu(WebDriver driver,String menuName,int settingFunctionality){
	
	// select the MenuItem
			int row_count = driver.findElements(By.xpath("//tbody/tr")).size();
			int menuFound = 0;
			for(int i=1;i<=row_count;i++){
				String actmenuName = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[1]")).getText();
				// For "Edit" click
				if(settingFunctionality==1){
					if(actmenuName.equals(menuName)){
						driver.findElement(By.xpath("//td[text()='"+menuName+"']/following::td[1]/a[1]")).click();
						menuFound = 1;
						break;
					}
					
				}
				// For "Delete" click
				else if(settingFunctionality==2){
					if(actmenuName.equals(menuName)){
						driver.findElement(By.xpath("//td[text()='"+menuName+"']/following::td[1]/a[2]")).click();
						menuFound = 1;
						break;
					}
					
				}
				// For "AddSubMenu" button click
				else if(settingFunctionality==3){
				if(actmenuName.equals(menuName)){
					driver.findElement(By.xpath("//td[text()='"+menuName+"']/following::td[1]/a[3]")).click();
					menuFound = 1;
					break;
				}
				
			}
				
			
			else{
				Assert.fail("Error: You have entered wrong input");
			}
			
			}

			if(menuFound == 0){
				Assert.fail("Error: The Menu with name "+menuName+" not found.");
			}
			

}
}
