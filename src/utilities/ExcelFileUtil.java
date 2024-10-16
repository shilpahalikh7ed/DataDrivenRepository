package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.internal.thread.ThreadExecutionException;

public class ExcelFileUtil   
{

	public FileInputStream fi;

	XSSFWorkbook wb;
	public ExcelFileUtil(String inputfilepath) throws Throwable
	{
		fi=new FileInputStream(inputfilepath);
		wb=new XSSFWorkbook(fi);

	}

	public int countRows(String sheetName)
	{
		int no=wb.getSheet(sheetName).getLastRowNum();
		return no;
	}

	public String getDataFromCell(String sheetName,int row,int coloumn)
	{

		String data="";
		if(wb.getSheet(sheetName).getRow(row).getCell(coloumn).getCellType()==CellType.NUMERIC)
		{
			int x=(int)wb.getSheet(sheetName).getRow(row).getCell(coloumn).getNumericCellValue();
			data=Integer.toString(x);
			return data;

		}
		else
		{
			data=wb.getSheet(sheetName).getRow(row).getCell(coloumn).getStringCellValue();
            return data;
		}

	}


    public void writeToCell(String sheetName,int row,int col,String status,String outputfilepath) throws Throwable
    {
    	  XSSFCellStyle style;
    	  XSSFFont font;
          
    	  wb.getSheet(sheetName).getRow(row).createCell(col).setCellValue(status);
    
             if(status.equalsIgnoreCase("pass"))
             {
            	 style=wb.createCellStyle();
            	 font=wb.createFont();
            	 
            	  font.setBold(true);
            	  font.setColor(IndexedColors.GREEN.getIndex());
            	  

            	  style.setFont(font);
            	 wb.getSheet(sheetName).getRow(row).getCell(col).setCellStyle(style);
                     	 
            	 
             }
    
             else if(status.equalsIgnoreCase("fail"))
             {
            	
            	 
            	 style=wb.createCellStyle();
            	 font=wb.createFont();
            	 
            	 font.setBold(true);
            	 font.setColor(IndexedColors.RED.getIndex());
            	 
            	 style.setFont(font);
            	 wb.getSheet(sheetName).getRow(row).getCell(col).setCellStyle(style);
            	 
            	 
             }
             
             
             else if(status.equalsIgnoreCase("blocked"))
             {
            	 style=wb.createCellStyle();
            	 font=wb.createFont();
            	 
            	 font.setBold(true);
            	 font.setColor(IndexedColors.BLUE.getIndex());
            	 
            	 style.setFont(font);
            	 wb.getSheet(sheetName).getRow(row).getCell(col).setCellStyle(style);
            	 
             }
                       
         FileOutputStream fo=new FileOutputStream(outputfilepath) ;
         wb.write(fo);
         
    
    }

}