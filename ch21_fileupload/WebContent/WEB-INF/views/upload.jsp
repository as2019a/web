<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1{text-align: center;}
	.content{
		width:400px; 
		margin:0 auto;
		border: 2px dotted gray;
		padding: 10px 0;
	}
	th{
		text-align: right;
		padding-right: 10px;
	}
</style>
</head>
<body>
	<h1>File Upload</h1>
	<div class="content">
		<form action="/upload" enctype="multipart/form-data" method="post">
			<table>
				<tr>
					<th width="30%">title</th>
					<td>
						<input type="text" name="title" />
					</td>
				</tr>
				<tr>
					<th>file</th>
					<td>
						<input type="file" name="photo" />
					</td>
				</tr>
				<tr>
					<th></th>
					<td>
						<button type="submit">업로드</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</body>
</html>