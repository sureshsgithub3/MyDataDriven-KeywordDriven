package DrivenTests;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class GmailLogin_DatadrivenNab1 {
	@Test
	public void Gmaillogin() throws InterruptedException{
		File file= new  File("gmaillogin.xls");
		try {
			Workbook workbook= Workbook.getWorkbook(file);
			Sheet credentials=workbook.getSheet(0);
			int no_of_credentials=credentials.getRows();
			
			System.out.println("Total Set of Data is :"+no_of_credentials);
			
			WritableWorkbook Writableworkbook=Workbook.createWorkbook(file);
			WritableSheet  writablesheet=Writableworkbook.getSheet(0);
			
			for(int i=1;i<no_of_credentials;i++)
			{
				String username=credentials.getCell(0, i).getContents();
				String password=credentials.getCell(1, i).getContents();
				
				WebDriver driver = new FirefoxDriver();
				driver.get("http://www.gmail.com");
				driver.manage().window().maximize();
				Thread.sleep(5000);
				driver.findElement(By.id("Email")).sendKeys(username);
				driver.findElement(By.id("next")).click();
				Thread.sleep(5000);
				driver.findElement(By.id("Passwd")).sendKeys(password);
				driver.findElement(By.id("signIn")).click();
				
				String title;
				title=driver.getTitle();
				if(title.contains("inbox"))
				{
					Label label=new Label(2, i, "valid");
					writablesheet.addCell(label);
				}else
				{
					Label label=new Label(2, i, "invalid");
					writablesheet.addCell(label);
				}
				
				driver.close();
				driver.quit();
					
				
			}
			Writableworkbook.write();
			Writableworkbook.close();
			workbook.close();
			
			
			
			
			
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
