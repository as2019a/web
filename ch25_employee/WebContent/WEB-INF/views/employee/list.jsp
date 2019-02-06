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
	<table border="1">
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>멘티들</th>
			<th>부서명</th>
			<th>부서장</th>
		</tr>
		<tr>
			<td>${employee.employee_id }</td>
			<td>${employee.first_name }</td>
			<td>
				<ul>
				<c:forEach var="mentee" items="${employee.mentee.list }">
				 	<li>${mentee.first_name }</li>
				</c:forEach>
				</ul>
			</td>
			<td>${employee.department.department_name }</td>
			<td>${employee.department.manger.first_name }</td>
		</tr>			
	</table>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</body>
</html>
