package com.cakesclub.qa.testcases;

import com.cakesclub.qa.base.TestBase;
import com.cakesclub.qa.pages.DashBoardPage;
import com.cakesclub.qa.pages.DeliveryDetailsPage;
import com.cakesclub.qa.pages.LoginPage;

import qa.cakesclub.qa.util.DeliveryRecordSelection;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeliveryDetailsPageTest extends TestBase{
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	DeliveryDetailsPage deliveryDetailsPage;
	String sheetName = "DeliveryDetails";
	DeliveryRecordSelection deliveryRecordSelection;
	int dlvryFunctionality = 0;
	
	public DeliveryDetailsPageTest(){
		super();
		
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dashBoardPage.ClickOnDlvryDtlsModule();		
		deliveryDetailsPage = new DeliveryDetailsPage();
		deliveryRecordSelection = new DeliveryRecordSelection();
	}
	
	@Test
	public void dlvryPageValidationTest(){
		String actPageName = deliveryDetailsPage.dlvryDetailsPageValidation();
		String reqPageName = prop.getProperty("dlvryPageName");
		Assert.assertEquals(actPageName, reqPageName,"ERROR: Delivery PageName doesn't matched.");
		
		
	}
//	@DataProvider
//	public Object[][] getDelDetailsData(){
//		Object data[][]=TestUtil.getTestData(sheetName);		
//		return data;		 
//	}
	
	@Test
	public void addDlvryRecordTest() throws InterruptedException{
		deliveryDetailsPage.addDeliveryRecord();	
	}
	@Test
	public void updDlvryRecordTest(){
		dlvryFunctionality = 1;
		deliveryRecordSelection.selectDlvryTypeRecord(driver, prop.getProperty("dlvryType"), dlvryFunctionality);
		deliveryDetailsPage.updateDeliveryRecord();
	}
	@Test
	public void deleteDlvryTypeTest(){
		dlvryFunctionality = 2;
		deliveryRecordSelection.selectDlvryTypeRecord(driver, prop.getProperty("dlvryType"), dlvryFunctionality);
		deliveryDetailsPage.deleteDeliveryRecord();
	}
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//	}

}
