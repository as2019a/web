<%@page import="com.inc.dao.ScoreDao"%>
<%@page import="com.inc.connector.DBConnector"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int id = Integer.parseInt(request.getParameter("id"));	

	ScoreDao scoreDao = ScoreDao.getInstance();
	scoreDao.delete(id);
	
	response.sendRedirect("/views/score_list.jsp");
%>    
