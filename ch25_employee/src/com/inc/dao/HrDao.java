/*package com.inc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.inc.connector.MybatisConnector;
import com.inc.domain.Department;
import com.inc.domain.Employee;

public class HrDao {
	private static HrDao single;

	private HrDao() {
	};

	public static HrDao getInstance() {
		if (single == null) {
			single = new HrDao();
		}
		return single;
	}
	
	public List<Employee> selectList(String name, String[] id) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("id", id);
		List<Employee> employeeList = session.selectList("employees.selectList");
		session.close();
		return employeeList;
	}

	public List<Department> selectDepartmentList() {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		List<Department> departmentList = session.selectList("departments.selectList");
		session.close();
		return departmentList;
	}

	public Employee SelectOne() {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		Employee employee = session.selectOne("employees.selectOne");
		session.close();
		return employee;
	}
	
}*/
