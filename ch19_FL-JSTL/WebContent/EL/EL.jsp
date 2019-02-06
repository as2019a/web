<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = "지역변수";
	request.setAttribute("msg", "request attr");
	session.setAttribute("msg", "session attr");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li><%=msg %></li>
		<li>${requestScope.msg }</li>
		<li>${sessionScope.msg }</li>
		<li>${param.msg }</li>
		<li>${msg }</li>
	</ul>
</body>
</html>