package commonFunctions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage 
{

	//repository for customer page
	
	
	@FindBy(xpath="(//a[contains(text(),'Customers')])[2]")
	WebElement objcustomerlink;
	
	@FindBy(xpath="(//span[@data-caption='Add'])[1]")
	WebElement objAddicon;
	
	@FindBy(xpath="//input[@id='x_Customer_Number']")
	WebElement objCustNo;
	
	@FindBy(xpath="//input[@id='x_Customer_Name']")
	WebElement objcustname;
	
	@FindBy(xpath="//textarea[@id='x_Address']")
	WebElement objAddress;
	
	
	@FindBy(xpath="//input[@id='x_City']")
	WebElement objcity;
	
	@FindBy(xpath="//input[@id='x_Country']")
	WebElement objcountry;
	
	@FindBy(xpath="//input[@id='x_Contact_Person']")
	WebElement objcontactp;
	
	@FindBy(xpath="//input[@id='x_Phone_Number']")
	WebElement objphonenum;
	
	@FindBy(xpath="//input[@id='x__Email']")
	WebElement objemail;
	
	@FindBy(xpath="//input[@id='x_Mobile_Number']")
	WebElement objmobno;
	
	@FindBy(xpath="//input[@id='x_Notes']")
	WebElement objnotes;
	
	@FindBy(id="btnAction")
	WebElement objadbtn;
	
		
	@FindBy(xpath="//button[normalize-space()='OK!']")
	WebElement objAddok;
	
	
	@FindBy(xpath="(//button[starts-with(text(),'OK')])[6]")
   WebElement  objalertok;	
 
	@FindBy(xpath="//span[@data-caption='Search']")
	   WebElement  objsearchPanel;

	@FindBy(xpath="//input[@id='psearch']")
	   WebElement  objsearchtextbox;	
	
	
	@FindBy(xpath="//button[@id='btnsubmit']")
	WebElement objsearchbtn;
	
	@FindBy(xpath="//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span") 
	WebElement objTable;
	
	
	
	//methods for customer page
   public boolean addCustomer(String cname,String address,String city,String country,String cperson,String phno,String email
		   ,String mobno,String notes)throws Throwable
   {
	   
	   objcustomerlink.click();
	   objAddicon.click();
	   
	 String expdata= objCustNo.getAttribute("value");
	 
	 objcustname.sendKeys(cname);
	 objAddress.sendKeys(address);
	 objcity.sendKeys(city);
	 objcountry.sendKeys(country);
	 objcontactp.sendKeys(cperson);
	 objphonenum.sendKeys(phno);
	 objemail.sendKeys(email);
	 objmobno.sendKeys(mobno);
	 objnotes.sendKeys(notes);
	 
     objadbtn.sendKeys(Keys.ENTER);
     Thread.sleep(2000);
     
     objAddok.click();
         Thread.sleep(2000);
    
         objalertok.click();
	 
	 if(!objsearchtextbox.isDisplayed())
	 {
		 objsearchPanel.click();
	 }
	   objsearchtextbox.clear();
       Thread.sleep(2000);
	   objsearchtextbox.sendKeys(expdata);
	   objsearchbtn.click();
	   
  Thread.sleep(3000);
	   
	   String actualdata=objTable.getText();
	   
	//   Thread.sleep(3000);
	   if(expdata.equals(actualdata))
	   {
		   Reporter.log("Customer added sucessfully"+expdata+"........"+actualdata,true);
		  return true; 
	   }
		  
	   else
	   {
		   Reporter.log("customer is not added"+expdata+"......."+actualdata,true);
		   return false;

	   }
   
   }






}
