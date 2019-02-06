<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>제목 : ${title }</p>
	<img src="/upload/${filename }" alt="이미지" />
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</body>
</html>