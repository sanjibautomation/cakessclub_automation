package com.cakesclub.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cakesclub.qa.base.TestBase;
import com.cakesclub.qa.pages.DashBoardPage;
import com.cakesclub.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	DashBoardPage dashBoardpage;
	
	
	
	public LoginPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();		
	}
	@Test
	public void validateLoginPageTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Laravel","Error:Title not matched");
	}
	
	@Test
	public void loginTest(){
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
