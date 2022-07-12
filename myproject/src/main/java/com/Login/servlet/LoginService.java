package com.Login.servlet;

public class LoginService {

	public boolean LoginCheck(String username, String password) {
	if (username.equals("sonawane") && password.equals("123456"))
		return true;
	return false;
	}

}


