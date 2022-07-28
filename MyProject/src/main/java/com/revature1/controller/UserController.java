package com.revature1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature1.model.User;
import com.revature1.repository.UserRepository;
import com.revature1.repository.UserRepositoryImpl;

public class UserController { 

	private static UserRepository userRepository;
	public static ObjectMapper objectMapper;
	
	public UserController() {
		userRepository = new UserRepositoryImpl();
		objectMapper = new ObjectMapper();
	}
	
	public static String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String json = objectMapper.writeValueAsString(userRepository.findAllUsers());
		return json;
	}
	
	public static void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String jsonBody = new String(request.getInputStream().readAllBytes());
		User newUser = objectMapper.readValue(jsonBody, User.class);
		userRepository.save(newUser);
	}
}
