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
	.content{
		margin: 30px;
		border: 2px dotted black;
		padding: 20px;
		height: 600px;
	}
	.input-group{
		padding: 10px 0;
	}
	.input-group > label{
		display: inline-block;
		padding-right: 20px;
		width: 100px;
		text-align:right;
	}
	.check-msg{
		color: red;
	}
</style>
</head>
<body>
	<h1>Signup</h1>
	<div class="content">
		<div class="input-group">
			<label for="id">ID</label>
			<input type="text" id="id" onkeyup="idCheck();"/>
			<!-- <button type="button" 
			        onclick="idCheck();">CHECK</button> -->
			<span id="id-check-msg" class="check-msg"></span>
		</div>
		<div class="input-group">
			<label for="password">Password</label>
			<input type="password" id="password"
			       onkeyup="pwdCheck();" />
		</div>
		<div class="input-group">
			<label for="password-check"></label>
			<input type="password" id="password-check"
				   onkeyup="pwdCheck();" />
			<span id="check-msg" class="check-msg"></span>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		function pwdCheck(){
			var password = $("#password").val();
			var password_check = 
				$("#password-check").val();
			if(password != password_check){
				$("#check-msg").text("비밀번호가 서로 불일치");
			}else{
				$("#check-msg").text("");
			}
		}
		
		function idCheck(){
			var id = $("#id").val();
			var xhr = new XMLHttpRequest();
			xhr.onload = function(){
				console.log(xhr.responseText);
				if(xhr.responseText == 'exist'){
					//alert("존재하는 아이디 입니다.");
					$("#id-check-msg").css({color:"red"});	
					$("#id-check-msg").text("존재하는 아이디");
				}else if(xhr.responseText == 'notexist'){
					//alert("사용가능한 아이디 입니다.");
					$("#id-check-msg").css({color:"blue"});		
					$("#id-check-msg").text("사용가능한 아이디");				
				}else{
					console.error(xhr.responseText);
				}
			}
			xhr.open("POST","/ajax/idcheck");
			xhr.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");
			xhr.send("id="+id);
			
		}
	</script>
</body>
</html>
