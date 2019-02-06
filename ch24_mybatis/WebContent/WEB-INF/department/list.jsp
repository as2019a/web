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
	<table>
		<tr>
			<th>department_id</th>
			<th>first_name</th>
		</tr>
		<c:forEach var="department" 
				   items="#{departmentList }">
		<tr>
			<td>${department.department_id }</td>
			<td>${department.first_name }</td>
		</tr>			
		</c:forEach>
	</table>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</body>
</html>