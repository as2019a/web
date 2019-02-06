<%@page import="com.inc.domain.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
	Person person = new Person();
	person.setName("홍길동");
	person.setAge(29);
	person.setGender("male");
%> --%>
<jsp:useBean id="person" class="com.inc.domain.Score"/>
<jsp:setProperty property="name" name="person" value="홍길동"/>
<jsp:setProperty property="age" name="person" value="29"/>
<jsp:setProperty property="Gender" name="person" value="male"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <ul>
		<li>이름 : <%=person.getName() %></li>
		<li>나이 : <%=person.getAge() %></li>
		<li>성별 : <%=person.getGender() %></li>
	</ul> --%>
	<ul>
		<li>이름<jsp:getProperty property="name" name="person"/> </li>
		<li>나이<jsp:getProperty property="age" name="person"/> </li>
		<li>성별<jsp:getProperty property="Gender" name="person"/> </li>
	</ul>
</body>
</html>