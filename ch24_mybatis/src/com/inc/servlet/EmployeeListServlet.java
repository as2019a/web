package com.inc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.EmployeeDao;
import com.inc.domain.Employee;


@WebServlet("/employee/list")
public class EmployeeListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> employeeList = EmployeeDao.getInstance().selectList();
		for(Employee employee : employeeList) {
			System.out.printf("%d | %s | %d\n", employee.getEmployee_id(), employee.getFirst_name(), employee.getSalary());
		}
	}

}
