package com.cakesclub.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cakesclub.qa.base.TestBase;
import com.cakesclub.qa.pages.BannersPage;
import com.cakesclub.qa.pages.DashBoardPage;
import com.cakesclub.qa.pages.LoginPage;

import qa.cakesclub.qa.util.BannerSelection;
import qa.cakesclub.qa.util.TestUtil;


public class BannersPageTest extends TestBase{
	LoginPage loginpage;
	BannersPage bannerspage;
	DashBoardPage dashBoardPage;
	TestUtil testUtil;
	String sheetName = "Banners";
	BannerSelection bannerSelection;
	int bnrFunctionality=0;
	int flag=2;
	
	public BannersPageTest(){
		super();
	}
	@BeforeMethod
	public void setup(){
		initialization();
		loginpage= new LoginPage();
		dashBoardPage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		dashBoardPage.ClickOnBnrsModule();		
		bannerspage= new BannersPage();
		bannerSelection = new BannerSelection();
	}
	@Test
	public void validateBnrsPageTitleTest(){
		String pageName = bannerspage.validateBnrsPageName();
		Assert.assertEquals(pageName, prop.getProperty("bnrsPageName"),"ERROR: The Page Name Mismatched.");
	}
	@DataProvider
	public Object[][] getBannerData(){
		Object data[][]=TestUtil.getTestData(sheetName);		
		return data;		 
	}
	
	@Test(dataProvider = "getBannerData")
	public void addBannerTest(String bnrName,String bnrDesc,String BnrImg){
		bannerspage.addBanners(bnrName, bnrDesc, BnrImg);
		int bannerFound = 0;
		// Get the Pagination size.
		int page_Count = driver.findElements(By.xpath("//ul[@class='pagination']/li")).size();
		outerloop:
		// Clicking on the next number page.
		for(int i =2;i<page_Count;i++){
			driver.findElement(By.xpath("//ul[@class='pagination']/li["+i+"]")).click();
			int row_Count = driver.findElements(By.xpath("//tbody/tr")).size();
			// Validating the added Banner data.
			for(int j=1;j<=row_Count;j++){
				String actBannerName = driver.findElement(By.xpath("//tbody/tr["+j+"]/td[1]")).getText();				
				if(actBannerName.equals(bnrName)){
					bannerFound =1;
					System.out.println("Banner added Successfully.");					
					break outerloop;
				}
			}
		}
		if(bannerFound==0){
			Assert.fail("ERROR: The Banner name with "+bnrName+" not found.");
		}
	
	}
	@Test
	public void activeInactiveTest(){
		bnrFunctionality = 1;
		bannerSelection.selectBanner(driver, prop.getProperty("selectBnrName"), bnrFunctionality);
		bannerspage.activeBanner();
		String statusMsg = driver.findElement(By.xpath("//div[@class='alert-messages']/div")).getText();
		if(statusMsg.contains("Success! Status Changed successfully.")){
			System.out.println("Status Changed successfully.");
		}
		else
		{
			System.out.println("ERROR: Status not Changed successfully.");
		}
		
	}
	@Test
	public void defaultBnrTest(){
		bnrFunctionality = 2;
		bannerSelection.selectBanner(driver, prop.getProperty("selectBnrName"), bnrFunctionality);
		bannerspage.defaultBanner();
		
		
	}
	@Test(dataProvider = "getBannerData")
	public void updateBannerTest(String updName,String updDesc,String updImage){
		bnrFunctionality=3;
		bannerSelection.selectBanner(driver, prop.getProperty("selectBnrName"),bnrFunctionality);
		bannerspage.updateBanners(updName, updDesc, updImage);
		int bannerFound = 0;
		// Get the Pagination size.
		int page_Count = driver.findElements(By.xpath("//ul[@class='pagination']/li")).size();
		outerloop:
		// Clicking on the next number page.
		for(int i =2;i<page_Count;i++){
			driver.findElement(By.xpath("//ul[@class='pagination']/li["+i+"]")).click();
			int row_Count = driver.findElements(By.xpath("//tbody/tr")).size();
			// Validating the updated Banner data.
			for(int j=1;j<=row_Count;j++){
				String actBannerName = driver.findElement(By.xpath("//tbody/tr["+j+"]/td[1]")).getText();				
				if(actBannerName.equals(updName)){
					bannerFound =1;
					System.out.println("Banner updated Successfully.");					
					break outerloop;
				}
			}
		}
		if(bannerFound==0){
			Assert.fail("ERROR: The Banner name with "+updName+" not found.");
		}		
	}
	@Test
	public void viewBannerTest() throws InterruptedException{
		bnrFunctionality=4;
		bannerSelection.selectBanner(driver, prop.getProperty("selectBnrName"), bnrFunctionality);
		bannerspage.viewBanners();
	}
	@Test
	public void deleteBannerTest(){
		bnrFunctionality=5;
		bannerSelection.selectBanner(driver, prop.getProperty("selectBnrName"), bnrFunctionality);
		bannerspage.deleteBanners();
	}
	@Test
	public void searchBannerTest(){
		bannerspage.searchBanners(prop.getProperty("searchBnrName"));
	}
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//	}

}
