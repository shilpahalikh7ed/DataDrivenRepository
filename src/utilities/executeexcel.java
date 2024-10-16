package utilities;

public class executeexcel {

	public static void main(String[] args) throws Throwable{
		
		ExcelFileUtil ex=new ExcelFileUtil("F:/Data.xlsx");
		
		int rc=ex.countRows("First");
		
		for(int i=1;i<=rc;i++)
		{
			String fname=ex.getDataFromCell("First",i,0);
			String mname=ex.getDataFromCell("First", i, 1);
			String lname=ex.getDataFromCell("First", i, 2);
			String eid=ex.getDataFromCell("First", i, 3);
		    System.out.println(fname+"  "+lname+"  "+mname+"  "+eid);
		    ex.writeToCell("First",i,4,"fail","F:/projfile.xlsx");
		}
		
		
		
	}

}
