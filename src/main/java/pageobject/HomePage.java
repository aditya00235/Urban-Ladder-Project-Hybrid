package pageobject;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import reusablecomponent.ReusableMethods;
import uistore.HomePageUI;

public class HomePage 
{
	public static boolean searchItem(WebDriver driver,String searchitem, Logger log) throws Exception
	{
		if(ReusableMethods.getElements(HomePageUI.searchBox, driver))
		{
			log.info("Search box found");
			//driver.findElement(HomePageUI.searchBox).clear();
			if(ReusableMethods.sendKeys(HomePageUI.searchBox, searchitem, driver))
			{	
				log.info("Keys send in the Search box ");
				//log.error("This is dummy error which i am giving after keys send in search box");
				
				if(ReusableMethods.click(HomePageUI.searchButton, driver))
				{
					log.info("Search button clicked");
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean trackOrderIcon(WebDriver driver, Logger log) throws Exception
	{
		if(ReusableMethods.getElements(HomePageUI.trackOrder, driver))
		{
			log.info("Track Order Icon found");
			if(ReusableMethods.click(HomePageUI.trackOrder, driver))
			{
				log.info("Track Order Icon clicked");
				return true;
			}
		}
		return false;
	}
	
	public static boolean clickHelpSection(WebDriver driver,Logger log) throws Exception
	{
		
		if(ReusableMethods.click(HomePageUI.helpIcon, driver))
			{
				log.info("Help Icon found and clicked");
				return true;
			}
		return false;
	}
	
	public static boolean clickBulkOrder(WebDriver driver,Logger log) throws Exception
	{
		if(ReusableMethods.click(HomePageUI.bulkOrder, driver))
		{
			log.info("Help Icon found and clicked");
			return true;
		}
	return false;
	}
	
	public static boolean validateNavbar(WebDriver driver,Logger log)
	{
		if(driver.findElement(HomePageUI.navBar).isDisplayed())
		{
			ArrayList<WebElement> navbarElements=(ArrayList<WebElement>) driver.findElements(HomePageUI.navItems);
			for(int i=0;i<navbarElements.size();i++)
			{
				log.warn(navbarElements.get(i).getText());
			}
			return true;
		}
		return false;
	}
	
	public static boolean weAcceptPayments(WebDriver driver,Logger log)
	{
		if(driver.findElement(HomePageUI.weAccept).isDisplayed())
		{
			ArrayList<WebElement> paymentMethods=(ArrayList<WebElement>) driver.findElements(HomePageUI.paymentMethodsAvailable);
			for(int i=0;i<paymentMethods.size();i++)
			{
				log.warn(paymentMethods.get(i).getAttribute("alt"));
			}
			return true;
		}
		return false;
	}
	
}
