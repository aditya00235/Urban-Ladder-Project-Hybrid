package pageobject;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import reusablecomponent.ReusableMethods;
import uistore.AddToCartPageUI;
import uistore.HomePageUI;
import uistore.TrackOrderUI;

public class AddToCartPage 
{
	public static boolean addProductToCart(WebDriver driver,Logger log,String email,String password,String searchitem) throws Exception
	{
		boolean result=false;
		if(LoginPage.logIn(driver, log, email, password))
		{
			log.info("Successfully logged in");
			if(HomePage.searchItem(driver, searchitem, log))
			{
				log.info("Product Searched");
				ReusableMethods.timelaps(driver);
				driver.findElement(AddToCartPageUI.productAfterSearch).click();
				ReusableMethods.timelaps(driver);
				driver.findElement(AddToCartPageUI.addToCartButton).click();
				log.info("Add to cart button clicked");
				ReusableMethods.timelaps(driver);
				boolean cartprogress=driver.findElement(AddToCartPageUI.checkoutProgressBar).isDisplayed();
				if(cartprogress)
				{
					log.info("Cart progress bar displayed");
					result=true;
				}
				ArrayList<WebElement> cartListItems=(ArrayList<WebElement>) driver.findElements(AddToCartPageUI.cartItems);
				for(int i=0;i<cartListItems.size();i++)
				{
					log.info("Cart item is "+cartListItems.get(i).getText());
				}
			}
		}
		return result;
	}

}
