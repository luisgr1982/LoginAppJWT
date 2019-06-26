package com.at.loginapp.utils;

public class Constants {
	public static final String HEADER = "Authorization";
	public static final String PREFIX = "Bearer ";
	public static final long validityInMilliseconds = 3600000; // 1h
	
	public static final String REGISTER_URL ="/register";
	public static final String LOGIN_URL="/login";
	public static final String LOGOUT_URL="/logout";
	public static final String H2DATABASE_URL="/h2-console/**/**";
	public static final String HOME_URL="/home";
	public static final String USERCONTROLLER_URL="/";
}
