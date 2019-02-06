<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/public/css/inc.css" />
<style>
	body{
		width: 500px;
		margin: 0 auto;
	}
	
	.content{
		margin: 30px;
		border: 3px solid black;
		padding: 20px;
	}
	
	.input-group{
		padding: 10px 0;
	}
	
	.input-group label{
		display: inline-block;
		margin-right: 20px;
		width: 100px;
		text-align: right;
	}
	
	.input-group button{
		border: none;
		border-radius:3px;
		background-color: gray;
		padding: 10px;
		color:white;
		display: inline-block;
		width: 100%;
	}
	
	.input-group button:hover{
		background-color: silver;
	}
	
	.input-group input[type="text"],
	.input-group input[type="password"]{
		width:230px;
		padding: 5px;
		border-radius: 3px;
		border : 1px solid silver;
		outline: none;
	}
	
	.input-group input[type="text"]:focus,
	.input-group input[type="password"]:focus{
		outline: 1px solid #48dbfb;
	}

</style>
</head>
<body>
	<h1 class="text-center">Sign In</h1>
	<div class="content">
		<form action="/signin" method="post">
			<div class="input-group">
				<label for="id">ID</label>
				<input type="text" id="id" name="id" />
			</div>
			<div class="input-group">
				<label for="password">Password</label>
				<input type="password" id="password" 
					   name="password" />
			</div>
			<div class="input-group">
				<label for=""></label>
				<input type="checkbox" id="save-id" 
					   name="save-id" />Save ID
				<input type="checkbox" id="save-password" 
					   name="save-password"/>Save Password
			</div>
			<div class="input-group">
				<button type="submit">SIGN IN</button>
			</div>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		//console.log("쿠키",document.cookie);
		var cookieList = document.cookie.split("; ");
		console.log(cookieList);
		var cookies = {}; 
		for(var cookie of cookieList){
			var key = cookie.split("=")[0];
			var value = cookie.split("=")[1];
			cookies[key] = value;
		}
		console.log(cookies);
		if(cookies.id){
			document.querySelector("#id").value =
										cookies.id;
			document.querySelector("#save-id").checked
										= "checked";
		}
		
		if(cookies.password){
			document.querySelector("#password").value =  
										cookies.password;
			document.querySelector("#save-password").checked
			= "checked";
		}
		
		
	</script>
</body>
</html>