package qa.cakesclub.qa.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SubCategorySelection {
	public void selectSubCategory(WebDriver driver, String ctrName, String subCtrName, int subCatFunctionality)throws InterruptedException {
		// select the SubCategory
		int row_count = driver.findElements(By.xpath("//ul[@class='sui-treeview-list']/li/div/span[2]/b")).size();

		int categoryFound = 0;

		for (int i = 1; i <= row_count; i++) {

			String categoryName = driver.findElement(By.xpath("//ul[@class='sui-treeview-list']/li[" + i + "]/div/span[2]/b")).getText();
			// For "Edit Sub category" click

			if (categoryName.equals(ctrName)) {
				// driver.findElement(By.xpath("//ul[@class='sui-treeview-list']/li["+i+"]/div/span[2]/b")).click();
				driver.findElement(By.xpath("//ul[@class='sui-treeview-list']/li[" + i + "]/div/span[1]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				int srow_count = driver.findElements(By.xpath("//div[@class='sui-treeview']/ul[@class='sui-treeview-list']/li[" + i+ "]/ul/li/div/span[2]/b")).size();
				System.out.println(srow_count);
				int subCategoryFound = 0;
				for (int j =1; j <= srow_count; j++) {
					String subCategoryName = driver.findElement(By.xpath("//div[@class='sui-treeview']/ul[@class='sui-treeview-list']/li[" + i + "]/ul/li[" + j + "]/div/span[2]/b")).getText();
					System.out.println(subCategoryName);
					if (subCatFunctionality == 1) {
					if (subCategoryName.equals(subCtrName)) {
						
							System.out.println("sanjib");
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElement(By.xpath("//div[@class='sui-treeview']/ul[@class='sui-treeview-list']/li[" + i + "]/ul/li[" + j + "]/div/span[2]/b")).click();
							driver.findElement(By.xpath("//button[@id='editbtn']")).click();
							subCategoryFound = 1;
							break;
					}
						} 
					else if (subCatFunctionality == 2) {
						if (subCategoryName.equals(subCtrName)){
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElement(By.xpath("//div[@class='sui-treeview']/ul[@class='sui-treeview-list']/li[" + i + "]/ul/li[" + j + "]/div/span[2]/b")).click();
							driver.findElement(By.xpath("//button[@id='deletebtn']")).click();
							subCategoryFound = 1;
							break;
						}
					}
					else{
						Assert.fail("Error: You have entered wrong input");
					}
				}

				if (subCategoryFound == 0) {
					Assert.fail("Error: The Sub Category with name " + subCtrName + " not found.");
				}

				categoryFound = 1;
				break;
			}

			

//			else {
//				Assert.fail("Error: You have entered wrong input");
//			}
		}

		if (categoryFound == 0) {
			Assert.fail("Error: The Category with name " + ctrName + " not found.");
		}

	}
}
