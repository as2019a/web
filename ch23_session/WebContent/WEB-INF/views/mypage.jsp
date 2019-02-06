<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/public/css/inc.css" />
</head>
<body>
	<div class="header">
		<h1>Main</h1>
	</div>
	<jsp:include page="nav.jsp"/>
	<div class="content">
		<h3>${sessionScope.user.name }님 안녕하세요</h3>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</body>
</html>