package com.inc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.HrDao;
import com.inc.domain.Department;
import com.inc.domain.Employee;


@WebServlet("/department/list")
public class DepartmentListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Department> departmentList =
			HrDao.getInstance().selectDepartmentList();
		request.setAttribute("departmentList", departmentList);
		request.getRequestDispatcher(
				"/WEB-INF/views/department/list.jsp")
				.forward(request, response);
		
	}

}





