<%@page import="com.inc.dao.ScoreDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.inc.domain.Score"%>
<%@page import="com.inc.connector.DBConnector"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	
	ScoreDao scoreDao = ScoreDao.getInstance();
	Score score = scoreDao.selectOne(id);
	
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
	<div class="footer">
		<form action="/views/score_update.jsp" method="post">
			<input type="hidden" value="<%=score.getId() %>" name="id" />
			<table>
				<caption>성적수정</caption>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="name" 
						 value="<%=score.getName() %>" />
					</td>
				</tr>
				<tr>
					<th>국어</th>
					<td>
						<input type="text" name="kor" 
						value="<%=score.getKor() %>"/>
					</td>
				</tr>
				<tr>
					<th>수학</th>
					<td>
						<input type="text" name="math" 
						value="<%=score.getMath() %>"/>
					</td>
				</tr>
				<tr>
					<th>영어</th>
					<td>
						<input type="text" name="eng" 
						value="<%=score.getEng() %>"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">전송</button>
						<button type="reset">취소</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>