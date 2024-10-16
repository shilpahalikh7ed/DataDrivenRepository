package driverFactory;

import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.FunctionLibrary;
import config.AppUtils;
import utilities.ExcelFileUtil;

public class DriverScript extends AppUtils
{
   public String inputexcelpath="./FileInput/DataFileForLogin.xlsx";
    public String outputexcelpath="./FileOutput/ResultDataDriven.xlsx";
   public String sheetname="Login";
    @Test
    public void startTest() throws Throwable
    {
    
    	//calls the constructor 
    ExcelFileUtil xl=new ExcelFileUtil(inputexcelpath);
    
    //count the no of rows
    
    int rc=xl.countRows(sheetname);
    
    for(int i=1;i<=rc;i++)
    {
    	
    String user=xl.getDataFromCell(sheetname, i, 0);
    String pass=xl.getDataFromCell(sheetname, i, 1);
      	  	
    Reporter.log(user+".."+pass,true);
   boolean r= FunctionLibrary.adminLogin(user,pass);
    
      if(r) 
      {
    	  xl.writeToCell(sheetname, i, 3,"pass",outputexcelpath);
    	  xl.writeToCell(sheetname, i, 4,"Login sucessful",outputexcelpath );
    	 // Reporter.log("Login sucessful",true);
      }
      else
      {
    	  xl.writeToCell(sheetname, i, 3, "fail", outputexcelpath);
    	  xl.writeToCell(sheetname, i, 4, "Login failed", outputexcelpath);
          //Reporter.log("Login failed",true);
      
      }
   
    }
    
    
	
	
}
}