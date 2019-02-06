<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/inc.css" />
</head>
<body>
	<h1 class="text-center">Main Page</h1>
	<%@ include file="templates/menu.jsp" %>
	<div class="flex-container">
		<div class="flex-col-2">
			<%@ include file="templates/submenu.jsp" %>
		</div>
		<div class="flex-col-10">
			<p>이곳은 메인페이지입니다</p>
		</div>
	</div>
	<%@ include file="templates/footer.jsp" %>
</body>
</html>