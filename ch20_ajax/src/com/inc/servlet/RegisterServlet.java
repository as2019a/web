package com.inc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.CategoryDao;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> categoryList = 
				CategoryDao.getInstance().selectList();
		request.setAttribute("categoryList", categoryList);
		request.getRequestDispatcher(
				"/WEB-INF/views/register.jsp")
				.forward(request, response);
	}

}
