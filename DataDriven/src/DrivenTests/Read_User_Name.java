package DrivenTests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Read_User_Name {

	public static void main(String[] args) throws BiffException, IOException {
		// Read_User_Name
		
		File f= new File("Add_ int values.xls");
		Workbook wb=Workbook.getWorkbook(f);
		Sheet sh= wb.getSheet(0);
		int nor=sh.getRows();
		int noc=sh.getColumns();
		   
		  
		
		for(int i=1;i<nor;i++){
			Cell c1=sh.getCell(0, i);
			Cell c2=sh.getCell(1,i);
			String x= c1.getContents();
			String y=c2.getContents();
			System.out.println(x);
			System.out.println(y);
			
			
			 
			
			
			
			
		}
		
		

	}

}
