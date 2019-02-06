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
	<ul>
		<%for(int i = 1; i < 10; i++){ %>		
		<li>5 X <%=i %> = <%=5*i %></li>
		<%} %>
	</ul>
	<hr />
	<ul>
		<c:forEach var="i" begin="1" end="9">
			<li>5 X ${i} = ${i*5}</li>
		</c:forEach>
	</ul>
</body>
</html>