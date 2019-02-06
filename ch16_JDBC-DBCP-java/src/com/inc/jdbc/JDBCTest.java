package com.inc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		
		//드라이버 클래스 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "1111";
		Connection conn = null; //데이터베이스 연결객체
		Statement stmt = null; //구문(SQL)을 전달할 객체
		ResultSet rs = null; //결과(튜플 들)을 받아올 객체
		try {
			conn = DriverManager.getConnection
					(url, username, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from employees");
			while(rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				int salary = rs.getInt("salary");
				System.out.printf("%d\t\t%s\t\t%d\n",
						employee_id, first_name, salary);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
