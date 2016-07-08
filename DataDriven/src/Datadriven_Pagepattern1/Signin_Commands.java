package Datadriven_Pagepattern1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DataDriven_PagePattern.Homepage;

public class Signin_Commands {
	
	public String username;
	public String password;
	
	
	public Signin_Commands(String username,String password){
		this.username=username;
		this.password=password;
	}
	
	public void login(){
		System.out.println("sign page "+username);
		Waitforelement(By.id("user"),500).sendKeys(username);
		Waitforelement(By.id("password"),500).sendKeys(password);
		Waitforelement(By.id("login"), 5000).click();
		
	}
	public WebElement Waitforelement(By locator,int seconds)
	{
		return (new WebDriverWait(Homepage.driver, seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		
	}
	
	

}
