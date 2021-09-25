package uistore;

import org.openqa.selenium.By;

public class AddToCartPageUI 
{
	public static By productAfterSearch=By.xpath("(//a[@class='product-img'])[1]");
	public static By addToCartButton=By.id("add-to-cart-button");
	public static By checkoutProgressBar=By.id("checkout-step-address");
	public static By cartItems=By.xpath("//div[@class='product-title']");
}
