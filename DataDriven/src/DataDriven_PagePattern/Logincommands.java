package DataDriven_PagePattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logincommands {
	public String trellousername;
	public String password;
	
	public Logincommands(String username)
	{
		this.trellousername=username;
	}
	
	public Logincommands withpassword(String password)
	{
		this.password=password;
		return this;
	}
	
	
	public WebElement Waitforelement(By locator,int seconds)
	{
		return (new WebDriverWait(Homepage.driver, seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		
	}
	
	public void Login()
	{
		System.out.println("sign page "+trellousername);
		Waitforelement(By.id("user"),500).sendKeys(trellousername);
		Waitforelement(By.id("password"),500).sendKeys(password);
		Waitforelement(By.id("login"), 5000).click();
		
		
	}
	
	
	
	

}
