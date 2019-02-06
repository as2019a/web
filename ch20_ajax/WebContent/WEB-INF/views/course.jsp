<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/public/css/inc.css" />
<style>
	.content{
		height: 600px;
	}
	.footer{
		line-height:200px;
		height:200px;
		color:white;
		background-color:black;
	}
</style>
</head>
<body>
	<h1>INCREPAS</h1>
	<div class="flex-container navbar">
		<div class="flex-col-1 navitem">
			<a href="/info">Info</a>
		</div>
		<div class="flex-col-1 navitem">
			<a href="/course">Course</a>
		</div>
		<div class="flex-col-1 navitem">
			<a href="">Course-ajax</a>
		</div>
		<div class="flex-col-1 navitem">
			<a href="/mypage">Mypage</a>
		</div>
	</div>
	<div class="content">
		<ul>
		<c:forEach var="course" items="${courseList }">
			<li>${course }</li>
		</c:forEach>
		</ul>
	</div>
	<div class="footer text-center">copyright</div>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</body>
</html>