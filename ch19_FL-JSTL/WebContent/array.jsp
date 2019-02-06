<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String[] cityArray = {"서울","대전","대구","부산"};
	request.setAttribute("cityArray", cityArray);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<% for(String city : cityArray){ %>
		<li><%=city %></li>
		<%} %>
	</ul>
	<hr />
	<ul>
	<c:forEach var="city" items="${cityArray }">
		<li>${city }</li>
	</c:forEach>
	</ul>
</body>
</html>