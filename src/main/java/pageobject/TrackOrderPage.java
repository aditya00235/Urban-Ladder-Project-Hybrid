package pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import reusablecomponent.ReusableMethods;
import uistore.TrackOrderUI;

public class TrackOrderPage 
{
	public static boolean trackOrder(WebDriver driver,String ordernumber,String phonenumber,Logger log) throws Exception
	{
		boolean flag=false;
		if(ReusableMethods.getElements(TrackOrderUI.form, driver))
		{
			if(ReusableMethods.getElements(TrackOrderUI.orderNumberBox, driver))
			{
				log.info("OrderNumber box found");
				if(ReusableMethods.sendKeys(TrackOrderUI.orderNumberBox, ordernumber, driver))
				{	
					log.info("Keys send in the Order Number box ");
					flag=false;
				}
			}
			if(ReusableMethods.getElements(TrackOrderUI.phoneNumberBox, driver))
			{
				log.info("PhoneNumber box found");
				if(ReusableMethods.sendKeys(TrackOrderUI.phoneNumberBox, phonenumber, driver))
				{	
					log.info("Keys send in the Phone Number box ");
					flag=true;
				}
			}
			return flag;
		}
		return false;
	}
	/*public static boolean searchItem(WebDriver driver,String searchitem, Logger log) throws Exception
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
	}*/

}
