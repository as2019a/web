package com.inc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.inc.connector.MybatisConnector;
import com.inc.domain.Board;

public class BoardDao {
	private static BoardDao single;
	private Object users_id;

	private BoardDao() {
	};

	public static BoardDao getInstance() {
		if (single == null) {
			single = new BoardDao();
		}
		return single;
	}

	public List<Board> selectboardList(Map<String, Integer> map) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		List<Board> boardList = session.selectList("board.boardList", map);
		session.close();
		return boardList;
	}

	public int getTotalCount() {
		//전체 게시물의 갯수 반환
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		int total = session.selectOne("board.totalCount"); //("Map.id",)
		session.close();
		return total;
	}

	public void insert(Board board) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		session.insert("board.insert", board);
		session.commit();
		session.close();
		
	}
	

	public Board selectOne(int id) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		Board board = session.selectOne("board.selectOne",id);
		session.close();
		return board;
	}

	public void hitUp(int id) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		session.update("board.hitUp", id);
		session.commit();
		session.close();
		
	}

	/*public int delete(int id, String users_id) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		session.delete("board.delete", id);
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("users_id", users_id);
		
		int result = session.delete("board.delete", map);
		session.commit();
		session.close();
		return result;
	}*/

	/*public void update(int id, int count) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		
		Map<String, Integer> map = new HashMap<>();
		map.put("id", id);
		map.put("count", count);
		session.update("board.update", map);
		session.commit();
		session.close();
		
	}*/

	public void delete(int id) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		session.delete("board.delete", id);
		session.commit();
		session.close();
		
	}

	public void update(Board board) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		session.update("board.update", board);
		session.commit();
		session.close();
		
	}
	
	
}
