<%@page import="com.inc.domain.Score"%>
<%@page import="com.inc.dao.ScoreDao"%>
<%@page import="com.inc.connector.DBConnector"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	int kor = Integer.parseInt(
				request.getParameter("kor"));
	int eng = Integer.parseInt(
				request.getParameter("eng"));
	int math = Integer.parseInt(
				request.getParameter("math"));
	ScoreDao scoreDao = ScoreDao.getInstance();
	Score score = new Score();
	score.setName(name);
	score.setKor(kor);
	score.setEng(eng);
	score.setMath(math);
	scoreDao.insert(score);

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