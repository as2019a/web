package com.inc.domain;

import java.util.List;

public class Department {
	private int department_id;
	private String department_name;
	private List<Employee> employee_list;
	private Location location;
	
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public List<Employee> getEmployee_list() {
		return employee_list;
	}
	public void setEmployee_list(List<Employee> employee_list) {
		this.employee_list = employee_list;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	
}
