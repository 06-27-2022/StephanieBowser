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

public class ReimburseUpdateServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8052954608980586666L;


	public ReimburseUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestBodyText = new String(request.getInputStream().readAllBytes());
		

		
		ObjectMapper objectMapper = new ObjectMapper();
		Reimburse clientReimburse = objectMapper.readValue(requestBodyText, Reimburse.class);
		

		ReimburseRepository reimburseRepository = new ReimburseRepositoryImpl();
		reimburseRepository.update(clientReimburse);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
