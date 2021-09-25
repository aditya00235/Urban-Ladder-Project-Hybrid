package uistore;

import org.openqa.selenium.By;

public class TrackOrderUI 
{
	public static By orderNumberBox=By.xpath("//input[@placeholder='Order Number']");
	public static By phoneNumberBox=By.xpath("//input[@placeholder='Phone Number']");
	public static By submitButton=By.xpath("(//button[@type='submit'])[1]");
	public static By loginToTrackAllOrderButton=By.xpath("(//button[@type='submit'])[2]");
	public static By form=By.xpath("//form[@class='awunb']");
	public static By loginButton=By.xpath("(//button[@type='submit'])[2]");

}
