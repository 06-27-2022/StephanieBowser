package com.revature1.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature1.model.User;
import com.revature1.repository.UserRepository;
import com.revature1.repository.UserRepositoryImpl;

/**
 * This servlet will intercept HTTP GET and POST requests. Our intention behind creating
 * this servlet is to create logic that allows us to receive user data as JSON
 * from the client and ultimately persist that data in our DB.
 */
public class UserPostServlet extends HttpServlet {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 4762838189658838070L;

	/**
	 * 
	 */


	/**
     * @see HttpServlet#HttpServlet()
     */
    public UserPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * I'm actually putting my logic for POST requests here because the doPost method
		 * calls doGet anyway.
		 */
		
		/*
		 * We know that the client is going to make a POST request that sends JSON. We
		 * need to grab that data from the request body.
		 */
		String requestBodyText = new String(request.getInputStream().readAllBytes());
		
		/*
		 * After you have retrieved the request body and converted into a String, you
		 * will want to deserialize it into a Java object using Jackson's Object Mapper.
		 */
		
		ObjectMapper objectMapper = new ObjectMapper();
		User clientUser = objectMapper.readValue(requestBodyText, User.class);
		
		/*
		 * Our ultimate goal is to persist the user data in our DB. We already have
		 * a connection our DB. We already have a repository layer which contains methods
		 * that allow me to interact with my "user" table in my DB. That said, I can
		 * just use my UserRepositoryImpl class and call one of those methods.
		 * 
		 * So create an instance of the UserRepositoryImpl class.
		 */
		
		UserRepository userRepository = new UserRepositoryImpl();
		userRepository.save(clientUser);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
