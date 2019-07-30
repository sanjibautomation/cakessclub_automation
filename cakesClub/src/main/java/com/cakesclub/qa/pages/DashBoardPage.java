package com.cakesclub.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cakesclub.qa.base.TestBase;

public class DashBoardPage extends TestBase{
	//Banners Module link
	@FindBy(xpath="//span[text()='Banners']")
	WebElement bnrsModule;
	// Categories Module Link
	@FindBy(xpath="//span[text()='Categories']")
	WebElement ctrsModule;
	// Offers Module Link
	@FindBy(xpath="//span[text()='Offers']")
	WebElement ofrsModule;
	// Setting Module Link
	@FindBy(xpath="//span[text()='Settings']")
	WebElement stgModule;
	// Delivery details Module Link
	@FindBy(xpath="//span[contains(text(),'Delivery Details')]")
	WebElement dlvryDtlsModule;
	// Branches Module Link
	@FindBy(xpath="//span[contains(text(),'Branches')]")
	WebElement branchessModule;
	// Products Module Link
	@FindBy(xpath="//span[text()='Products']")
	WebElement productsModule;
	// Branch Products Module link
	@FindBy(xpath="//span[text()='Branch Products']")
	WebElement branchproductsModule;
	// Orders Module link
	@FindBy(xpath="//span[contains(text(),'Orders')]")
	WebElement ordersModule;
	// Reviews Module Link
	@FindBy(xpath="//span[contains(text(),'Reviews')]")
	WebElement reviewsModule;
	// Customers Module Link
	@FindBy(xpath="//span[contains(text(),'Customers')]")
	WebElement customersModule;
	  
	
	//Initializing the PageObject
public DashBoardPage(){
	PageFactory.initElements(driver, this);
}

// Actions
// Click on Banners Module
public BannersPage ClickOnBnrsModule(){
	bnrsModule.click();
	return new BannersPage();
}
// Click on Category Module
public CategoriesPage ClickOnCtryModule(){
	ctrsModule.click();
	return new CategoriesPage();
}
//Click on Offers Module
public OffersPage ClickOnOfrsModule(){
	ofrsModule.click();
	return new OffersPage();
}
// Click on Settings Module
public SettingsPage ClickOnStgModule(){
	stgModule.click();
	return new SettingsPage();
}
// Click on Deliver Details Module
public DeliveryDetailsPage ClickOnDlvryDtlsModule(){
	dlvryDtlsModule.click();
	return new DeliveryDetailsPage();
}
// Click on Branches Module
public BranchesPage ClickOnBranchesModule(){
	branchessModule.click();
	return new BranchesPage();
	
}
// Click on Products Module
public Productspage ClickOnProductsModule(){
	productsModule.click();
	return new Productspage();
}
// Click on Branch Products Module
public BranchProductsPage ClickOnBranchProductsModule(){
	branchproductsModule.click();
	return new BranchProductsPage();
}
// Click on Orders Module
public OrdersPage ClickOnOrdersModule(){
	ordersModule.click();
	return new OrdersPage();
}
// Click on Reviews Module
public ReviewsPage ClickOnReviewsModule(){
	reviewsModule.click();
	return new ReviewsPage();
}
// Click on Customers Module
public CustomersPage ClickOnCustomerModule(){
	customersModule.click();
	return new CustomersPage();
}
}

