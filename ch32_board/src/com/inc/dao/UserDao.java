package com.inc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.session.SqlSession;

import com.inc.connector.MybatisConnector;
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
	
	public User selectOne(User checkUser) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		User user = session.selectOne("user.selectOne", checkUser); //user, selectOne
		session.close();
		return user;
	}
	
}
