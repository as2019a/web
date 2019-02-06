<%@page import="com.inc.dao.ScoreDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.inc.domain.Score"%>
<%@page import="java.util.List"%>
<%@page import="com.inc.connector.DBConnector"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ScoreDao scoreDao = ScoreDao.getInstance();
	List<Score> scoreList = scoreDao.selectList();
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
			<caption>성적리스트</caption>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>
				<th>비고</th>
			</tr>
			<%for(Score score : scoreList){ %>
			<tr>
				<td><%=score.getId() %></td>
				<td><%=score.getName() %></td>
				<td><%=score.getKor() %></td>
				<td><%=score.getEng() %></td>
				<td><%=score.getMath() %></td>
				<td><%=score.getTotal() %></td>
				<td><%=score.getAverage() %></td>
				<td>
					<button type="button" onclick="location.href='/views/score_update_view.jsp?id=<%=score.getId()%>'">수정</button>
					<button type="button" onclick="location.href='/views/score_delete.jsp?id=<%=score.getId()%>'">삭제</button>
				</td>
			</tr>
			<%} %>
		</table>
	</div>
	<div class="footer">
		<form action="/views/score_insert.jsp" method="post">
			<table>
				<caption>성적추가</caption>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="name" />
					</td>
				</tr>
				<tr>
					<th>국어</th>
					<td>
						<input type="text" name="kor" />
					</td>
				</tr>
				<tr>
					<th>수학</th>
					<td>
						<input type="text" name="math" />
					</td>
				</tr>
				<tr>
					<th>영어</th>
					<td>
						<input type="text" name="eng" />
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
