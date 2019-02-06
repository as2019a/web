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
	
	.block-btn{
		background-color: #e74c3c;
		border-radius:5px;
		color:white;
		width: 50%;
		padding: 15px 0;
		margin: 0 auto;
		cursor: pointer;
		font-weight: 600;
		font-size: 20px;
	}
	
	.block-btn:hover{
		background-color: silver;
	}
	
	.header{
		padding-bottom: 20px;
	}
	.photo{
		border: 1px solid gray;
		padding: 5px;
		margin-bottom: 30px;
	}
	
	.photo img{
		width: 100%;
		border-radius: 20px;
	}
	.photo-title, .photo-footer{
		padding: 5px;
	}
	.inline-btn{
		display: inline-block;
		background-color: #e58e26;
		border-radius:5px;
		color:white;
		width: 50%;
		padding: 7px 0;
		cursor: pointer;
		font-weight: 300;
		font-size:16px;
		text-align: center;
		border: 3px solid white;
	}
	.inline-btn:hover {
		background-color: silver;
	}
	.photo-footer{
		font-size: 0px;
	}
</style>
</head>
<body>
	<div class="header">
		<h1 class="text-center">Photo Gallery</h1>
		<div class="text-center">
			<div class="block-btn" 
			     onclick="location.href='/insert'">ADD</div>
		</div>
	</div>
	<div class="content">
		<div class="flex-container">
			<c:forEach var="photo" items="${photoList }">
			<div class="flex-col-6 flex-col-md-4">
				<div class="photo">
					<div class="photo-content">
						<img src="/upload/${photo.filename }" alt="" />
					</div>
					<div class="photo-title">
						${photo.title } | ${photo.regdate }
					</div>
					<div class="photo-footer">
						<div class="inline-btn" onclick="download('${photo.filename }')">Download</div>
						<div class="inline-btn" onclick="del(${photo.id});">Delete</div>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		function del(id){
			var userPassword; 
			while(!(userPassword = prompt("비밀번호를 입력해주세요"))){};
			$.ajax({
				url:"/photo/delete",
				type:"post",
				data:{id:id, password:userPassword},
				success:function(data){
					alert(data);
					location.href="";
				}
			});
		}
		function download(filename){
			location.href="/download?filename="+filename;
		}
	</script>
</body>
</html>