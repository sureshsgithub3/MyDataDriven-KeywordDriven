package Datadriven_Pagepattern1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;

public class Treelo_credentials_reader_writer {
	
	
	
	@Test
	public void Reader() throws Exception{
		;
		try {
			FileInputStream 	file = new FileInputStream("Trllo_dd_pp.xls");
			HSSFWorkbook workbook=new HSSFWorkbook(file);
			HSSFSheet  sheet=workbook.getSheet("Trello");
			int loginsheetrows=sheet.getLastRowNum();
			
			System.out.println("total sets of data :"+loginsheetrows);
			
			for(int i=1;i<=loginsheetrows;i++)
			{
			 String username=String.valueOf(sheet.getRow(i).getCell(0));
			 String password=String.valueOf(sheet.getRow(i).getCell(1));
			 String criteria=String.valueOf(sheet.getRow(i).getCell(2));
			 
			 System.out.println(username+","+password+" "+criteria);
			 
			 Trello_Login_home.Treelo_login();
			 Signin.loginas(username, password).login();
			 Thread.sleep(3000);
			 Cell cell=sheet.getRow(i).createCell(3);
			 cell.setCellType(Cell.CELL_TYPE_STRING);
			 
			 if(Myaccountpage.Isatlogged().equals("https://trello.com/"))
			 {
				 
				 if(criteria.equals("valid"))
				 {
					 cell.setCellValue("valid credentials");
				 }else if(criteria.equals("invalid"))
				 {
					 cell.setCellValue("valid  user credentails");
				 }
			 }else{
				 cell.setCellValue("invalid user credentails");
			 }
			 FileOutputStream fileout=new FileOutputStream("C:\\Users\\suresh\\Desktop\\Selenium data Files\\Excel files\\Data drivens\\Trllo_dd_pp.xls");
			 workbook.write(fileout);
			 fileout.close();
			 Trello_Login_home.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
