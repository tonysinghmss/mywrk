package mywrk.utils;

public class Ctrlr {
	public static String createRedirectPath(String path){
		StringBuilder redirectPath = new StringBuilder("redirect:");
		redirectPath.append(path);
		return redirectPath.toString();
	}
}
