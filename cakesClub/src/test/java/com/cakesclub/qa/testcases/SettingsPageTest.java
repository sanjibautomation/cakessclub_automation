package com.cakesclub.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cakesclub.qa.base.TestBase;
import com.cakesclub.qa.pages.DashBoardPage;
import com.cakesclub.qa.pages.LoginPage;

import com.cakesclub.qa.pages.SettingsPage;

import qa.cakesclub.qa.util.SettingMenuSelection;
import qa.cakesclub.qa.util.SettingSubMenuSelection;
import qa.cakesclub.qa.util.TestUtil;

public class SettingsPageTest extends TestBase{
	DashBoardPage dashBoardPage;
	LoginPage loginPage;
	SettingsPage settingsPage;
	SettingMenuSelection settingMenuSelection;
	String sheetName = "Settings"; 
	String sheetName1 = "SettingSubMenu";
	int settingFunctionality=0;
	int settingSubMenuFunctionality=0;
	SettingSubMenuSelection settingSubMenuSelection;
	
public SettingsPageTest(){
	super();
}
@BeforeMethod
public void setUp() {
	initialization();
	loginPage = new LoginPage();
	dashBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	dashBoardPage.ClickOnStgModule();
	settingsPage = new SettingsPage();
	settingMenuSelection = new SettingMenuSelection();
	settingSubMenuSelection = new SettingSubMenuSelection();
}
@Test
public void stgPageValidationTest(){
	String pageName = settingsPage.stgPageValidation();	
	Assert.assertEquals(pageName, prop.getProperty("stgPageName"),"ERROR:The Page name is not Matched.");
}
@DataProvider
public Object[][] getSettingsData(){
	Object data[][]=TestUtil.getTestData(sheetName);		
	return data;		 
}
@Test(dataProvider = "getSettingsData")
public void addMenuItemTest(String menuText){
	int menuItemFound=0;
	settingsPage.addMenuItemPage(menuText);
	driver.navigate().refresh();
	// validate the data after adding Menu Item
	List<WebElement> menuList = driver.findElements(By.xpath("//table/tbody/tr"));
	int row_count = menuList.size();
	for(int i=1; i<=row_count; i++){
		String actualMenuItem = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();		
		if(actualMenuItem.equals(menuText)){
			menuItemFound=1;
			System.out.println("Menu Item Added Successfully");
			break;
		}
				
	}
	if(menuItemFound==0){
		Assert.fail("ERROR: Menu Item doesn't added successfully");
	
}
}
@Test(dataProvider = "getSettingsData")
public void updateMenuItemTest(String menuItem){
	int updateMenuItemFound = 0;
	settingFunctionality=1;		
	settingMenuSelection.selectMenu(driver, prop.getProperty("selectMenuName"),settingFunctionality);
	settingsPage.updateMenuItemPage(menuItem);
	// Validating data after update the menu Item
	List<WebElement> menuList = driver.findElements(By.xpath("//table/tbody/tr"));
	int row_count = menuList.size();
	for(int i=1; i<=row_count; i++){
		String actualMenuItem = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();		
		if(actualMenuItem.equals(menuItem)){
			updateMenuItemFound = 1;
			System.out.println("Menu Item updated Successfully");
			break;
		}
				
	}
	if(updateMenuItemFound == 0){
		Assert.fail("ERROR: Menu Item doesn't updated successfully");
	
}
}
@Test
public void deleteMenuItemTest(){
	settingFunctionality=2;		
	settingMenuSelection.selectMenu(driver, prop.getProperty("selectMenuName"), settingFunctionality);
	settingsPage.deleteMenuItemPage();
	String deleteMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
	System.out.println(deleteMsg);
	if(deleteMsg.contains("Success! Menu Item deleted successfully.")){
		System.out.println("Menu item deleted successfully");
	}
	else
	{
		System.out.println("ERROR: Menu item not deleted successfully");
	}
	
}
@DataProvider
public Object[][] getSettingsSubMenuData(){
	Object data[][]=TestUtil.getTestData(sheetName1);		
	return data;		 
}
@Test(dataProvider="getSettingsSubMenuData")
public void addSubMenuItemPageTest(String subMenuItem) throws InterruptedException{
	int subMenuItemFound=0;
	settingFunctionality=3;
	settingMenuSelection.selectMenu(driver, prop.getProperty("selectMenuName"), settingFunctionality);
	settingsPage.addSubMenuItemPage(subMenuItem);
	driver.navigate().refresh();
	settingMenuSelection.selectMenu(driver, prop.getProperty("selectMenuName"), settingFunctionality);
	//validating the data after adding subMenu Item
	List<WebElement> subMenuList=driver.findElements(By.xpath("//div[@id='subMenuItemsDiv']/table/tbody/tr"));
	int row_count = subMenuList.size();
	for(int i=1;i<=row_count;i++){
		String actSubMenuItem=driver.findElement(By.xpath("//div[@id='subMenuItemsDiv']/table/tbody/tr["+i+"]/td[1]")).getText();
		Thread.sleep(2000);
		System.out.println(actSubMenuItem);
		if(actSubMenuItem.equals(subMenuItem)){
			subMenuItemFound=1;
			System.out.println("SubMenu Item added Successfully");
			break;
		}
	}
	if(subMenuItemFound==0){
		Assert.fail("ERROR: SubMenu Item doesn't added successfully");
	}
}
@Test(dataProvider="getSettingsSubMenuData")
public void updateSubmenuItemPageTest(String updSubMenuItem){
	int subMenuItemFound=0;
	settingFunctionality=3;
	settingSubMenuFunctionality=1;
	settingMenuSelection.selectMenu(driver, prop.getProperty("selectMenuName"), settingFunctionality);
	settingSubMenuSelection.selectSubMenu(driver, prop.getProperty("selectSubmenuItem"), settingSubMenuFunctionality);
	settingsPage.updateSubMenuItemPage(updSubMenuItem);
	driver.navigate().refresh();
	settingMenuSelection.selectMenu(driver, prop.getProperty("selectMenuName"), settingFunctionality);	
	List<WebElement> subMenuList=driver.findElements(By.xpath("//div[@id='subMenuItemsDiv']/table/tbody/tr"));
	int row_count = subMenuList.size();
	for(int i=1;i<=row_count;i++){
		String actSubMenuItem=driver.findElement(By.xpath("//div[@id='subMenuItemsDiv']/table/tbody/tr["+i+"]/td[1]")).getText();
		//String reqSubMenuItem=prop.getProperty("selectSubmenuItem");
			if(actSubMenuItem.equals(updSubMenuItem)){
			subMenuItemFound=1;
			//driver.findElement(By.xpath("//div[@id='subMenuItemsDiv']/table/tbody/tr["+i+"]/td[2]/a[1]")).click();
			//settingsPage.updateSubMenuItemPage(updSubMenuItem);
			System.out.println("SubMenu item updated successfully.");
			break;
		}
	}
	if(subMenuItemFound==0){
		Assert.fail("ERROR: SubMenu Item doesn't updated successfully");
	}
	
}
@Test
public void deleteSubMenuItemPageTest(){
	settingFunctionality=3;
	settingSubMenuFunctionality=2;
	
	settingMenuSelection.selectMenu(driver, prop.getProperty("selectMenuName"), settingFunctionality);
	settingSubMenuSelection.selectSubMenu(driver, prop.getProperty("selectSubmenuItem"), settingSubMenuFunctionality);
	settingsPage.deleteSubMenuItemPage();
	String deleteMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
	if(deleteMsg.contains("Success!Sub Menu Item deleted successfully.")){
		System.out.println("Sub menu item deleted successfully");
	}
	else
	{
		System.out.println("ERROR: Sub menu item not deleted successfully");
	}
	
}
//@AfterMethod
//public void tearDown(){
//	driver.quit();
//}

}

