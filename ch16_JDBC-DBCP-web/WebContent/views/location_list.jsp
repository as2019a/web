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
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try{
		conn = DBConnector.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from locations");
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		
	}
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
			<th>지역번호</th>
			<th>도시명</th>
			<th>거리주소</th>
		</tr>
		<%while(rs.next()){ %>
		<tr>
			<td><%=rs.getInt("location_id") %></td>
			<td><%=rs.getString("city") %></td>
			<td><%=rs.getString("street_address") %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>