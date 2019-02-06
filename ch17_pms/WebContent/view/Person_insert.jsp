<%@page import="com.inc.connector.DBConnector"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("id");
	int name = Integer.parseInt(
				request.getParameter("name"));
	int age = Integer.parseInt(
				request.getParameter("age"));
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
						"values(seq_score_id.nextval,'%s', %d, %d)",
											 name, age);
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		stmt.close();
		conn.close();
	}
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>입력을 완료했습니다</p>
	<a href="/views/score_list.jsp">목록으로</a>
</body>
</html>