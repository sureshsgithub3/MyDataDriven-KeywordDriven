package DrivenTests;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Gmail_Login {
	
	@Test
	public void Gmaillogin() throws InterruptedException, Exception{
		//Open existing Excel workbook/File reading and writting
				File f=new File("Gmail_data2.xls");
				Workbook wb=Workbook.getWorkbook(f);
				Sheet sh=wb.getSheet(0);
				int nour=sh.getRows();
				WritableWorkbook wwb=Workbook.createWorkbook(f,wb);
				WritableSheet wsh=wwb.getSheet(0);
				//Data driven login test
				for(int i=1; i<nour; i++)
				{
					//Read data
					String x, y, z;
					Cell c1=sh.getCell(0,i);
					Cell c2=sh.getCell(1,i);
					Cell c3=sh.getCell(2,i);
					x=c1.getContents();
					y=c2.getContents();
					z=c3.getContents();
					//Launch Gmail
					WebDriver obj=new FirefoxDriver();
					obj.get("http://www.gmail.com");
					obj.manage().window().maximize();
					Thread.sleep(4000);
					String titlebeforelogin=obj.getTitle();
					System.out.println("titlebeforelogin :"+titlebeforelogin);
					//Do login
					obj.findElement(By.name("Email")).sendKeys(x);
					
					if(obj.findElement(By.id("next")).isDisplayed())
					{
					obj.findElement(By.id("next")).click();
					 Thread.sleep(5000);
					  if(obj.findElement(By.id("Passwd")).isDisplayed())
					  {
						  
							obj.findElement(By.id("Passwd")).sendKeys(y);
							Thread.sleep(4000);
							obj.findElement(By.id("signIn")).click();
							Thread.sleep(10000);
					  }else
						  obj.findElement(By.id("signIn")).click();
						  Thread.sleep(5000);
					
					}
					
					
					
					//Validation
					String titleafterlogin;
					titleafterlogin=obj.getTitle();
					System.out.println("titleafterlogin :"+titleafterlogin);
					if(titleafterlogin.contains("Gmail")&& z.equals("valid"))
					{
					Label l=new Label(3,i,"Test passed for valid user");
					wsh.addCell(l);
				 }
			     else if(obj.findElement(By.id("errormsg_0_Passwd")).isDisplayed() && z.equals("invalid"))
				 {
				Label l=new Label(3,i,"Test passed for valid user");
				wsh.addCell(l);				
				}
				else
				{					Label l=new Label(3,i,"Test failed");
					wsh.addCell(l);
				}
				obj.close();
					obj.quit();
				}
				wwb.write();
				wwb.close();
				wb.close();
		
	}

}
