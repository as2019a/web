package com.inc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.inc.connector.MybatisConnector;
import com.inc.domain.Employee;

public class EmployeeDao {
	private static EmployeeDao single;

	private EmployeeDao() {};

	public static EmployeeDao getInstance() {
		if (single == null) {
			single = new EmployeeDao();
		}
		return single;
	}

	public List<Employee> selectList(){
		SqlSession session = 
			MybatisConnector.getInstance().getSqlSession();
		List<Employee> employeeList = session.selectList("employees.selectList");
		session.close();
		return employeeList;
	}
}
