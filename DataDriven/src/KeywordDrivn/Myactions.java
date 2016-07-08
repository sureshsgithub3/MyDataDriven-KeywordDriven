package KeywordDrivn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Myactions {
	public static WebDriver driver;
	
	public static WebElement WaitforElement(By locator,int seconds){
		return(new WebDriverWait(driver,seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static void openBrowser(String s, String d)
	{		
		driver=new FirefoxDriver();
	}
	public static void navigate(String s, String d)
	{	
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
	}
	public  void input_Username(String s, String d)
	{
		//driver.findElement(By.id(s)).sendKeys(d); 
		WaitforElement(By.id(s), 2000).sendKeys(d);
	}
	
	public static void click_next(String s,String d)
	{
		//driver.findElement(By.id(s)).click();
		WaitforElement(By.id(s), 2000).click();
	}
	
	public static void input_Password(String s, String d)
	{
		//driver.findElement(By.id(s)).sendKeys(d);
		WaitforElement(By.id(s), 2000).sendKeys(d);
	}
	public static void click_Login(String s, String d)
	{
		//driver.findElement(By.id(s)).click();
		WaitforElement(By.id(s), 2000).click();
	}
	public static void waitFor(String s, String d) throws Exception
	{
		Thread.sleep(10000);
	}
	
	
	public static void click_profile(String s, String d)
	{
		//driver.findElement (By.xpath(s)).click();
		WaitforElement(By.xpath(s),2000).click();
	}
	public static void click_Logout(String s, String d)
	{
		//driver.findElement (By.id(s)).click();
		WaitforElement(By.id(s), 2000).click();
	}
	public static void closeBrowser(String s, String d)
	{
			driver.quit();
	}

}
