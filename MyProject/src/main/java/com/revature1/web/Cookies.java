package com.revature1.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Cookies extends HttpServlet{

	private static final long serialVersionUID = -584985904574226172L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		
		if(username.equals("smbowser") && password.equals("password")) {

			Cookie myCookie = new Cookie("authenticated", "true");
			Cookie badCookie = new Cookie("password", password);

			response.addCookie(myCookie);
			response.addCookie(badCookie);
		}else {
			response.setStatus(401);
		}
		
		
	}

	
}
