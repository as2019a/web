<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><fmt:formatNumber value="123456789" type="number"/></p>
	<p><fmt:formatNumber value="123456789" type="currency" currencySymbol="$"/></p>
	<p><fmt:formatNumber value="0.3" type="percent"/></p>
	<p><fmt:formatNumber value="987654321.1234" pattern="#,####.##"/></p>
	<p>
		<fmt:parseDate value="181102" pattern="yyMMdd" var="newDate"/>
		<fmt:formatDate value="${newDate }" pattern="yy-MM-dd"/>
	</p>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</body>
</html>