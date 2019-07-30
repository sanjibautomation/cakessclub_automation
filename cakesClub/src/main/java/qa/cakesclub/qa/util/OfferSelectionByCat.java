package qa.cakesclub.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OfferSelectionByCat {
	
	public void selectOfferByCat(WebDriver driver,String catOfrName,int ofrCatFunctionality){
		int row_Count = driver.findElements(By.xpath("//tbody[@id='category-body']/tr")).size();
		int page_count = driver.findElements(By.xpath("//div[@id='example_wrapper']/div[3]/div[2]/div/ul[@class='pagination']/li")).size();
		int ofrCatFound = 0;
		outerloop:
		// Clicking on the next number page.
				for(int i =2;i<page_count;i++){
					driver.findElement(By.xpath("//div[@id='example_wrapper']/div[3]/div[2]/div/ul[@class='pagination']/li["+i+"]")).click();
				for(int j=1;j<=row_Count;j++){
					String ofrCatName = driver.findElement(By.xpath("//tbody[@id='category-body']/tr["+j+"]/td[1]")).getText();
					// Click on edit button
					if(ofrCatFunctionality == 1){
						if(ofrCatName.equals(catOfrName)){
						driver.findElement(By.xpath("//tbody[@id='category-body']/tr["+j+"]/td[5]/a[1]")).click();
						ofrCatFound = 1;							
						break outerloop;
					}
					}
					// Click on Delete button
					if(ofrCatFunctionality == 2){
						if(ofrCatName.equals(catOfrName)){
							driver.findElement(By.xpath("//tbody[@id='category-body']/tr["+j+"]/td[5]/a[2]")).click();
							ofrCatFound = 1;							
							break outerloop;
						}
						
					}
					
					
				}	
		}
		if(ofrCatFound == 0){
			Assert.fail("ERROR: The Category offer with name "+catOfrName+" is not found.");
		}
	}

}
