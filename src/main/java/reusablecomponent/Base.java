package reusablecomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base
{
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriver initializeDriver() throws IOException
	{
		prop=GeneratePropertiesObject.generatePropObject();
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromepath"));
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",prop.getProperty("geckopath"));
			driver=new FirefoxDriver();
		}
		else
		{
			//driver=new IEDriver();
		}
		
		int time=Integer.parseInt(prop.getProperty("wait1"));
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
		return driver;
	}
	
}
