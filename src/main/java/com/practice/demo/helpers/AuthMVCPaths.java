package com.practice.demo.helpers;

public class AuthMVCPaths {
	private static String AUTH_HOME_PATH = "auth";
	
	public static String redirectToLogin(String s) {
		return String.format("redirect:/%s", login(s)) ;
	}
	
	public static String signup() {
		return String.format("%s/%s", AUTH_HOME_PATH, "signup");
	}
	
	public static String login(String s) {
		return String.format("%s%s/%s", s, AUTH_HOME_PATH, "login");
	}

	public static String logout() {
		return String.format("%s/%s", AUTH_HOME_PATH, "logout");
	}

}
