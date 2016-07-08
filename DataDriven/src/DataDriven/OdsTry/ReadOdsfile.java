package DataDriven.OdsTry;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class ReadOdsfile {
	
	@Test
	 public void ReadSheet() throws Exception{
		 File f= new File("trellosuresh.xlsx");
		 FileInputStream fio=new FileInputStream(f);
		 XSSFWorkbook wb=new XSSFWorkbook(fio);
		 XSSFSheet sh=wb.getSheetAt(0);
		 
		 int nor =sh.getLastRowNum();
		 System.out.println(nor);
		 
	 }
  
	
}
