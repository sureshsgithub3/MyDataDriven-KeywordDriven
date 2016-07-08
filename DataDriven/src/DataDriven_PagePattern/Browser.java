package DataDriven_PagePattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	
	
	public static WebDriver driver;
	
	public static void open(){
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	public static void close(){
		driver.close();
	}
	
	public static WebDriver driver(){
		return driver;
	}
	

}
