package com.inc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.inc.connector.MybatisConnector;
import com.inc.domain.Department;
import com.inc.domain.Employee;

public class HrDao {
	private static HrDao single;

	private HrDao() {};

	public static HrDao getInstance() {
		if (single == null) {
			single = new HrDao();
		}
		return single;
	}

	public List<Employee> selectList(){
		SqlSession session = 
			MybatisConnector.getInstance().getSqlSession();
		List<Employee> employeeList = 
			session.selectList("employees.selectList");
		session.close();
		return employeeList;
	}

	public List<Department> selectDepartmentList() {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		List<Department> departmentList = session.selectList("departments.selectList");
		session.close();
		
		return departmentList;
	}
}