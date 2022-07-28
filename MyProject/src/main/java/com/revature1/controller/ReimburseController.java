package com.revature1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature1.model.Reimburse;
import com.revature1.model.User;
import com.revature1.repository.ReimburseRepository;
import com.revature1.repository.ReimburseRepositoryImpl;

public class ReimburseController { 

	private static ReimburseRepository reimburseRepository;
	public static ObjectMapper objectMapper;
	
	public ReimburseController() {
		reimburseRepository = new ReimburseRepositoryImpl();
		objectMapper = new ObjectMapper();
	}
	
	public static String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String json = objectMapper.writeValueAsString(reimburseRepository.findAllReimburse());
		return json;
	}
	
	public static void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String jsonBody = new String(request.getInputStream().readAllBytes());
		Reimburse newReimburse = objectMapper.readValue(jsonBody, Reimburse.class);
		reimburseRepository.save(newReimburse);
	}
}
