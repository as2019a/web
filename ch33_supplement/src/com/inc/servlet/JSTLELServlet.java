package com.inc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstlel")
public class JSTLELServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> nameList = new ArrayList<>();
		nameList.add("harry");
		nameList.add("lone");
		nameList.add("hermione");
		
		nameList.add("Kim");
		nameList.add("Lee");
		nameList.add("Park");
		request.setAttribute("nameList", nameList);
		
		request.getRequestDispatcher("/WEB-INF/views/jstlel.jsp").forward(request, response);
	}

}
