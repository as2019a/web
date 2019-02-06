package com.inc.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "hr";
	private static final String PASSWORD = "1111";
	
	//static initialization(스태틱 초기화)
	//클래스가 처음 로딩될 때 딱 한번만 수행되는 코드
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
			Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
 }
