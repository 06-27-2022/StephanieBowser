package com.revature1.web;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ReimburseServlet extends HttpServlet {

	private static final long serialVersionUID = 4252613357484626472L;


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String userName=request.getParameter("username");
		String amount=request.getParameter("amount");
		String description=request.getParameter("description");

			out.print("Create New Reimbursement Ticket");
			RequestDispatcher httpVerb=request.getRequestDispatcher("ticket.html");
			httpVerb.include(request,response);
			String input = "Reimbursement amount " + amount + " Reason: " + description;
			System.out.println(input);
			
		}
	
	}

