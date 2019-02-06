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
			<th>country_id</th>
			<th>country_name</th>
			<th>location_list</th>
		</tr>
		<c:forEach var="country" 
				   items="${countryList }">
		<tr>
			<td>${country.country_id }</td>
			<td>${country.country_name }</td>
			<td>
				<table>
					<tr>
						<th>지역번호</th>
						<th>도시명</th>
					</tr>
					<c:forEach var="location" 
							   items="${country.location_list }">
					<tr>
						<td>${location.country_id }</td>
						<td>${location.country_name }</td>
					</tr>	
					</c:forEach>
				</table>
			</td>
		</tr>			
		</c:forEach>
	</table>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</body>
</html>