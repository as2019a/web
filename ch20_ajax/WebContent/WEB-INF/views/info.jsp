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
		height: 600px;
	}
	.footer{
		line-height:200px;
		height:200px;
		color:white;
		background-color:black;
	}
</style>
</head>
<body>
	<h1>INCREPAS</h1>
	<div class="flex-container navbar">
		<div class="flex-col-1 navitem">
			<a href="/info">Info</a>
		</div>
		<div class="flex-col-1 navitem">
			<a href="/course">Course</a>
		</div>
		<div class="flex-col-1 navitem">
			<a href="javascript:course();">Course-ajax</a>
		</div>
		<div class="flex-col-1 navitem">
			<a href="/mypage">Mypage</a>
		</div>
	</div>
	<div class="content">
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quasi distinctio voluptates sint sapiente reiciendis placeat est dicta praesentium cupiditate ut quibusdam deleniti eius optio ducimus id! Distinctio animi odio facere itaque doloremque. Dolore rem reiciendis delectus repellat quaerat quasi autem blanditiis quas totam nesciunt quae officiis neque fugit pariatur doloribus ex nam fugiat ullam beatae molestiae laboriosam deserunt odio dolorem necessitatibus temporibus. Nisi quaerat error commodi quasi ab optio tenetur libero in qui sunt odio quam aliquid impedit harum minus dignissimos laudantium quod recusandae a ullam fugiat. Earum facilis non quibusdam saepe recusandae harum assumenda possimus soluta nobis mollitia. Provident!</p>
	</div>
	<div class="footer text-center">copyright</div>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		function course(){
			var xhr = new XMLHttpRequest();
			//이벤트 추가
			xhr.onload = function(){
				//console.log(xhr.responseText);
				var courseList = JSON.parse(xhr.responseText);
				//console.log(courseList);
				var $content = $(".content");
				$content.empty();
				var $ul = $("<ul>");
				for(var course of courseList){
					var $li = $("<li>");
					$li.text(course);
					$ul.append($li);
				}
				$content.append($ul);
				//단점 : javascript로 view로 구현 - 복잡
			}
			
			//요청준비
			xhr.open("GET", "/ajax/course");
			
			//요청
			xhr.send();
		}
	</script>			
</body>
</html>