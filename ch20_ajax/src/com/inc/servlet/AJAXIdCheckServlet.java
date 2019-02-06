package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/idcheck")
public class AJAXIdCheckServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String[] idList = {"flynn", "harry", "lone"};
		for(String existId : idList) {
			if(id.equals(existId)) {
				response.getWriter().print("exist");
				return;
			}
		}
		response.getWriter().print("notexist");
	}

}