package config;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import commonFunctions.LoginPage;
import commonFunctions.LogoutPage;

public class AppUtils1 
{

public static WebDriver driver;
public static Properties conpro;
	
	@BeforeTest
	public void setUp()throws Throwable
	{
		
		conpro=new Properties();
		conpro.load(new FileInputStream("./Properties/Envoirnment.properties"));
		
	   if(conpro.getProperty("browser").equalsIgnoreCase("chrome"))
	   {
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		   driver.get(conpro.getProperty("url"));
		   
		   LoginPage login1=PageFactory.initElements(driver,LoginPage.class);
		   login1.login("admin","master");
	   	   
	   }
	   else if(conpro.getProperty("browser").equalsIgnoreCase("firefox"))
	   {
		   driver=new FirefoxDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	       driver.get(conpro.getProperty("url"));
	     
	       LoginPage login1=PageFactory.initElements(driver,LoginPage.class);
	       login1.login("admin","master");      
	       	       
	   }
	   
	   else
	   {
		   Reporter.log("invalid browser",true);
	   }
			
	}
	
	@AfterTest
	public void tearDown()
	{
		LogoutPage logout1=PageFactory.initElements(driver, LogoutPage.class);
		logout1.logout();
        driver.quit();		
	}
}
