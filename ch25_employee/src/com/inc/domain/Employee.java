package com.inc.domain;

import java.util.List;

public class Employee {
	private int employee_id;
	private String first_name;
	private List<Employee> mentee_list;
	private Department department;
	
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public List<Employee> getMentee_list() {
		return mentee_list;
	}
	public void setMentee_list(List<Employee> mentee_list) {
		this.mentee_list = mentee_list;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
