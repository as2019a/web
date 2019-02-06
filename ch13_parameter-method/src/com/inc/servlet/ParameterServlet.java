package com.inc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/parameter")
public class ParameterServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, 
						   HttpServletResponse response) throws ServletException, IOException {
		String msg = request.getParameter("msg");
		System.out.printf("msg : %s\n", msg);
		int number = Integer.parseInt(
						request.getParameter("number"));
		System.out.printf("number : %d\n", number);
		//String city = request.getParameter("city");
		//System.out.printf("city : %s\n", city);
		String[] cityArray = request.getParameterValues("city");
		System.out.printf("city1 : %s, city2 : %s\n", cityArray[0], cityArray[1]);
	}
	
}







