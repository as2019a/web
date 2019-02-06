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
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	int kor = Integer.parseInt(
				request.getParameter("kor"));
	int eng = Integer.parseInt(
				request.getParameter("eng"));
	int math = Integer.parseInt(
				request.getParameter("math"));
	Score score = new Score();
	score.setId(id);
	score.setName(name);
	score.setKor(kor);
	score.setEng(eng);
	score.setMath(math);
	
	
	ScoreDao scoreDao = ScoreDao.getInstance();
	scoreDao.update(score);
	response.sendRedirect("/views/score_list.jsp");
%>   