<%@page import="com.inc.connector.DBConnector"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	//드라이버 클래스 로딩
	
	Connection conn = DBConnector.getConnection();
	Statement stmt = null;
	ResultSet rs = null;
	
	try{
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from departments");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>부서번호</th>
			<th>부서명</th>
			<th>매니저번호</th>
		</tr>
		<%while(rs.next()){ %>
		<tr>
			<td><%=rs.getInt(1) %></td>
			<td><%=rs.getString(2) %></td>
			<td><%=rs.getInt(3) %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>
<%
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		rs.close();
		stmt.close();
		conn.close();
	}
%>
