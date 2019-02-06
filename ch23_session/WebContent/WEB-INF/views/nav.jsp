<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div class="flex-container navbar">
	<div class="navitem flex-col-2">
		<a href="/">Main</a>
	</div>
	<c:if test="${user == null }">
	<div class="navitem flex-col-2">
		<a href="/signin">Sign In</a>
	</div>
	</c:if>
	<c:if test="${user != null }">
	<div class="navitem flex-col-2">
		<a href="/signout">Sign Out</a>
	</div>
	<div class="navitem flex-col-2">
		<a href="/mypage">MyPage</a>
	</div>
	</c:if>
	<c:if test="${user == null }">
	<div style="flex-grow: 1"></div>
	<div class="navitem flex-col-2">
		<a href="/signup">Sign Up</a>
	</div>
	</c:if>
</div>