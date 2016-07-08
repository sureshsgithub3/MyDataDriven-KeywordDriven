package Datadriven_Pagepattern1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Trello_Login_home {
	
	public static WebDriver driver;
	
	
	public static void open(){
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	public static void close(){
		driver.close();
	}
	 
	public static void Treelo_login(){
		open();
		driver.get("https://trello.com/login");
	}
	
	

}
