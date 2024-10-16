package commonFunctions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Reporter;

import config.AppUtils;

public class FunctionLibrary extends AppUtils
{

   public static boolean adminLogin(String user,String pass) throws Throwable
   {
	   
       driver.get(conpro.getProperty("url"));
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.manage().window().maximize();
       driver.findElement(By.xpath(conpro.getProperty("objreset"))).click();
       Thread.sleep(2000);
	   driver.findElement(By.xpath(conpro.getProperty("objuser"))).sendKeys(user);
	   driver.findElement(By.xpath(conpro.getProperty("objpass"))).sendKeys(pass);
	   driver.findElement(By.xpath(conpro.getProperty("objlogin"))).click();
	   Thread.sleep(2000);
	   String actual=driver.getCurrentUrl();
	   String expected="dashboard";
	   
	   if(actual.contains(expected))
	   {
		   Thread.sleep(2000);
		   driver.findElement(By.xpath(conpro.getProperty("objlogout"))).click();
		 //  Thread.sleep(2000);
		  // driver.findElement(By.xpath(conpro.getProperty("objlogoutok"))).click();
		   Reporter.log("login sucessful",true);
		   return true;
	   }
	   else
		   
	   {
		   Thread.sleep(2000);
		   String errmsg=driver.findElement(By.xpath(conpro.getProperty("objerror"))).getText();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath(conpro.getProperty("objok"))).click();
		   Thread.sleep(2000);
		   Reporter.log(errmsg,true);
		   return false;
	   }
	
	   
	   
	   
	   
   }




}
