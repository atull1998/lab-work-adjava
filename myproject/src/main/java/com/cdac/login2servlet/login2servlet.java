package com.cdac.login2servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Login.servlet.LoginService;

@WebServlet("/login2.cdac")
public class login2servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginService LoginService = new LoginService();
		boolean isValid = LoginService.LoginCheck(username ,password);
		
		if(isValid) {
			System.out.print("if");
	
			String rememberMe = request.getParameter("rememberMe");
			System.out.print(rememberMe);
			if (rememberMe != null && rememberMe.equals("yes")) {	
				Cookie c1 = new Cookie("uname",username);
				c1.setMaxAge(60*60*24);
				Cookie c2 = new Cookie("upass",password);
				c2.setMaxAge(60*60*24);
				response.addCookie(c1);
				
				response.addCookie(c2);
				System.out.print("if");
			}
			response.sendRedirect("Welcome.html");
		}
		else
			response.sendRedirect("login2.html");
		
	}

}
