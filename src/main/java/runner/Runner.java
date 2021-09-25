package runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.AddToCartPage;
import pageobject.BulkOrderPage;
import pageobject.HelpPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.TrackOrderPage;
import reusablecomponent.Base;
import reusablecomponent.GeneratePropertiesObject;
import utility.Datadriven;
import utility.EmailSender;

public class Runner 
{
	WebDriver driver;
	Properties prop;
	Logger log=Logger.getLogger(Runner.class);
	
	/*@BeforeClass
	public void setDriver(ITestContext context) throws IOException{
	  driver = Base.initializeDriver();
	  context.setAttribute("WebDriver", driver);
	}*/
	
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=Base.initializeDriver();
		prop=GeneratePropertiesObject.generatePropObject();
		
	}
	
	/*@Test(priority=0,dataProvider="getDataProducts")
	public void searchElement(String args) throws Exception
	{
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		boolean flag=HomePage.searchItem(driver, args,log);
		try {
		Assert.assertEquals(flag,true);
		log.info("search element found");
		}
		catch(Exception e)
		{
			log.error("search element found");
		}
		Thread.sleep(2000L);
	}
	
	@DataProvider
	public Object[] getDataProducts() throws IOException
	{
		String path=prop.getProperty("excel_sheet_loc_for_searchproduct");
		Datadriven dd=new Datadriven(path);
		ArrayList<String> as=dd.getData("Product", path, "page1");
		int arraylist_size=as.size();
		Object[] data=new Object[arraylist_size];
		for(int i=0;i<arraylist_size;i++)
		{
			data[i]=as.get(i);
		}
		
		return data;
	}
	
	@Test(priority=1,dataProvider="getDataTrackOrderDetails")
	public void trackOrder(String order,String phone) throws Exception
	{
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		if(HomePage.trackOrderIcon(driver, log))
		{
			boolean flag=TrackOrderPage.trackOrder(driver, order, phone, log);
			try {
				Assert.assertEquals(flag,true);
				log.info("Track Order Found");
				}
				catch(Exception e)
				{
					log.error("Track Order Not Found");
				}
		}
		Thread.sleep(2000L);
	}
	
	@DataProvider
	public String[][] getDataTrackOrderDetails() throws IOException
	{
		String path=prop.getProperty("excel_sheet_loc_for_trackorder");
		Datadriven dd=new Datadriven(path);
		int totalrows=dd.getRowCount("page1");
		int totalcols=dd.getCellCount("page1",1);
		String trackingData[][]=new String[totalrows-1][totalcols];
		for(int i=1;i<totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				trackingData[i-1][j]=dd.getCellData("page1",i,j);
			}
		}
		return trackingData;
	}
	
	@Test(priority=2,dataProvider="getHelpData")
	public void help(String question) throws Exception
	{
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		if(HomePage.clickHelpSection(driver, log))
		{
			boolean flag=HelpPage.findHelpSection(driver, question, log);
			try {
				Assert.assertEquals(flag,true);
				log.info("Successfully helped by Application");
				}
				catch(Exception e)
				{
					log.error("Error occured while help in application");
				}
		}
	}
	@DataProvider
	public Object[] getHelpData() throws IOException
	{
		String path=prop.getProperty("excel_sheet_loc_for_helpquestion");
		Datadriven dd=new Datadriven(path);
		ArrayList<String> as=dd.getData("Question", path, "page1");
		int arraylist_size=as.size();
		Object[] data=new Object[arraylist_size];
		for(int i=0;i<arraylist_size;i++)
		{
			data[i]=as.get(i);
		}
		
		return data;
	}
	
	@Test(priority=3)
	public void bulkOrder() throws Exception
	{
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		if(HomePage.clickBulkOrder(driver, log))
		{
			boolean flag=BulkOrderPage.placeBulkOrder(driver, log);
			try {
				Assert.assertEquals(flag,true);
				log.info("Form availbale");
				}
				catch(Exception e)
				{
					log.error("Form not available");
				}
		}
	}
	
	@Test(priority=4)
	public void navbarValidation()
	{
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		if(HomePage.validateNavbar(driver, log))
		{
			try {
				Assert.assertTrue(true);
				log.info("Navbar features available");
				}
				catch(Exception e)
				{
					log.error("Navbar features not available");
				}
		}
	}
	
	@Test(priority=5)
	public void differentPaymentMethods()
	{
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		if(HomePage.weAcceptPayments(driver, log))
		{
			Assert.assertTrue(true);
			log.info("Different Payment methods available here");
		}
		else {
			log.error("No payment methods available");
		}
	}
	
	@Test(priority=6,dataProvider="getDataLogin")
	public void logIn(String email,String password) throws Exception
	{
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		if(LoginPage.logIn(driver,log,email,password))
		{
			Assert.assertTrue(true);
			log.info("Successfully locked in");
		}
		else {
			Assert.assertFalse(false);
			log.info("Not a valid username or password");
		}
	}
	
	@DataProvider
	public String[][] getDataLogin() throws IOException
	{
		String path=prop.getProperty("excel_sheet_loc_for_login");
		Datadriven dd=new Datadriven(path);
		int totalrows=dd.getRowCount("page1");
		int totalcols=dd.getCellCount("page1",1);
		String trackingData[][]=new String[totalrows-1][totalcols];
		for(int i=1;i<totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				trackingData[i-1][j]=dd.getCellData("page1",i,j);
			}
		}
		return trackingData;
	}*/
	
	@Test(priority=7)
	public void addToCart() throws Exception
	{
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		if(AddToCartPage.addProductToCart(driver, log, prop.getProperty("validEmailIDForLogin"), prop.getProperty("validPassword"),prop.getProperty("itemToAddInCart")))
		{
			Assert.assertTrue(true);
			log.info("Item Added to Cart successfully");
		}
		else
		{
			Assert.assertFalse(false);
			log.error("Some error occured Item  not added to Cart");
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
	
	/*@AfterSuite
	public void sendMail() throws IOException
	{
		EmailSender.sentEmail();
	}
	
	/*@AfterClass
	public void closeDriver()
	{
		driver.close();
		driver=null;
	}*/
}
