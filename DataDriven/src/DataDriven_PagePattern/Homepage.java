package DataDriven_PagePattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Homepage {
	public static WebDriver driver;
	
	
	public static String baseurl="https://trello.com/login";
	public static String homepagetitle="Log in to Trello";
	
	

	public static boolean Isatloginpage(){
		return Browser.driver().getTitle().equals(homepagetitle);
	}

	public static void Goto() {
		open();
		driver.get("https://trello.com/login");
		
		
	}
	public static void open(){
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	public static void close(){
		driver.close();
	}
	

}
