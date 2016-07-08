package DataDriven_PoI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class Read_Write {
	@Test
	public void ReadWrite(){
		try {
			FileInputStream file= new FileInputStream("Read_Write.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			XSSFSheet testcases=workbook.getSheet("Test_cases");
			
			// read data from excel file
			int Rowno=testcases.getLastRowNum();
			
			
			
			System.out.println("rows:"+Rowno);
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	

}
