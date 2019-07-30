package com.cakesclub.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cakesclub.qa.base.TestBase;
import com.cakesclub.qa.pages.BranchesPage;
import com.cakesclub.qa.pages.DashBoardPage;
import com.cakesclub.qa.pages.LoginPage;

import qa.cakesclub.qa.util.TestUtil;



public class BranchesPageTest extends TestBase{
	BranchesPage branchesPage;
	DashBoardPage dashBoardPage;
	LoginPage loginPage;
	String sheetName = "Branches";
	int phoneNoFound = 0;
	
	public BranchesPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		branchesPage = new BranchesPage();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dashBoardPage.ClickOnBranchesModule();
	}
	@Test
	public void validatePageNameTest(){
		String actPageName = branchesPage.validatepageTitle();
		String reqPageName = prop.getProperty("BranchPageName");
		Assert.assertEquals(actPageName, reqPageName,"ERROR: The page name is not Matching.");
	}
	@DataProvider
	public Object[][] getBranchData(){
		Object data[][]=TestUtil.getTestData(sheetName);		
		return data;		 
	}
	@Test(dataProvider ="getBranchData")
	public void addBranchTest(String name,String adress,String area,String state, String longitude, String phNum, String city, String pincode, String latitude){
		branchesPage.addBranchType(name, adress, area, state, longitude, phNum, city, pincode, latitude);
	}
	
	@Test(dataProvider ="getBranchData")
	public void updateBranchType(String updname, String updadress, String updarea,  String updstate, String updlongitude, String updphNum, String updcity, String updpincode, String updlatitude){
		int row_Count = driver.findElements(By.xpath("//tbody[@id='products-body']/tr")).size();
		for(int i=1;i<=row_Count;i++){
			String actPhoneNumber = driver.findElement(By.xpath("//tbody[@id='products-body']/tr["+i+"]/td/address/p")).getText();
			String reqPhoneNumber = prop.getProperty("BranchPhoneNumber");
			if(actPhoneNumber.equals(reqPhoneNumber)){
				phoneNoFound = 1; 
				driver.findElement(By.xpath("//tbody[@id='products-body']/tr["+i+"]/td[2]/a[1]")).click();
				branchesPage.updateBranchType(updname, updadress, updarea, updstate, updlongitude, updphNum, updcity, updpincode, updlatitude);
				
			}
			
			}
		if(phoneNoFound == 0){
			Assert.fail("ERROR: The phone number is not found.");
		}
	}
	@Test
	public void deleteBranchType(){
		int row_Count = driver.findElements(By.xpath("//tbody[@id='products-body']/tr")).size();		
		for(int i=1;i<=row_Count;i++){
		String actPhoneNumber = driver.findElement(By.xpath("//tbody[@id='products-body']/tr["+i+"]/td/address/p")).getText();
		String reqPhoneNumber = prop.getProperty("BranchPhoneNumber");
		if(actPhoneNumber.equals(reqPhoneNumber)){
			phoneNoFound = 1;
			driver.findElement(By.xpath("//tbody[@id='products-body']/tr["+i+"]/td[2]/a[2]")).click();
			branchesPage.deleteBranchType();
		}
//		else{
//			Assert.fail("ERROR: The phone number with "+reqPhoneNumber+" not found.");
//		}
		}
		if(phoneNoFound == 0){
		Assert.fail("ERROR: The phone number is not found.");
		}
	}
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//	}
	
}
