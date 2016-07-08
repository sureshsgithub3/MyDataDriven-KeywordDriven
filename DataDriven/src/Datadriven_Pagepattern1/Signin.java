package Datadriven_Pagepattern1;

public class Signin {
	
	
	
	public  static   Signin_Commands  loginas (String username,String password)
	{    
		Signin_Commands signincmnds=new  Signin_Commands(username, password);
		return signincmnds;
		
	}
	
	
	
	

}
