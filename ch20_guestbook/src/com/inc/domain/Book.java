package com.inc.domain;

public class Book {
	
	public Book() {}
	
	public Book(int id, String password, 
			    String writer, String ip, 
			    String msg, String writedate) {
		this.id = id;
		this.password = password;
		this.writer = writer;
		this.ip = ip;
		this.msg = msg;
		this.writedate = writedate;
	}



	private int id;
	private String password;
	private String writer;
	private String ip;
	private String msg;
	private String writedate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
}
