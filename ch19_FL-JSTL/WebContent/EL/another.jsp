<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<%-- <li><%=msg %></ti> --%>
		<li>${requestScope.msg }</li>
		<li>${sessionScope.msg }</li>
		<li>${param.msg }</li>
		<li>${msg }</li>
	</ul>
	<a href="/EL/another">이동</a>
</body>
</html>