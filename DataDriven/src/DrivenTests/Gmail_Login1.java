package DrivenTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Gmail_Login1 {
	WebDriver driver;
	String title;
	
	@Test
	public void Gmail_lgn() throws Exception{
		   File file=new File("Gmail_data2.xls");
		try {
			FileInputStream fin= new FileInputStream(file);
			Workbook workbook=Workbook.getWorkbook(fin);
			Sheet logindata=workbook.getSheet(0);
			WritableWorkbook wwb=Workbook.createWorkbook(file, workbook);
			WritableSheet writablesht=wwb.getSheet(0);

			
			int loginrows=logindata.getRows();
			
			for(int i=1;i<loginrows;i++)
			{
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
				driver.get("http://www.gmail.com");
				
				String gmailloginpagetitle=driver.getTitle();
				System.out.println("login page title:"+gmailloginpagetitle);
				
				Cell usrnme=logindata.getCell(0, i);
				Cell pwd=logindata.getCell(1, i);
				Cell crtria=logindata.getCell(2, i);
				
				 String username=usrnme.getContents();
				 String password=pwd.getContents();
				 String criteria =crtria.getContents();
				 
				 driver.findElement(By.name("Email")).sendKeys(username);
				 driver.findElement(By.id("next")).click();
				 
				 Thread.sleep(4000);
				 
				try
				{
				if(driver.findElement(By.id("Passwd")).isDisplayed())
				{
					driver.findElement(By.id("Passwd")).sendKeys(password);
					Thread.sleep(2000);
					driver.findElement(By.id("signIn")).click();
					Thread.sleep(10000);
					
					if(driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div[1]/div/div")).isDisplayed())
					{
						if(title.contains("Inbox")&& criteria.equalsIgnoreCase("valid"))
						{
						System.out.println(" valid user : logged in");
						Label l=new Label(3, i, "testpassed for valid user");
						writablesht.addCell(l);
						}
					}
					
					
					else if(driver.findElement(By.id("errormsg_0_Passwd")).isDisplayed())
					{
						String passworderror_msg=	driver.findElement(By.id("errormsg_0_Passwd")).getText();
						  System.out.println("invalid password :"+passworderror_msg);
						if(title.equalsIgnoreCase("Gmail")&&criteria.equalsIgnoreCase("invalid"))
						{
							
							Label l=new Label(3, i, "testpassed for invalid user");
							writablesht.addCell(l);
							
						}
					  
					}
					
					
				}
				}
				catch(Exception ex)
				{
					System.out.println("---------------------"+ex.toString());
					try
					{
					if(driver.findElement(By.id("errormsg_0_Email")).isDisplayed())
					{
						System.out.println("invalid username");
						String username_error=driver.findElement(By.id("errormsg_0_Email")).getText();
						System.out.println("invalid user name:"+username_error);
						
						//validation
						if(title.equalsIgnoreCase("Gmail")&&criteria.equalsIgnoreCase("invalid"))
						{
							
							Label l=new Label(3, i, "testpassed for invalid user");
							writablesht.addCell(l);
							
						}
						
					}
					}
					catch(Exception x)
					{
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!"+x.toString());
					}
				}
				
				finally
				{
					wwb.write();
					wwb.close();
					workbook.close();
				driver.close(); 
				}
			}
			
			
			
			
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
