package pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import reusablecomponent.ReusableMethods;
import uistore.HelpPageUI;
import uistore.HomePageUI;
import uistore.LoginPageUI;
import uistore.TrackOrderUI;

public class LoginPage 
{
	public static boolean logIn(WebDriver driver,Logger log,String email,String password) throws Exception
	{
		boolean flag=false;
		if(ReusableMethods.click(HomePageUI.trackOrder, driver))
		{
			ReusableMethods.timelaps(driver);
			if(ReusableMethods.click(TrackOrderUI.loginButton,driver))
			{
				Thread.sleep(2000L);
				log.info("Login Button Clicked now fill the details to login");
				driver.findElement(LoginPageUI.emailAddress).sendKeys(email);
				driver.findElement(LoginPageUI.password).sendKeys(password);
				driver.findElement(LoginPageUI.loginButton).click();
				Thread.sleep(2000L);
				if(ReusableMethods.getElements(LoginPageUI.errorMessage, driver))
				{
					flag=false;
				}
				else
				{
					flag=true;
				}
			}
			
		}
		return flag;
	}
}
