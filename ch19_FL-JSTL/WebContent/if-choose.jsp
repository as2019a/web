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
	<c:if test="${param.user == null}">
		<p>로그인 하세요</p>
	</c:if>
	<c:if test="${param.user != null}">
		<p>${param.user }님 안녕하세요</p>
	</c:if>
	<hr />
	<c:choose>
		<c:when test="${param.user == null }">
			<p>로그인 하세요</p>
		</c:when>
		<c:otherwise>
			<p>${param.user }님 안녕하세요</p>
		</c:otherwise>
	</c:choose>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</body>
</html>