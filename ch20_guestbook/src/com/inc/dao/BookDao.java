package com.inc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inc.connector.DBConnector;
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
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Book> bookList = new ArrayList<Book>();
		
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from guestbook order by writedate desc");
			while(rs.next()) {
				Book book = 
					new Book(rs.getInt(1), 
							 rs.getString(2),
							 rs.getString(3),
							 rs.getString(4),
							 rs.getString(5),
							 rs.getString(6));
				bookList.add(book);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return bookList;
	}
	public List<Book> selectList(String type, String word) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Book> bookList = new ArrayList<Book>();
		
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.createStatement();                  
			rs = stmt.executeQuery("select * from guestbook where "+type+" like '%"+word+"%' order by writedate desc");
			while(rs.next()) {
				Book book = 
					new Book(rs.getInt(1), 
							 rs.getString(2),
							 rs.getString(3),
							 rs.getString(4),
							 rs.getString(5),
							 rs.getString(6));
				bookList.add(book);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return bookList;
	}

	public void insert(Book book) {
		Connection conn = null;
		Statement stmt = null;
		String sql = String.format(
"insert into guestbook values(seq_guestbook_id.nextval, '%s', '%s', '%s', '%s', systimestamp)", 
					book.getPassword(),
					book.getWriter(),
					book.getIp(),
					book.getMsg());
		try {
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
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
			stmt.executeUpdate("delete from guestbook where id = " + id);
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

	public Book selectOne(int id) {
		Book book = new Book(); 
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"select * from guestbook where id = " + id);
			rs.next();
			book.setId(rs.getInt("id"));
			book.setPassword(rs.getString("password"));
			book.setMsg(rs.getString("msg"));
			book.setWriter(rs.getString("writer"));
			
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
		return book;
	}

	public void update(Book book) {
		Connection conn = null;
		Statement stmt = null;
		try{
			conn = DBConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(
				String.format(
	"update guestbook set writer = '%s', msg = '%s', "+
	"ip = '%s', writedate = systimestamp where id = %d",
					 book.getWriter(), 
					 book.getMsg(), 
					 book.getIp(), 
					 book.getId()));
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






