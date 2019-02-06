<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String msg = name + "님 안녕하세요?";
	request.setAttribute("msg", msg);
%>
<jsp:forward page="ex05_actiontag-forward2.jsp"/>