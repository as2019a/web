package com.inc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inc.connector.DBConnector;
import com.inc.domain.Photo;

public class photoDao {
	 private static photoDao single;

	private photoDao() {
	};

	public static photoDao getInstance() {
		if (single == null) {
			single = new photoDao();
		}
		return single;
	}

	public List<Photo> setlectList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Photo> photoList = new ArrayList<>();
		try{
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from photo");
			while(rs.next()){
				Photo photo = new Photo();
				photo.setId(rs.getInt("id"));
				photo.setTitle(rs.getString("title"));
				photo.setFilename(rs.getString("filename"));
				photo.setPassword(rs.getString("Password"));
				photo.setRegdate(rs.getString("regdate"));
				photoList.add(photo);
			}
		}catch(SQLException e){
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
		return photoList;
	}

	public void insert(Photo photo) {
		Connection conn = null;
		Statement stmt = null;
		try{
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(
				String.format(
					"insert into photo "+
					"values(seq_photo_id.nextval, '%s', '%s', '%s', sysdate)",
						 photo.getTitle(), 
						 photo.getFilename(), 
						 photo.getPassword()));
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	public int delete(int id, String password) {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		try{
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			result = stmt.executeUpdate("delete from photo where id = " + id + " and password = '"+password+"'");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		return result;
	}
}
