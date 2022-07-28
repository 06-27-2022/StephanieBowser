package com.revature1.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature1.model.Reimburse;
import com.revature1.repository.ReimburseRepository;
import com.revature1.repository.ReimburseRepositoryImpl;

public class AllReimbursesServlet extends HttpServlet{


	private static final long serialVersionUID = -5011186694066443108L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		ReimburseRepository reimburseRepository = new ReimburseRepositoryImpl();
		List<Reimburse> reimburses = reimburseRepository.findAllReimburse();
		
		ObjectMapper imTheMap = new ObjectMapper();
		String json = imTheMap.writeValueAsString(reimburses);

		response.setContentType("application/json"); //you should be setting the content type
		PrintWriter writer = response.getWriter();
		writer.write(json);
	}

}
