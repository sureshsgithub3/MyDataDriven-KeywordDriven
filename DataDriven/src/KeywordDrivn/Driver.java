package KeywordDrivn;

import java.io.File;


import jxl.Sheet;
import jxl.Workbook;



import java.lang.reflect.Method;

public class Driver {

	public static void main(String[] args) throws Exception{
		
		//Open excel file
				File file=new File("NabKywrdrvn.xls");
				Workbook Excelworkbook=Workbook.getWorkbook(file);
				//sheet1
				//Sheet Testcases=Excelworkbook.getSheet("Test_Cases");
				Sheet Testcases= Excelworkbook.getSheet("Test_Cases");
				
				//Reading number of rows of sheet1
				int testcases_sheet_Rows=Testcases.getRows();
				System.out.println("rows in sheet1"+testcases_sheet_Rows);
				//sheet2
				Sheet login=Excelworkbook.getSheet("Login"); 
				
				int login_sheet_Rows=login.getRows();
				//Create object for Action class
				Myactions a=new Myactions();
				//Actions class methods into array list
				Method actionmethods[]=a.getClass().getMethods();
				
				for(int i=1;i<testcases_sheet_Rows; i++)
				{
					String testcasename=Testcases.getCell(0,i).getContents();
					String testcasemode=Testcases.getCell(2,i).getContents();
					
					// Look for which Test cases has to be executed
					if(testcasemode.equalsIgnoreCase("yes"))
					{
						for(int j=1;j<login_sheet_Rows;j++)
						{
							String testcase_id=login.getCell(0,j).getContents();
							
							//compare Test case name of Testcases sheet  and Test id of login sheet
							if(testcasename.equalsIgnoreCase(testcase_id))
							{
								String action_on_target=login.getCell(3,j).getContents();
								String target_object=login.getCell(2,j).getContents();
								String testdata=login.getCell(4,j).getContents();
								System.out.println(action_on_target+","+target_object+","+testdata);
								
								//Read method names 
								for(int k=0;k<actionmethods.length;k++)
								{
									//compare methodnames with actions column in login sheet 
									if(actionmethods[k].getName().equals(action_on_target))
									{
										actionmethods[k].invoke(a,target_object,testdata);
										break;
									}
								}
							}
						}	
					}
				}
				Excelworkbook.close();
		

	}

}
