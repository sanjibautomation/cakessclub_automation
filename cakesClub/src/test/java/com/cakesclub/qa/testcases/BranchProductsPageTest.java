package com.cakesclub.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cakesclub.qa.base.TestBase;
import com.cakesclub.qa.pages.BranchProductsPage;
import com.cakesclub.qa.pages.DashBoardPage;
import com.cakesclub.qa.pages.LoginPage;

public class BranchProductsPageTest extends TestBase{
	
	BranchProductsPage branchProductsPage;
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	int productFound = 0;
	
	
	public BranchProductsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void Setup(){
		initialization();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dashBoardPage.ClickOnBranchProductsModule();
		branchProductsPage = new BranchProductsPage();
				
	}
	@Test
	public void validatePageNameTest(){
		String actPageName = branchProductsPage.validateBranProdsPagename();
		String reqPageName = prop.getProperty("BranchProductsPageName");
		Assert.assertEquals(actPageName, reqPageName,"ERROR: The Page name is not matching.");
		
	}
	@Test
	// Now there is an issue like it's loading all the items after select the branch
	// After the issue fixed we need to write pagination in our code. 
	
	public void addBranchProductTest(){
		branchProductsPage.addBranchProductPage();
		int row_Count = driver.findElements(By.xpath("//tbody[@id='branchProducts-body']/tr")).size();
		String reqProName = prop.getProperty("SelectProductName");
		for(int i=1;i<= row_Count; i++){
			String actProName = driver.findElement(By.xpath("//tbody[@id='branchProducts-body']/tr["+i+"]/td[3]")).getText();
			
			if(actProName.equals(reqProName)){
				driver.findElement(By.xpath("//tbody[@id='branchProducts-body']/tr["+i+"]/td[1]/input[@type='checkbox']")).click();
				// Validate the Add operation through Alert Message.
				String stsMsg = driver.findElement(By.xpath("//div[@class='alert-messages']/div")).getText();
				if(stsMsg.contains("Success! Product added to branch successfully.")){
					System.out.println("The product added in Branch Successfully.");
				}
				else{
					System.out.println("The Product does not added successfully.");
				}
				productFound = 1;
				break;
			}
		}
		if(productFound == 0){
			Assert.fail("ERROR : Branch Product with name "+reqProName+" not found.");
		}
		
	}
	@Test
	public void deleteBrnProdsPageTest() throws InterruptedException{
		branchProductsPage.deleteBranchProdsPageName();
		Thread.sleep(2000);
		int row_Count = driver.findElements(By.xpath("//tbody[@id='branchProducts-body']/tr")).size();
		String reqProName = prop.getProperty("SelectProductName");
		for(int i=1;i<= row_Count; i++){
			String actProName = driver.findElement(By.xpath("//tbody[@id='branchProducts-body']/tr["+i+"]/td[3]")).getText();
			if(actProName.equals(reqProName)){
				driver.findElement(By.xpath("//tbody[@id='branchProducts-body']/tr["+i+"]/td[1]/input[@type='checkbox']")).click();
				driver.switchTo().alert().accept();
				// validate the delete operation through alert message
				String stsMsg = driver.findElement(By.xpath("//div[@class='alert-messages']/div")).getText();
				if(stsMsg.contains("Success! Product deleted from branch successfully.")){
					System.out.println("The product deleted in Branch Successfully.");
				}
				else{
					System.out.println("The Product does not deleted successfully.");
				}
				productFound = 1;
				break;
			}
		}
		if(productFound == 0){
			Assert.fail("ERROR: The Product name with "+reqProName+" not found.");
		}
	}
	
	@Test
	public void updateStockTest() throws InterruptedException{
		branchProductsPage.updateStockPageName();		
		int row_Count = driver.findElements(By.xpath("//tbody[@id='branchProducts-body']/tr")).size();
		String reqProName = prop.getProperty("SelectProductName");
		for(int i=1;i<= row_Count; i++){
			String actProName = driver.findElement(By.xpath("//tbody[@id='branchProducts-body']/tr["+i+"]/td[3]")).getText();
			if(actProName.equals(reqProName)){
				boolean chkboxstatus=driver.findElement(By.xpath("//tbody[@id='branchProducts-body']/tr["+i+"]/td[1]/input[@type='checkbox']")).isSelected();
				if(chkboxstatus){
					driver.findElement(By.xpath("//tbody[@id='branchProducts-body']/tr["+i+"]/td[4]/a/span")).click();
					driver.switchTo().alert().accept();
					//validating update status
					String stsMsg = driver.findElement(By.xpath("//div[@class='alert-messages']/div")).getText();
					if(stsMsg.contains("Success! Product stock Updated successfully.")){
						System.out.println("The product stock updated Successfully.");
					}
					else{
						System.out.println("The product stock doesn't updated Successfully.");
					}
				}
				else
				{
					driver.findElement(By.xpath("//tbody[@id='branchProducts-body']/tr["+i+"]/td[1]/input[@type='checkbox']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/button ")).click();
					driver.findElement(By.xpath("//tbody[@id='branchProducts-body']/tr["+i+"]/td[4]/a/span")).click();
					driver.switchTo().alert().accept();
					//validating update status
					String stsMsg = driver.findElement(By.xpath("//div[@class='alert-messages']/div")).getText();
					System.out.println(stsMsg);
					if(stsMsg.contains("Success! Product stock Updated successfully.")){
						System.out.println("The product stock updated Successfully.");
					}
					else{
						System.out.println("The product stock doesn't updated Successfully.");
					}
				}
				productFound=1;
				break;
			}
	}
	if(productFound==0)	
	{
		Assert.fail("ERROR: Product Name with "+reqProName+"not found");
	}
}
@Test 
public void SearchFunctionalityTest(){
	branchProductsPage.searchFunctionality();
}
}
