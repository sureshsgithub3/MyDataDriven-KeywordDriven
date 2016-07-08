package DataDriven_PagePattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;


import org.junit.Test;

public class Login_Test {
	
	
	@Test
	public void excelhandler() throws Exception{
		
			try {
				FileInputStream file=new FileInputStream("Trllo_dd_pp.xls");
		        HSSFWorkbook workbook=new HSSFWorkbook(file);
				HSSFSheet sheet1=workbook.getSheet("Trello");
				int trellorows=sheet1.getLastRowNum();
				
				System.out.println(" set of data :"+trellorows);
				
				for(int i=1;i<=trellorows;i++)
				{
					String trellousername=String.valueOf(sheet1.getRow(i).getCell(0));
					String trellopassword= String.valueOf(sheet1.getRow(i).getCell(1));
					String trellocriteria=String.valueOf(sheet1.getRow(i).getCell(2));
					
					System.out.println(trellousername+","+trellopassword+","+trellocriteria);
					
					Homepage.Goto();
					System.out.println("treelo opened ");
					Signinpage.loginas(trellousername).withpassword(trellopassword).Login();
					Thread.sleep(3000);
					
					Cell cell=sheet1.getRow(i).createCell(3);
					cell.setCellType(Cell.CELL_TYPE_STRING);
					
					if(Myaccountpage.Isableloginas().equals("https://trello.com/"))
					{
						if(trellocriteria.equals("valid"))
						{
							cell.setCellValue("valid login");
						}
						else{
							cell.setCellValue("vlid login but not valid criteria");
						}
							
						
						
					}else
					
					{
						System.out.println("failure");
						cell.setCellValue("failure : invalid credentails");
					}
					FileOutputStream fileout=new FileOutputStream("C:\\Users\\suresh\\Desktop\\Selenium data Files\\Excel files\\Data drivens\\Trllo_dd_pp.xls");
					workbook.write(fileout);
					fileout.close();
					Homepage.close();
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
