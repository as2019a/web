<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equals("GET")){
		

		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/signup.jsp" method="post">
		아이디<input type='text' name='id'><br>
		비밀번호<input type='password' name='password'><br>
		운동<input type='checkbox' name='hobby' value='sports'>
		영화<input type='checkbox' name='hobby' value='movie'><br>
		<button type='submit'>회원가입</button>
	</form>
	
</body>
</html>
<% }else if(request.getMethod().equals("POST")){%>
		
<%}%>