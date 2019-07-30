package com.cakesclub.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cakesclub.qa.base.TestBase;

public class Productspage extends TestBase{
	int catFound=0;
  // Page Factory
	@FindBy(xpath="//button[@onclick='AddProduct()']")
	WebElement addProBtn;
	@FindBy(xpath="//div[@id='products-body']/div/div/h6")
	WebElement proPagename;
	@FindBy(xpath="//form[@id='newProductForm']//following::input[@id='product']")
	WebElement proName;
	@FindBy(xpath="//form[@id='newProductForm']//following::input[@id='product_code']")
	WebElement proCode;
	@FindBy(xpath="//form[@id='newProductForm']//following::input[@name='eggless']")
	WebElement egglessChkBox;
	@FindBy(xpath="//form[@id='newProductForm']//following::input[@name='photocake']")
	WebElement photoCakeChkBox;
	@FindBy(xpath="//form[@id='newProductForm']//following::input[@id='deliveryTime']")
	WebElement estDlvryTime;
	@FindBy(xpath="//form[@id='newProductForm']//following::button[text()='Choose Category']")
	WebElement choseCatg;
	@FindBy(xpath="//form[@id='newProductForm']//following::button[@id='btnSelectCategory']")
	WebElement catSelectBtn;
	@FindBy(xpath="//form[@id='newProductForm']//following::button[text()='Add Related Products']")
	WebElement relProdBtn;
	@FindBy(xpath="//form[@id='newProductForm']//following::button[@onclick='addProductsList()']")
	WebElement relProSelectBtn;
	@FindBy(xpath="//form[@id='newProductForm']//following::div[@class='note-editable card-block']/p")
	WebElement descTextBox;
	@FindBy(xpath="//form[@id='newProductForm']//following::textarea[@name='instructions']")
	WebElement instTextBox;
	@FindBy(xpath="//form[@id='newProductForm']//following::input[@id='upload_file']")
	WebElement allImages;
	@FindBy(xpath="//form[@id='newProductForm']//following::input[@id='default_image']")
	WebElement defltImage;
	@FindBy(xpath="//form[@id='newProductForm']//following::button[@type='submit']")
	WebElement proSaveBtn;
	
	
	//Initialize the Page Objects
	public Productspage(){
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	public String validateProductPageName(){
		return proPagename.getText();
		
	}
	public void addProducts(){
		addProBtn.click();
		proName.sendKeys("Product21");
		proCode.sendKeys("21");
		egglessChkBox.click();
		photoCakeChkBox.click();
		estDlvryTime.sendKeys("2 hours");
		choseCatg.click();
		String reqCatName=prop.getProperty("reqCatName");
		int cat_count=driver.findElements(By.xpath("//div[@id='category-model-body']/div/ul[@class='sui-treeview-list']/li")).size();
		outerloop:
		for(int i=1;i<=cat_count;i++){
			String actCatName=driver.findElement(By.xpath("//div[@id='category-model-body']/div/ul[@class='sui-treeview-list']/li["+i+"]/div")).getText();
			System.out.println(actCatName);
			if(actCatName.equals(reqCatName)){
				catFound=1;
				driver.findElement(By.xpath("//div[@id='category-model-body']/div/ul[@class='sui-treeview-list']/li["+i+"]/div/span[2]")).click();
				catSelectBtn.click();
				break outerloop;
			}
			
			else{
				driver.findElement(By.xpath("//div[@id='category-model-body']/div/ul[@class='sui-treeview-list']/li["+i+"]/div/span[1]")).click();
				boolean x= driver.findElement(By.xpath("//div[@id='category-model-body']/div/ul[@class='sui-treeview-list']/li["+i+"]/ul/li")).isDisplayed();
				if(x){
					int subCatRow_Count = driver.findElements(By.xpath("//div[@id='category-model-body']/div/ul[@class='sui-treeview-list']/li["+i+"]/ul/li")).size();
					System.out.println("subcat_rowcount"+subCatRow_Count);
					for(int j=1;j<=subCatRow_Count;j++){
						String actSubCatName= driver.findElement(By.xpath("//div[@id='category-model-body']/div/ul[@class='sui-treeview-list']/li["+i+"]/ul/li["+j+"]/div/span[2]")).getText();
						if(actSubCatName.equals(reqCatName)){
					    catFound=1;
						driver.findElement(By.xpath("//div[@id='category-model-body']/div/ul[@class='sui-treeview-list']/li["+i+"]/ul/li["+j+"]/div/span[2]")).click();
						catSelectBtn.click();
						break outerloop;
						}
					}		
			
				}
			}
}
}
}

