package reusablecomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReusableMethods 
{
	//public static WebDriver driver;
	public static Properties prop;
	
	public static void timelaps(WebDriver driver) throws IOException
	{
//		FileInputStream fis=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\CucumberProjectPractice\\config.properties");
//		prop =new Properties();
//		prop.load(fis);
		
		
		prop=GeneratePropertiesObject.generatePropObject();
		int time=Integer.parseInt(prop.getProperty("wait1"));
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
	}
	
	public static boolean getElements(By selector,WebDriver driver) {
		try {
			driver.findElement(selector);
			return true;
		}
		catch(Exception e) {
			System.out.println(String.format("Element %s does not exist - proceeding",selector));
		}
		return false;
	}
	
	public static boolean sendKeys(By selector,String value,WebDriver driver) throws Exception
	{
		try {
			driver.findElement(selector).sendKeys(value);
			return true;
		}
		catch(Exception e)
		{
			throw new Exception(String.format("Error in sending [%s] to the following element: [%s]",value,selector.toString()));
		}
	}
	
	public static boolean click(By selector,WebDriver driver) throws Exception
	{
		WebElement element=driver.findElement(selector);
		try {
			element.click();
			return true;
		}
		catch(Exception e)
		{
			throw new Exception(String.format("The following element is not clickable [%s]",selector));
		}
	}
	
	
}
