package qa.cakesclub.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CategorySelection {
	public void selectCategory(WebDriver driver, String ctrName, int catFunctionality) {
		// select the Category
		int row_count = driver.findElements(By.xpath("//ul[@class='sui-treeview-list']/li/div/span[2]/b")).size();
		int categoryFound = 0;
		for (int i = 1; i <= row_count; i++) {
			String categoryName = driver
					.findElement(By.xpath("//ul[@class='sui-treeview-list']/li[" + i + "]/div/span[2]/b")).getText();
			// For "Add Subcategory" click
			if (catFunctionality == 1) {
				if (categoryName.equals(ctrName)) {
					driver.findElement(By.xpath("//ul[@class='sui-treeview-list']/li[" + i + "]/div/span[2]/b"))
							.click();
					driver.findElement(By.xpath("//button[@id='subCategorybtn']")).click();
					categoryFound = 1;
					break;
				}

			}
			// For "Edit Category" click
			else if (catFunctionality == 2) {
				if (categoryName.equals(ctrName)) {
					driver.findElement(By.xpath("//ul[@class='sui-treeview-list']/li[" + i + "]/div/span[2]/b"))
							.click();
					driver.findElement(By.xpath("//button[@id='editbtn']")).click();
					categoryFound = 1;
					break;
				}

			}
			// For "Delete" button click
			else if (catFunctionality == 3) {
				if (categoryName.equals(ctrName)) {
					driver.findElement(By.xpath("//ul[@class='sui-treeview-list']/li[" + i + "]/div/span[2]/b"))
							.click();
					driver.findElement(By.xpath("//button[@id='deletebtn']")).click();
					categoryFound = 1;
					break;
				}

			}

			else {
				Assert.fail("Error: You have entered wrong input");
			}

		}

		if (categoryFound == 0) {
			Assert.fail("Error: The Category with name " + ctrName + " not found.");
		}

	}

}
