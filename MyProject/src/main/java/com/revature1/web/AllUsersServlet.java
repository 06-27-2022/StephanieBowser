package com.revature1.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature1.model.User;
import com.revature1.repository.UserRepository;
import com.revature1.repository.UserRepositoryImpl;

public class AllUsersServlet extends HttpServlet{

	private static final long serialVersionUID = -158339544377432047L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		
		//Step 1
		UserRepository userRepository = new UserRepositoryImpl();
		List<User> users = userRepository.findAllUsers();
		
		//Step 2
		ObjectMapper imTheMap = new ObjectMapper();
		String json = imTheMap.writeValueAsString(users);
		
		//Step 3
		response.setContentType("application/json"); //you should be setting the content type
		PrintWriter writer = response.getWriter();
		writer.write(json);
	}

}