package com.inc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inc.connector.DBConnector;
import com.inc.domain.Score;

public class ScoreDao {
	//2.static single객체선언
	private static ScoreDao single;
		
	//1.생성자 private
	private ScoreDao() {}
		
	//3.외부에서 객체생성없이 접근가능한 메서드
	public static ScoreDao getInstance() {
		if(single == null) single = new ScoreDao();
		return single;
	}
	//
	
	public List<Score> selectList(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Score> scoreList = new ArrayList<>();
		try{
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select * from score_view");
			while(rs.next()){
				Score score = new Score();
				score.setId(rs.getInt("id"));
				score.setName(rs.getString("name"));
				score.setKor(rs.getInt("kor"));
				score.setEng(rs.getInt("eng"));
				score.setMath(rs.getInt("math"));
				score.setTotal(rs.getInt("total"));
				score.setAverage(rs.getInt("average"));
				scoreList.add(score);
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
		return scoreList;
	}

	public void insert(Score score) {
		Connection conn = null;
		Statement stmt = null;
		try{
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			//select - executeQuery : ResultSet을 리턴
			//insert, update, delete - executeUpdate : 숫자 리턴
			stmt.executeUpdate(
				String.format(
					"insert into score "+
					"values(seq_score_id.nextval,'%s', %d, %d, %d)",
						 score.getName(), 
						 score.getKor(), 
						 score.getEng(), 
						 score.getMath()));
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
	}
	
	public void delete(int id) {
		Connection conn = null;
		Statement stmt = null;
		try{
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			//select - executeQuery : ResultSet을 리턴
			//insert, update, delete - executeUpdate : 숫자 리턴
			stmt.executeUpdate("delete from score where id = " + id);
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
	}
	
	public Score selectOne(int id) {
		Score score = new Score();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from score where id = " + id);
		 	rs.next();
		 	score.setId(rs.getInt("Id"));
		 	score.setName(rs.getString("name"));
		 	score.setKor(rs.getInt("kor"));
		 	score.setEng(rs.getInt("eng"));
		 	score.setMath(rs.getInt("math"));
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
		return score;
	}
	
	public void update(Score score) {
		Connection conn = null;
		Statement stmt = null;
		try{
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(
					String.format(
							"update score set name = '%s', kor = %d, "+
							"eng = %d, math = %d where id = %d", 
							score.getName(), 
							score.getKor(), 
							score.getEng(), 
							score.getMath(), 
							score.getId()));
			
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
	}
}
