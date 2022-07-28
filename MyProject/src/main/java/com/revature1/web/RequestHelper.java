package com.revature1.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature1.controller.UserController;
import com.revature1.controller.UserController;
import com.revature1.model.User;
import com.revature1.repository.UserRepository;
import com.revature1.repository.UserRepositoryImpl;


public class RequestHelper {

	public static Object processGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String resource = request.getRequestURI();


		System.out.println(resource);


		String isolatedResource = resource.replace("/ServletDemo/api", "");

		switch (isolatedResource) {
		case "/users":

			response.setContentType("application/json");
			return UserController.findAll(request, response);
		default:

			response.setStatus(404);
			break;
		}

		return null;
	}

	public static void processPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String resource = request.getRequestURI().replace("/MyProject/api", "");

		switch (resource) {
		case "/user":
			UserController.save(request, response);
			break;
		default:
			response.setStatus(404);
			break;
		}

	}
}
