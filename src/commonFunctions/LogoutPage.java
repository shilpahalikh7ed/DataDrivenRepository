package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage 
{

    //repository
	@FindBy(xpath="(//a[contains(text(),'Logout')])[3]")
	WebElement objlogout;
	
	//method for logout
	
	public void logout()
	{
		objlogout.click();
	}
	
	
	


}
