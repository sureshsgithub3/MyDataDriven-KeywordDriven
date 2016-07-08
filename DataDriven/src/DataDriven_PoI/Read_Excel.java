package DataDriven_PoI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel {

	public static void main(String[] args) throws Exception, IOException {
		File file= new File("Read_Excel.xlsx");
		FileInputStream fin=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet sht=wb.getSheetAt(0);
		int rows= sht.getLastRowNum();
		System.out.println(rows);
		
//		for(int x=1;x<=rows;x++)
//		{
//			String username=sht.getRow(x).getCell(0).getStringCellValue();
//			System.out.println(username);
//		}

	}

}
