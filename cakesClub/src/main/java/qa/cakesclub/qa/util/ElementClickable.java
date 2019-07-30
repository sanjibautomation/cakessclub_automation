package qa.cakesclub.qa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementClickable {
	public static boolean isClickable(WebElement webe,WebDriver driver)      
	{
	try
	{
	   WebDriverWait wait = new WebDriverWait(driver, 5);
	   wait.until(ExpectedConditions.elementToBeClickable(webe));
	   
	   return true;
	}
	catch (Exception e)
	{
	  return false;
	}
}
}
