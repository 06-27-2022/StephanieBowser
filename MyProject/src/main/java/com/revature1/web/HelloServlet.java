package com.revature1.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -838848724365165431L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		
		String userName=request.getParameter("username");

		
		out.print("Welcome "+userName+" Create an Employee Reimbursement Ticket <form action=\"reimburseservlet\" method=\"post\">\r\n"
				+ "Welcome to the Employee Reimbursement System<br/><br/>\r\n"
				+ "\r\n"
				+ "<input type=\"submit\" value=\"Create Ticket\"/>\r\n"
				+ "\r\n"
				+ "</form>");
		
		out.close();
	}
protected void doPost1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		

}	
}
