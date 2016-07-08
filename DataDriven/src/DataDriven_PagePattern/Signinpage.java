package DataDriven_PagePattern;

public class Signinpage {
	
	

//	public static boolean Isatsigninpage(){
//		return false;
//	}

	public static Logincommands loginas(String trellousername) {
		Logincommands logincmd=new Logincommands(trellousername);
		System.out.println("init "+trellousername);
		return logincmd;
	}

}
