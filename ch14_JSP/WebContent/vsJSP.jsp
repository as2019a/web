<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VS JSP</title>
</head>
<body>
	<h1><%out.print(request.getParameter("msg")); %></h1>
	<table border="1">
		<tr>
			<td>Servlet</td>
			<td>VS</td>
			<td>JSP</td>
		</tr>
	</table>
</body>
</html>