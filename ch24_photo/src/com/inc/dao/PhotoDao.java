package com.inc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.inc.connector.DBConnector;
import com.inc.connector.MybatisConnector;
import com.inc.domain.Photo;

public class PhotoDao {
	private static PhotoDao single;

	private PhotoDao() {
	};

	public static PhotoDao getInstance() {
		if (single == null) {
			single = new PhotoDao();
		}
		return single;
	}

	public List<Photo> selectList() {
		SqlSession session = MybatisConnector
								.getInstance()
								.getSqlSession();
		
		List<Photo> photoList = 
				session.selectList("photo.selectList");
		
		session.close();
		
		return photoList;
	}

	public void insert(Photo photo) {
		SqlSession session = 
				MybatisConnector.getInstance()
								.getSqlSession();
		session.insert("photo.insert", photo);
		session.commit();
		session.close();
	}

	public int delete(int id, String password) {
		int result = 0;
		
		SqlSession session = 
				MybatisConnector.getInstance()
								.getSqlSession();
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("password", password);
		result = session.delete("photo.delete", map);
		session.commit();
		session.close();
				
		return result;
	}
}