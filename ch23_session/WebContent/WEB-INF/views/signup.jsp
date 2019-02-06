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
	<jsp:include page="nav.jsp"/>
	<div class="content">
		<form action="/signup" method="post">
			<div class="input-group">
				<label for="id">ID</label>
				<input type="text" id="id" name="id"/>
				<button type="button" 
				        onclick="dualcheck()" style="madin-top=5px;">중복확인</button>
			</div>
			<div class="input-group">
				<label for="password">Password</label>
				<input type="password" id="password"
					   name="password" />
			</div>
			<div class="input-group">
				<label for="name">Name</label>
				<input type="text" id="name" name="name"/>
			</div>
			<div class="input-group">
				<button type="button" onclick="check();">SIGN UP</button>
			</div>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
	var isExist = true;
	function check(){
		if($("#id").val() == ""){
			alert("아이디를 입력해 주세요");
			$("#id").focus();
			return;
		}
		if(isExist){
			alert("중복된 아이디 입니다");
			$("#id").focus();
			return;
		}
		if($("#password").val() == ""){
			alert("비밀번호를 입력해 주세요");
			$("#password").focus();
			return;
		}
		if($("#name").val() == ""){
			alert("이름을 입력해 주세요");
			$("#name").focus();
			return;
		}
		
		$("#form").submit();
	}

	function dualcheck(){
		$.ajax({
			url:"/dualcheck",
			type:"post",
			data:{id:$("#id").val()},
			success:function(data){
				if(data == "exist"){
					alert("아이디가 중복됩니다");
				}else{
					alert("사용가능한 아이디입니다");
					isExist = false;
				}
			}
		});
	}
	</script>
</body>
</html>