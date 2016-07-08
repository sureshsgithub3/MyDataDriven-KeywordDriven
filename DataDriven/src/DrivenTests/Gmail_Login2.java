package DrivenTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Gmail_Login2 {
	WebDriver driver;
	String title;
	
	@Test
	public  void Gmail_login() throws Exception{
		
		File file =new File("Gmail_data2.xls");
		try {
			FileInputStream fin=new FileInputStream(file);
			Workbook workbook=Workbook.getWorkbook(fin);
			Sheet logindata=workbook.getSheet(0);
			WritableWorkbook wwb=Workbook.createWorkbook(file, workbook);
			WritableSheet writablesht=wwb.getSheet(0);
			
			int loginrows=logindata.getRows();
			System.out.println("total sets of credentials :"+loginrows);
			
			
			for(int i=1;i<loginrows;i++)
			{
				driver = new FirefoxDriver();
				driver.get("http://www.gmail.com");
				
				String username=logindata.getCell(0, i).getContents();
				String password=logindata.getCell(1, i).getContents();
				String  criteria=logindata.getCell(2, i).getContents();
				
				driver.findElement(By.id("Email")).sendKeys(username);
				driver.findElement(By.id("next")).click();
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try
				{
				if(driver.findElement(By.id("Passwd")).isDisplayed())
				{  //enter password
					driver.findElement(By.id("Passwd")).sendKeys(password);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//click sign in
					driver.findElement(By.id("signIn")).click();
					Thread.sleep(10000);
					
					if(driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div[1]/div/div")).isDisplayed())
					{
						System.out.println(" valid user : logged in");
						 title=driver.getTitle();
						 System.out.println("page title @ mailpage :"+title );
					}
					else if(driver.findElement(By.id("errormsg_0_Passwd")).isDisplayed())
					{
						String password_errormsg=driver.findElement(By.id("errormsg_0_Passwd")).getText();
						System.out.println("invalid passord :"+password_errormsg);
						title=driver.getTitle();
						System.out.println("page title @Wrng password :"+title );
					}
					
				}
				}
				catch(Exception ex)
				{
					//System.out.println("---------------------"+ex.toString());
					try
					{
					if(driver.findElement(By.id("errormsg_0_Email")).isDisplayed())
					{   
					String username_errormsg =	driver.findElement(By.id("errormsg_0_Email")).getText();
						System.out.println("invalid username :"+username_errormsg);
					title=	driver.getTitle();
					System.out.println("page title @Wrng username :"+title );
					}
					}
					catch(Exception x)
					{
						
					}
				}
				
				//validation
				
				System.out.println(title);
				if(title.contains("Inbox")&& criteria.equalsIgnoreCase("valid"))
				{
					System.out.println("1111");
					Label l=new Label(3, i, "testpassed for valid user");
					writablesht.addCell(l);
					System.out.println("2222");
				}
				else  if(title.equalsIgnoreCase("Gmail")&&criteria.equalsIgnoreCase("invalid"))
				{
					System.out.println("33333333");
					Label l=new Label(3, i, "testpassed for invalid user");
					writablesht.addCell(l);
					System.out.println("444444444");
				}
				else
				{
					System.out.println("5555555");
					Label l= new Label(3, i, "Test failed ");
				   writablesht.addCell(l);
				   System.out.println("6666");
				}
				System.out.println("77777");
				wwb.write();
				wwb.close();
				workbook.close();
				System.out.println("8888888");
				
				driver.close();
			}
			
		} catch (FileNotFoundException e) {
			e.getStackTrace();
			System.out.println(e.toString());
		} catch (BiffException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		
		
		
	}

}
