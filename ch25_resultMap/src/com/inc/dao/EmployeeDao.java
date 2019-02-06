package com.inc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public List<Employee> selectList(String name, String[] idList){
		SqlSession session = 
			MybatisConnector.getInstance().getSqlSession();
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("idList", idList);
		List<Employee> employeeList = session.selectList("employees.selectList");
		session.close();
		return employeeList;
	}
}
