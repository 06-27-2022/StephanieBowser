package com.revature1.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature1.util.*;

public class FirstServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8852483016136937750L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userName=request.getParameter("username");
		String Password=request.getParameter("password");

		
		if(ConnectionUtil.validate(userName, Password)){
			RequestDispatcher httpVerb=request.getRequestDispatcher("helloservlet");
			httpVerb.forward(request,response);
		}
		else{
			response.setStatus(401);
			out.print("<br/>Username or password error<br/><br/>");
			RequestDispatcher httpVerb=request.getRequestDispatcher("index.html");
			httpVerb.include(request,response);
			
		}
		
		if(userName.equals("smbowser") && Password.equals("password")) {
			/*
			 * Instead of using cookies, we're using something called an HttpSession.
			 * In order to create an HttpSession, we need to use the request object.
			 * 
			 * Note than an HttpSession stores some information about the session on
			 * the server side. Of course, you still have to check elsewhere for the
			 * existence of a session.
			 */
			
			HttpSession session = request.getSession();
			
		}else {
			response.setStatus(401);
		}
		
		out.close();
	}

}
