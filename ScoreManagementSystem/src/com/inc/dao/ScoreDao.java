package com.inc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.inc.connector.MybatisConnector;
import com.inc.domain.Score;

public class ScoreDao {
	private static ScoreDao single;

	private ScoreDao() {
	};

	public static ScoreDao getInstance() {
		if (single == null) {
			single = new ScoreDao();
		}
		return single;
	}

	public List<Score> selectList() {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		List<Score> scoreList = 
		session.selectList("score.selectList");
		session.close();
		return scoreList;
	} // total, average

	public void delete(int id) {
		//변수종류인 SqlSession에서 session을 변수이름으로 선언하고 그것을
		//마이바티스에서 getInstance를 통과한뒤에 getSqlSession함수를 호출한다.
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		//session에서 id = delete(삭제)("맵퍼(score).id(delete), id(int id)")
		//맵퍼경로를 따라간다.
		session.delete("score.delete", id);
		session.commit();
		session.close();
		
	}

	public Score selectOne(int id) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		Score score = session.selectOne("score.selectOne", id);
		session.commit();
		session.close();
		return score;
	}

	public void update(Score score) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		session.update("score.update", score);
		session.commit();
		session.close();
	}

	public void insert(Score score) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		session.insert("score.insert", score);
		session.commit();
		session.close();
		
	}
}
