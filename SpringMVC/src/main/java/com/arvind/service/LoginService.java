package com.arvind.service;

public class LoginService {

	public boolean isLoginSuccessful( String username, String password ) {
		
		//Connect to DB and fetch the username and password combination
		String usernameFromDB = "admin"; // for test 
		String passwordFromDB = "password";
		
		return ( username.equals( usernameFromDB ) && password.equals( passwordFromDB ) );
	}
	
}
