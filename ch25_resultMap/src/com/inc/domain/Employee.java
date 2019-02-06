package com.inc.domain;

import java.util.List;

public class Employee {
	private int employeeId;
	private String firstName;
	private int salary;
	private List<Employee> employee_list;
	
	private Department department;
	//Mybatis - ORM프레임워크
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<Employee> getEmployee_list() {
		return employee_list;
	}
	public void setEmployee_list(List<Employee> employee_list) {
		this.employee_list = employee_list;
	}
	
}
