<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" 
 	  content="width=device-width, initial-scale=1">
<title></title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
<style>
	p{
		color: blue;
	}
	
	ul.one{
	 	color: #ff793f;
	}
	
	ul.two{
		color: #05c46b;
	}
	
	ul.three{
		color: #0fbcf9;
	}
	
	ul.four{
		color: orange;
	}
	
	ul.five{
		color: lime;
	}
	
	ul.six{
		background-color: green;
		color: silver;
	}
	
</style>
</head>
<body>
	${requestScope.nameList } <br />
	${param.id}
	<!-- empty : null이거나 null이 아닐경우 size(length)가 0일 경우 -->
	<%-- <c:if test="${empty nameList}">
	<p>이름의 목록이 비어있습니다.</p>
	</c:if> --%>
	<c:if test="${nameList == null || fn:length(nameList) == 0}">
	<p>이름의 목록이 비어있습니다.</p>
	</c:if>
	<ul class="one">
		<li>${nameList[0] }</li>
		<li>${nameList[1] }</li>
		<li>${nameList[2] }</li>
	</ul>
	<ul class="two">
		<c:forEach var="i" begin="0" end="${fn:length(nameList) - 1 }">
			<li>${nameList[i] }</li>
		</c:forEach>
	</ul>
	<ul class="three">
		<c:forEach var="name" items="${nameList }">
			<li>${name }</li>
		</c:forEach>
	</ul>
	<ul class="four">
		<c:forEach var="name" items="${nameList }">
			<c:if test="${name == 'harry' }">
				<li>${name }</li>
			</c:if>
		</c:forEach>
	</ul>
	<ul class="five">
		<c:forEach var="name" items="${nameList}">
			<c:if test="${name != 'harry' }">
				<li>${name }</li>
			</c:if>
		</c:forEach>
	</ul>
	<ul class="six">
		<c:forEach var="name" items="${nameList }">
			<c:if test="${name != 'park' }">
				<li>${name }</li>
			</c:if>
		</c:forEach>
	</ul>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>