package com.inc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.inc.connector.DBConnector;
import com.inc.domain.User;

public class UserDao {

	private static UserDao single;

	private UserDao() {
	};

	public static UserDao getInstance() {
		if (single == null) {
			single = new UserDao();
		}
		return single;
	}

	public User selectOne(String id) {
		User user = new User();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select * from users where id = '" + id + "'");
			rs.next();
			user.setId(rs.getString("id"));
			user.setPassword(rs.getString("password"));
			user.setName(rs.getString("name"));
			user.setRegdate(rs.getString("regdate"));
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
}
