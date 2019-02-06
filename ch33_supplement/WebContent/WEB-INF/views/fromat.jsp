<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" 
 	  content="width=device-width, initial-scale=1">
<title></title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
</head>
<body>
	<p>
		<fmt:formatNumber value="${number }" type="number"/> 
	</p>
	<p>
		<fmt:formatNumber value="${number }" type="currency" currencySymbol="$"/> 
	</p>
	<p>
		<fmt:formatNumber value="0.3" type="percent" currencySymbol="$"/> 
	</p>
	<p>
		<fmt:formatNumber value="${number }" type="currency" currencySymbol="$"/> 
	</p>
	<p>
		<fmt:formatNumber value="${number }" 
						  pattern="+#,####.##"/>						  
	</p>
	<hr />
	<fmt:parseDate value="${date }" 
				   pattern="yy/MM/dd HH:mm:ss"
				   var="parsedDate"/>
	<fmt:formatDate value="${parsedDate }"
					pattern="yyyy-MM-dd hh;mm;ss"/>		
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>