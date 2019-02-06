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
			<th>employee_id</th>
			<th>first_name</th>
			<th>salary</th>
			<th>department_id</th>
			<th>department_name</th>
		</tr>
		<c:forEach var="employee" 
				   items="#{employeeList }">
		<tr>
			<td>${employee.employeeId }</td>
			<td>${employee.firstName }</td>
			<td>${employee.salary }</td>
			<td>${employee.department.department_id }</td>
			<td>${employee.department.department_name }</td>
		</tr>			
		</c:forEach>
	</table>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</body>
</html>
