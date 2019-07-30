package com.cakesclub.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cakesclub.qa.base.TestBase;
import com.cakesclub.qa.pages.DashBoardPage;
import com.cakesclub.qa.pages.LoginPage;
import com.cakesclub.qa.pages.OffersPage;

import qa.cakesclub.qa.util.OfferSelectionByCat;



public class OffersPageTest extends TestBase {
	DashBoardPage dashBoardPage;
	LoginPage loginPage;
	OffersPage offersPage;
	int ofrCatFunctionality=0;
	OfferSelectionByCat offerSelectionByCat;
	public OffersPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dashBoardPage.ClickOnOfrsModule();
		offersPage = new OffersPage();
		offerSelectionByCat = new OfferSelectionByCat();
	}

	@Test
	public void validateOffersPageNameTest() {
		String actPageName = offersPage.validateOffersPageName();
		System.out.println(actPageName);
		String reqPageName = prop.getProperty("ofrsPageName");
		Assert.assertEquals(actPageName,reqPageName,"ERROR: The Offers PageName is not Matching." );
	}

	@Test
	public void updateOfferCatTest() throws InterruptedException {
	    ofrCatFunctionality=1;
		offerSelectionByCat.selectOfferByCat(driver, prop.getProperty("SelectOfrCatName"), ofrCatFunctionality);
		offersPage.updateOfferByCat();
	}
	@Test
	public void deleteOfferCatTest(){
	}
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//	}
}
