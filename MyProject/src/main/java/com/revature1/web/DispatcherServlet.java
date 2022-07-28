package com.revature1.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature1.controller.UserController;
import com.revature1.model.User;
import com.revature1.repository.UserRepository;
import com.revature1.repository.UserRepositoryImpl;


public class DispatcherServlet extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7798220476853049492L;

	/**
	 * 
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		/*
		 * I want to remake my previous endpoints for users: /users/all and /user.
		 * In order to do this, I have to redirect the incoming HTTP request and HTTP response objects
		 * to the right places.
		 * 
		 * Since I am using the doGet method to handle all of this servlet's logic (even
		 * the logic for doPost), I might want to check the HTTP verb first.
		 * 
		 * I might also need to check the URI.
		 */
		
		String httpVerb = request.getMethod(); //isolating the verb
		
		if(httpVerb.equals("GET")) {
			RequestHelper.processGet(request, response);
		} else if(httpVerb.equals("POST")) {
			RequestHelper.processPost(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response); //deferring to the logic for doGet
	}

}