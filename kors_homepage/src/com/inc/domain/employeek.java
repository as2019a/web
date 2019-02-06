package com.inc.domain;

/*
 create table employeek(
    id number primary key, -> int(숫자)
    name varchar2(50) not null, -> String(문자)
    age number, -> int(숫자)
    email VARCHAR2(25) NOT NULL, -> String(문자)
    photo_number VARCHAR2(20), -> String(문자) 
    hide_date DATE NOT NULL, -> int(숫자)
    jobs varchar2(80), -> String(문자)
    rank varchar2(50), -> String(문자)
    Work_place varchar(50), -> String(문자)
    salary number(8,2), -> int(숫자)
    department_id number(4), -> int(숫자)
    department_name VARCHAR(80), -> String(문자)
    location_id NUMBER(4), -> int(숫자)
    regdate date not null -> int(숫자)
); 
*/
/*
 * number, date -> int(숫자)
 * varchar2, clob -> String(문자)
 */
public class employeek {
	private int id, age, hide_date, salary, department_id, location_id, regdate;
	private String name, email, photo_number, jobs, rank, Work_place, department_name, gender;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHide_date() {
		return hide_date;
	}
	public void setHide_date(int hide_date) {
		this.hide_date = hide_date;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public int getRegdate() {
		return regdate;
	}
	public void setRegdate(int regdate) {
		this.regdate = regdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoto_number() {
		return photo_number;
	}
	public void setPhoto_number(String photo_number) {
		this.photo_number = photo_number;
	}
	public String getJobs() {
		return jobs;
	}
	public void setJobs(String jobs) {
		this.jobs = jobs;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getWork_place() {
		return Work_place;
	}
	public void setWork_place(String work_place) {
		Work_place = work_place;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
