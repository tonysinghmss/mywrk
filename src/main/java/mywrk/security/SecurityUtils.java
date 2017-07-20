package mywrk.security;

public class SecurityUtils {
	public static String getPasswordSalt(String pwd){
		return "demoSalt)1873(*&^098765LKJHG";
	}
	
	public static String getPasswordHash(String pwd){
		return "demoHash123!@#$fsdr%^OIUYTR";
	}
}
