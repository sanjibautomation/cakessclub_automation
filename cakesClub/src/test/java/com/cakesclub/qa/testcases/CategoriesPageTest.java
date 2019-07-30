package com.cakesclub.qa.testcases;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cakesclub.qa.base.TestBase;
import com.cakesclub.qa.pages.CategoriesPage;
import com.cakesclub.qa.pages.DashBoardPage;
import com.cakesclub.qa.pages.LoginPage;

import qa.cakesclub.qa.util.CategorySelection;
import qa.cakesclub.qa.util.SubCategorySelection;
import qa.cakesclub.qa.util.TestUtil;

public class CategoriesPageTest extends TestBase{
	DashBoardPage dashBoardPage;
	LoginPage loginPage;
	CategoriesPage categoriesPage;
	TestUtil testUtil;
	String sheetName1 = "Category";
	CategorySelection categorySelection;
	int catFunctionality=0;
	int subCatFunctionality=0;
	String sheetName2 = "SubCategory";
	SubCategorySelection subCategorySelection;
	
	public CategoriesPageTest(){
		super();
	}
@BeforeMethod
public void setUp(){
	initialization();
	loginPage= new LoginPage();
	dashBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	dashBoardPage.ClickOnCtryModule();
	categoriesPage = new CategoriesPage();
	categorySelection = new CategorySelection();
	subCategorySelection = new SubCategorySelection();
}
@Test
public void validateCatPageNameTest(){
	String pageName = categoriesPage.validateCategoryPage();
	Assert.assertEquals(pageName, prop.getProperty("catPageName"),"ERROR: The Category name is not matched");
}

@DataProvider
public Object[][] getCategoryData(){
	Object data[][]=TestUtil.getTestData(sheetName1);		
	return data;		 
}
@Test(dataProvider = "getCategoryData")
public void addCategoryTest(String catName) throws InterruptedException{
	int flag=0;
	categoriesPage.addCategoryPage(catName);
	Thread.sleep(2000);
	int row_count=driver.findElements(By.xpath("//ul[@class='sui-treeview-list']/li/div/span[2]/b")).size();
	for(int i=1;i<=row_count;i++){
		
		String actCatName = driver.findElement(By.xpath("//ul[@class='sui-treeview-list']/li["+i+"]/div/span[2]/b")).getText();
		if(actCatName.equalsIgnoreCase(catName)){
			flag=1;
			
			System.out.println("Record added successfully");
		}
	}
	if(flag==0){
		
		System.out.println("record not found");
	}
}
@DataProvider
public Object[][] getSubCategoryData(){
	Object data[][]=TestUtil.getTestData(sheetName2);		
	return data;
}
@Test(dataProvider = "getSubCategoryData" )
public void addSubCategoryTest(String subCategoryName){
	catFunctionality=1;
	categorySelection.selectCategory(driver, prop.getProperty("selectCtrName"), catFunctionality);
	categoriesPage.addSubCategoryPage(subCategoryName);
}


@Test (dataProvider = "getCategoryData" )
public void updateCategoryTest(String catName){
	catFunctionality = 2;
	categorySelection.selectCategory(driver, prop.getProperty("selectCtrName"), catFunctionality);
	categoriesPage.updateCategoryPage(catName);
	
}
@Test
public void deleteCategoryTest(){
	catFunctionality =3;
	categorySelection.selectCategory(driver, prop.getProperty("selectCtrName"), catFunctionality);
	categoriesPage.deleteCategoryPage();
	
}
// Update Subcategory is not working, after changing the focus from eclipse to app then only its working.Select Subcategory there is a problem,Not Stable.
@Test(dataProvider = "getSubCategoryData")
public void updateSubCategoryTest(String subCategoryName) throws InterruptedException{
	subCatFunctionality = 1;
	subCategorySelection.selectSubCategory(driver, prop.getProperty("selectCtrName"), prop.getProperty("selectSubCatName"), subCatFunctionality);
	categoriesPage.updateSubCategoryPage(subCategoryName);
}
//Delete Subcategory is not working, after changing the focus from eclipse to app then only its working.Select Subcategory there is a problem,Not Stable.
@Test
public void deleteSubCategoryTest() throws InterruptedException{
	subCatFunctionality = 2;
	subCategorySelection.selectSubCategory(driver,prop.getProperty("selectCtrName"), prop.getProperty("selectSubCatName"), subCatFunctionality);
	categoriesPage.deleteSubCategoryPage();
	}
//@AfterMethod
//public void tearDown(){
//	driver.quit();
//}
}
