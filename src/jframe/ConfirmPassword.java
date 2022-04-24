package jframe;
//It confirms the password
public class ConfirmPassword {
	
	public static boolean confirmPass (String password, String confirmpass) {
		
		return password.equals(confirmpass);
	}

}
