<%@page import="com.inc.connector.DBConnector"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int id = Integer.parseInt(request.getParameter("id"));	

	Connection conn = null;
	Statement stmt = null;
	try{
		conn = DBConnector.getInstance().getConnection();
		stmt = conn.createStatement();
		//select - executeQuery : ResultSet을 리턴
		//insert, update, delete - executeUpdate : 숫자 리턴
		stmt.executeUpdate("delete from person where id = " + id);
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		stmt.close();
		conn.close();
	}
	response.sendRedirect("/view/person_list.jsp");
%>    