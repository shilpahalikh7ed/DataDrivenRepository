package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage
{

//repository for loginpage
	
@FindBy(xpath = "//button[@id='btnreset']")
WebElement  objreset;


@FindBy(xpath="//input[@id='username']")
WebElement objuser;


@FindBy(xpath="//input[@id='password']")
WebElement objpass;

@FindBy(xpath="//button[@id='btnsubmit']")
WebElement objloginbtn;
	
//methods for login


public void login(String user,String pass)throws Throwable
{
	
  objreset.click();
    Thread.sleep(2000);
	
    
    objuser.sendKeys("admin");
	objpass.sendKeys("master");
	objloginbtn.click();
	
}



}
