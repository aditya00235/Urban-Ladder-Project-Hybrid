package pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import reusablecomponent.ReusableMethods;
import uistore.BulkOrderPageUI;

public class BulkOrderPage 
{
	public static boolean placeBulkOrder(WebDriver driver, Logger log) throws Exception
	{
		if(ReusableMethods.getElements(BulkOrderPageUI.getInTouch, driver))
		{
			log.info("Get in touch form found fill it");
			return true;
		}
		return false;
	}

}
