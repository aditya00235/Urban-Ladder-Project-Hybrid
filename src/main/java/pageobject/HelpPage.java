package pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import reusablecomponent.ReusableMethods;
import uistore.HelpPageUI;
import uistore.HomePageUI;

public class HelpPage 
{
	
	public static boolean findHelpSection(WebDriver driver,String yourQuestion,Logger log) throws Exception
	{
		if(ReusableMethods.getElements(HelpPageUI.helpTitle, driver))
		{
			log.info("Help section found");
			if(ReusableMethods.sendKeys(HelpPageUI.helpSearchInput, yourQuestion, driver))
			{
				log.info("Question send in text box");
				if(ReusableMethods.click(HelpPageUI.helpSearchButton, driver))
				{
					log.info("Question asked");
					return true;
				}
			}
			
		}
		return false;
	}
}
