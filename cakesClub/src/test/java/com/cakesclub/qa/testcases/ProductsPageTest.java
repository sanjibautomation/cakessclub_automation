package com.cakesclub.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cakesclub.qa.base.TestBase;
import com.cakesclub.qa.pages.DashBoardPage;
import com.cakesclub.qa.pages.LoginPage;
import com.cakesclub.qa.pages.Productspage;

import qa.cakesclub.qa.util.TestUtil;

public class ProductsPageTest extends TestBase{
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	Productspage productsPage;
	TestUtil testUtil;
	
	
	
	public ProductsPageTest(){
		super();
	}
	@BeforeMethod
	public void setup(){
		initialization();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		productsPage = new Productspage();
		dashBoardPage.ClickOnProductsModule();
	}
	@Test
	public void validateProductspageTitleTest(){
		String actPageName = productsPage.validateProductPageName();
		String reqPageName = prop.getProperty("ProductsPageName");
		Assert.assertEquals(actPageName, reqPageName,"ERROR: The Page name is not matching.");
	}
	
	// Add Product is not working, after changing the focus from eclipse to app then only its working.In Select Category there is a problem,Not Stable.
	@Test 
	public void addProductdataTest(){
		productsPage.addProducts();
	}
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//	}
		
	}
	
	
	
	


