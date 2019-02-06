<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@page import="com.inc.connector.DBConnector"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.inc.domain.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	List<Person> scoreList = new ArrayList<>();
	try{
		conn = DBConnector.getInstance().getConnection();
		stmt = conn.createStatement();
		while(next()){
			Person perosn = new Person();
			Person.setId(getChar("id"));
			Person.setName(getString("name"));
			Person.setage(getInt("age"));
			personList.add(Person);
		}
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
<style>
	td, th{
		border: 1px solid black;
		padding: 5px;
	}
	table{
		border-collapse: collapse;
		width: 100%;
	}
	.content{
		width: 500px;
		margin: 0 auto;
	}
	.footer{
		width: 300px;
		margin: 0 auto;
	}
	caption{
		padding:10px;
		font-size: 20px;
	}
	
</style>
</head>
<body>
	<div class="content">
		<table>
			<caption>회원정보</caption>
			<tr>
				<th>주민번호</th>
				<th>이름</th>
				<th>나이</th>
			</tr>
			<%for(Person person : personList){ %>
			<tr>
				<td><%=person.getId() %></td>
				<td><%=person.getName() %></td>
				<td><%=person.getage() %></td>
				<td>
					<button type="button" onclick="location.href='/views/Person_update_view.jsp?id=<%=Person.getId()%>'">수정</button>
					<button type="button" onclick="location.href='/views/Person_delete.jsp?id=<%=Person.getId()%>'">삭제</button>
				</td>
			</tr>
			<%} %>
		</table>
	</div>
	<div class="footer">
		<form action="/views/score_insert.jsp" method="post">
			<table>
				<caption>회원정보입력</caption>
				<tr>
					<th>주민번호</th>
					<td>
						<input type="text" name="id" />
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="name" />
					</td>
				</tr>
				<tr>
					<th>나이</th>
					<td>
						<input type="text" name="age" />
					</td>
				</tr>
				<tr>
						<button type="submit">전송</button>
						<button type="reset">취소</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
