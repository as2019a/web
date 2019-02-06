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
	<form action="/insert" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>Title</th>
				<td>
					<input type="text" name="title"/>
				</td>
			</tr>
			<tr>
				<th>Password</th>
				<td>
					<input type="password" name="password"/>
				</td>
			</tr>
			<tr>
				<th>Photo</th>
				<td>
					<input type="file" name="photo"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">등록</button>
					<button type="reset">다시작성</button>
				</td>
			</tr>
		</table>
	</form>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</body>
</html>