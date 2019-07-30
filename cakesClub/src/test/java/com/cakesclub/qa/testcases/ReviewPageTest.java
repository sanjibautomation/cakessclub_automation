package com.cakesclub.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cakesclub.qa.base.TestBase;
import com.cakesclub.qa.pages.DashBoardPage;
import com.cakesclub.qa.pages.LoginPage;
import com.cakesclub.qa.pages.ReviewsPage;

public class ReviewPageTest extends TestBase{
	ReviewsPage reviewsPage;
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	
	
	
	
	public ReviewPageTest() {
		super();
	} 
	
	@BeforeMethod
	public void Setup(){
		initialization();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		reviewsPage = new ReviewsPage();				
		dashBoardPage.ClickOnReviewsModule();
	}
	
	@Test
	public void reviewPageTest(){
		String actRevPageName = reviewsPage.validateReviewPage();
		String reqRevPageName = prop.getProperty("ReqRevPageName");
		Assert.assertEquals(actRevPageName, reqRevPageName,"ERROR: The Page name is not matching.");
	}
	@Test
	public void verifyBtnTest(){
		reviewsPage.verifyBtnFunctionality();
	}
	@Test
	public void verSearchPageTest() throws InterruptedException{		
		reviewsPage.VerSearchPage();
	}
	@Test
	public void unvrySearchPageTest(){
		reviewsPage.unvrySearchPage();
	} 
	

}
