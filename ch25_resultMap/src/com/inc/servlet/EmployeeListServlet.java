package com.inc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.EmployeeDao;
import com.inc.dao.HrDao;
import com.inc.domain.Employee;


@WebServlet("/employee/list")
public class EmployeeListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> employeeList =
				HrDao.getInstance().selectList();
			/*for(Employee employee : employeeList) {
				System.out.printf("%d | %s | %d\n",
						employee.getEmployee_id(),
						employee.getFirst_name(),
						employee.getSalary());
			}*/
			request.setAttribute("employeeList", employeeList);
			request.getRequestDispatcher(
					"/WEB-INF/views/employee/list.jsp")
					.forward(request, response);
			
	}

}
