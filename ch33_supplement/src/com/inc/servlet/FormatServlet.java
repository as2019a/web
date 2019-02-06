package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/format")
public class FormatServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("number", 5312030);
		request.setAttribute("date", "18/11/16 14:02:30");
		request.getRequestDispatcher("/WEB-INF/views/fromat.jsp").forward(request, response);
	}

}
