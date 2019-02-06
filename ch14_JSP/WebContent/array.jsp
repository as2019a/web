<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] cityArray = {"서울", "대전", "대구", "부산"};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<%for(int i=0; i < cityArray.length; i++){ %>
		<li><%=cityArray[i] %></li>
		<%} %>
	</ul>
	<hr />
	<!-- foreach -->
	<ul>
		<%for(String city : cityArray){ %>
		<li><%=city %></li>
		<%} %>
	</ul>
	<hr />
	<!-- 5단 -->
	<table>
		<%for(int i=1; i < 10; i++){ %>
		<tr>
			<td>5</td><td>X</td><td><%=i %></td><td>=</td><td><%=i*5 %></td>
		</tr>
		<%} %>
	</table>
	<hr />
	<table>
		<%for(int i=1; i < 10; i++){ %>
		<tr>
			<td>9</td><td>X</td><td><%=i %></td><td>=</td><td><%=i*9 %></td>
		</tr>
		<%} %>
	</table>
	<hr />
	<table>
		<%for(int i=1; i < 20; i++){ %>
		<tr>
			<td>10</td><td>X</td><td><%=i %></td><td>=</td><td><%=i*10 %></td>
		</tr>
		<%} %>
	</table>
	<hr />
	<table>
		<%for(int i=1; i < 30; i++){ %>
		<tr>
			<td>10</td><td>+</td><td><%=i %></td><td>=</td><td><%=i+10 %></td>
		</tr>
		<%} %>
	</table>
	<hr />
	<table>
		<%for(int i=1; i < 50; i++){ %>
		<tr>
			<td>10</td><td>*</td><td><%=i %></td><td>=</td><td><%=i*10 %></td>
		</tr>
		<%} %>
	</table>
	<hr />
</body>
</html>