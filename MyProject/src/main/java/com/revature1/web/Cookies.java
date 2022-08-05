package com.revature1.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature1.util.ConnectionUtil;


public class Cookies extends HttpServlet{

	private static final long serialVersionUID = -584985904574226172L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		String userName = request.getParameter("username");
		String Password = request.getParameter("password");

		if(ConnectionUtil.validate(userName, Password)){
			RequestDispatcher httpVerb=request.getRequestDispatcher("reimburse");
			httpVerb.forward(request,response);
			Cookie myCookie = new Cookie("authenticated", "true");
			Cookie badCookie = new Cookie("password", Password);

			response.addCookie(myCookie);
			response.addCookie(badCookie);
		}
		else{
			response.setStatus(401);
			//out.print("<br/>Username or password error<br/><br/>");

			
		}
		
		
		
	}

	
}
