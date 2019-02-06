<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>${fn:substring("010-6401-5113",4,8) }</p>
	<c:forEach var="str" items='${fn:split("010-6401-5113","-") }'>
	<li>${str }</li>
	</c:forEach>
	<p>${fn:length("abc") }</p>
	<p>${fn:toLowerCase("Apple") }</p>
	<p>${fn:toUpperCase("Apple") }</p>
	<p></p>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</body>
</html>