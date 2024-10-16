

package config;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtils 
{

  public static WebDriver driver;
  public static Properties conpro;
  
  //launch browser according to locator data
   @BeforeTest
   public void setUp() throws Throwable
   {
	  conpro=new Properties();
	  conpro.load(new FileInputStream("./Properties/Envoirnment.properties"));
	  if(conpro.getProperty("browser").equalsIgnoreCase("chrome"))
	  {
		driver=new ChromeDriver();
	  }
	   
	  else if(conpro.getProperty("browser").equalsIgnoreCase("firefox"))
	  {
		driver=new FirefoxDriver();  
	  }
	  else
	  {
		  Reporter.log("browser is not matching");
	  }
   }

   //close browser
  @AfterTest
  public void tearDown()
  {
	  driver.quit();
	  
  }


}
