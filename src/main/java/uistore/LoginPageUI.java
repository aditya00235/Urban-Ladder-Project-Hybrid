package uistore;

import org.openqa.selenium.By;

public class LoginPageUI 
{
	public static By emailAddress=By.xpath("(//input[@placeholder='Email Address'])[1]");
	public static By password=By.xpath("(//input[@placeholder='Password'])[1]");
	public static By loginButton=By.xpath("(//input[@id='ul_site_login'])[1]");
	public static By errorMessage=By.xpath("//div[@class='flash ulmessage error  ']");
}
