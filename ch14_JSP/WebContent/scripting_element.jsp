<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- HTML주석 -->
<%-- JSP주석 --%>
<%!
	//declaration -- 서블릿의 필드 영역
	private String sayHello = "안녕하세요?";
	
	private int sum(int a, int b){
		return a+b;
	}
	
	Scanner scanner = new Scanner(System.in);
	
%>
<% 
	//scriptlet --service()메서드의 영역
	String msg = request.getParameter("msg");
	response.getWriter().write("메세지:"+msg+"\n");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <h1><%out.write(msg+"-"+sum(1,2)); %></h1> --%>
	<h1><%=msg+"-"+sum(1,2) %></h1>
</body>
</html>