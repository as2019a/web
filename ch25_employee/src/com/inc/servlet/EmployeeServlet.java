package com.inc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.EmployeeDao;
import com.inc.domain.Employee;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(
				request.getParameter("id"));
		Employee employee = EmployeeDao.getInstance()
									   .selectOne(id);
		
		request.setAttribute("employee", employee);
		request.getRequestDispatcher(
				"/WEB-INF/views/employee.jsp")
				.forward(request, response);
	}

}
