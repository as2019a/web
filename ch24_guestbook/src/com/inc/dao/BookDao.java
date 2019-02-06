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
import com.inc.domain.Book;

public class BookDao {
	private static BookDao single;
	
	private BookDao() {}
	
	public static BookDao getInstance() {
		if(single == null) {
			single = new BookDao();
		}
		return single;
	}

	public List<Book> selectList() {
		
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		List<Book> bookList =
		session.selectList("book.selectList");
		session.close();
		return bookList;
	}
	
	public List<Book> selectList(String type, String word) {
		
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		Map<String, String> conditionMap = new HashMap<>();
		conditionMap.put("type", type);
		conditionMap.put("word", word);
		List<Book> bookList = session.selectList("book.selectListCondition", conditionMap);
		session.close();
		return bookList;
	}

	public void insert(Book book) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		session.insert("book.insert", book);
		session.commit();
		session.close();
	}

	public void delete(int id) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		session.delete("book.delete", id);
		session.commit();
		session.close();
	}

	public Book selectOne(int id) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		Book book = session.selectOne("book.selectOne", id);
		session.commit();
		session.close();
		return book;
	}

	public void update(Book book) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		session.update("book.update", book);
		session.commit();
		session.close();
	}
}