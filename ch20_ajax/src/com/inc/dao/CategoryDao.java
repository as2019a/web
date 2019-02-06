package com.inc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inc.connector.DBConnector;

public class CategoryDao {
	private static CategoryDao single;

	private CategoryDao() {
	};

	public static CategoryDao getInstance() {
		if (single == null) {
			single = new CategoryDao();
		}
		return single;
	}

	public List<String> selectList() {
		List<String> categoryList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from category");
			while(rs.next()) {
				categoryList.add(rs.getString("name"));
			}
		}catch(SQLException e) {
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
		return categoryList;
	}

	public List<String> selectSubList(String category) {
		List<String> subList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select * from subcategory where category_name = '" + category + "'");
			while(rs.next()) {
				subList.add(rs.getString("name"));
			}
		}catch(SQLException e) {
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
		return subList;
	}
}