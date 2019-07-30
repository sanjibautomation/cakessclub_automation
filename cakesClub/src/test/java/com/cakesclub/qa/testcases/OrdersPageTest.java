package com.cakesclub.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cakesclub.qa.base.TestBase;
import com.cakesclub.qa.pages.DashBoardPage;
import com.cakesclub.qa.pages.LoginPage;
import com.cakesclub.qa.pages.OrdersPage;

import qa.cakesclub.qa.util.PaidOrderSelection;

public class OrdersPageTest extends TestBase {
	OrdersPage ordersPage;
	DashBoardPage dashBoardPage;
	LoginPage loginPage;
	PaidOrderSelection paidOrderSelection;
	int orderFunctionality;
	
	
	
	public OrdersPageTest(){
		super();
		}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		dashBoardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		ordersPage = new OrdersPage();
		dashBoardPage.ClickOnOrdersModule();
		paidOrderSelection = new PaidOrderSelection();
	}
	@Test
	public void validateOrdersPageTest(){
		String actPageName = ordersPage.validateOrdersPageName();
		String reqPageName = prop.getProperty("reqOrdersPageName");
		Assert.assertEquals(actPageName, reqPageName,"Error: Orders PageName Not Matching.");
	}
	@Test
	public void paymentOrderTest() throws InterruptedException{
		orderFunctionality = 1;
		paidOrderSelection.selectOrder(driver, prop.getProperty("ReqOrderId"), orderFunctionality);
		ordersPage.paymentOrders();
		
	}
	@Test
	public void viewOrderTest() throws InterruptedException{
		orderFunctionality = 2;
		paidOrderSelection.selectOrder(driver, prop.getProperty("ReqOrderId"), orderFunctionality);
		ordersPage.viewOrders();
		
	}
	// Track Orders is not working
	
//	@Test
//	public void trackOrderTest() throws InterruptedException{
//		orderFunctionality = 3;
//		paidOrderSelection.selectOrder(driver, prop.getProperty("ReqOrderId"), orderFunctionality);
//		ordersPage.trackOrders();
//		
//	}
	@Test
	public void searchOrderTest(){
		ordersPage.searchOrder();
		
	}
	// Failed Order Tab Actions
	@Test
	public void viewFailedOrdersTest() throws InterruptedException{
		ordersPage.failedViewOrder();
	}
	@Test
	public void searchFailedOrderTest(){
		ordersPage.searchFailedOrder();
	}
}
