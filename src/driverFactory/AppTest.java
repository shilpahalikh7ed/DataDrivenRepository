package driverFactory;

//import java.io.FileInputStream;
//import java.io.FileOutputStream;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import commonFunctions.CustomerPage;
import config.AppUtils1;
import utilities.ExcelFileUtil;

public class AppTest extends AppUtils1
{
     String inputpath="./FileInput/CustomerData.xlsx";
     String outputpath ="./FileOutput/CustomerReport.xlsx";
     String sheetname="CustomerData";
	
	@Test
	public void startTest()throws Throwable
	{
		ExcelFileUtil xl=new ExcelFileUtil(inputpath);
		
		int rc=xl.countRows(sheetname);
		
		for(int i=1;i<=rc;i++)
		{
			
			String cname=xl.getDataFromCell(sheetname, i, 0);
			String address=xl.getDataFromCell(sheetname, i, 1);
			String city=xl.getDataFromCell(sheetname, i, 2);
			String country=xl.getDataFromCell(sheetname, i, 3);
			String cperson=xl.getDataFromCell(sheetname, i, 4);
			String phno=xl.getDataFromCell(sheetname, i, 5);
			String email=xl.getDataFromCell(sheetname, i, 6);
			String mobno=xl.getDataFromCell(sheetname, i, 7);
			String notes=xl.getDataFromCell(sheetname, i, 8);
			
			CustomerPage cp=PageFactory.initElements(driver,CustomerPage.class);
	       
		boolean r=cp.addCustomer(cname, address, city, country, cperson, phno, email, mobno, notes);

		 if(r) 
		 {
			 xl.writeToCell(sheetname,i,9,"pass",outputpath);
		 }
		 else
		 {
			 xl.writeToCell(sheetname,i,9,"fail",outputpath);
		 }
		
	

		}
}
}