package com.revature1.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature1.model.Reimburse;
import com.revature1.repository.ReimburseRepository;
import com.revature1.repository.ReimburseRepositoryImpl;

public class ReimbursePostServlet extends HttpServlet {
       

	private static final long serialVersionUID = 9135341494505270383L;


    public ReimbursePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestBodyText = new String(request.getInputStream().readAllBytes());
		

		
		ObjectMapper objectMapper = new ObjectMapper();
		Reimburse clientReimburse = objectMapper.readValue(requestBodyText, Reimburse.class);
		

		ReimburseRepository reimburseRepository = new ReimburseRepositoryImpl();
		reimburseRepository.save(clientReimburse);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

