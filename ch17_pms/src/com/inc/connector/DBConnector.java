package com.inc.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBConnector {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "webprog";
	private static final String PASSWORD = "1111";
	private static DBConnector single;
	private BasicDataSource dataSource;
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private DBConnector() {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		
		//시작 시 보유할 커넥션 수
		dataSource.setInitialSize(5);
		//보유 가능한 최대 커넥션 수
		dataSource.setMaxTotal(5);
		//놀고 있을 수 있는 최대 커넥션 수
		dataSource.setMaxIdle(5);
		//놀고 있을 수 있는 최소 커넥션 수
		dataSource.setMinIdle(0);
		//커넥션 고갈 시 최대 대기시간(대기시간 초과시 예외 발생)
		dataSource.setMaxWaitMillis(3000);
		//커넥션이 너무 오래 쉬면 데이터베이스에서 커넥션을 종료
		//웹서버에서는 DBCP에 의해 종료된 커넥션 소유
		//해당 커넥션이 죽은 커넥션인지 확인하는 쿼리
		dataSource.setValidationQuery("select 1 from dual");
	}
	
	public static DBConnector getInstance() {
		if(single == null) {
			single = new DBConnector();
		}
		return single;
	}
	
	public Connection getConnection(){
			Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
 }
