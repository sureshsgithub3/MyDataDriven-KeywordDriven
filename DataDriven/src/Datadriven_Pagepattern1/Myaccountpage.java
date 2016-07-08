package Datadriven_Pagepattern1;

public class Myaccountpage {
	
	public static String Isatlogged(){
		return Trello_Login_home.driver.getCurrentUrl();
		
	}

}
