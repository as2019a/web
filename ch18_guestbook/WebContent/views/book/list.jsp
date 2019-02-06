<%@page import="java.util.List"%>
<%@page import="com.inc.domain.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/inc.css" />
<style>
	body{width: 400px; margin:0 auto;}
	.book{
		margin-top:30px;
		padding:20px;
		border: 2px solid black;
	}
	button{
		display:block;
		width: 100%;
		height: 35px;
		background-color: #d35400;
		color: white;
		border: none;
		border-radius: 4px;
		box-shadow: 2px 2px 4px gray;
	}
	.search-btn{
		display: inline;
		width: auto;
	}
	[class^="flex-col"]{
		padding: 5px;
	}
	.msg{
		border: 1px dotted gray;
		min-height: 150px;
		padding: 5px;
	}
</style>
</head>
<body>
	<div class="header">
		<h1 class="title text-center">Guest Book</h1>
	</div>
	<hr />
	<div class="content">
		<div>
			<button type="button" 
			        onclick="location.href='/book/add'">ADD</button>
		</div>
		<hr />
		<div class="text-center">
		 <form action="/book/list">
				<select name="type">
					<option value="writer">이름</option>
					<option value="msg">내용</option>
				</select>
				<input type="text" name="word" />
				<button type="submit" class="search-btn">검색</button>
			</form>
		</div>
		<%if(((List<Book>)request.getAttribute("bookList")).size() == 0){ %>
			<p class="text-center">게시물이 존재하지 않습니다.</p>
		<%} %>
		<%for(Book book : 
		(List<Book>)request.getAttribute("bookList")){ %>
		<div class="book">
			<div class="msg"><%=book.getMsg() %></div>
			<div class="flex-container">
				<div class="flex-col-4">Writer</div>
				<div class="flex-col-8">
					<%=book.getWriter()+"("+book.getIp()+")" %>
				</div>
			</div>
			<div class="flex-container">
				<div class="flex-col-4">Date</div>
				<div class="flex-col-8">
					<%=book.getWritedate() %>
				</div>
			</div>
			<div class="flex-container">
				<div class="flex-col-6">
					<button type="button"
					        class="small"
onclick="del('<%=book.getPassword()%>',<%=book.getId()%>);">DELETE</button>
				</div>
				<div class="flex-col-6">
					<button type="button"
					        class="small"
onclick="update('<%=book.getPassword()%>',<%=book.getId()%>)">UPDATE</button>
				</div>
			</div>
		</div>
		<%} %>
	</div>
	<form id="hidden-form" action="/book/delete" method="post">
		<input id="hidden-input" type="hidden" name="id" />
	</form>
	<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		function del(realPassword, id){
			var userPassword = 
				prompt("비밀번호를 입력해 주세요");
			if(userPassword == realPassword){
				//지우기
				$("#hidden-input").val(id);
				$("#hidden-form").attr("action","/book/delete");
				$("#hidden-form").submit();
			}else{
				alert("비밀번호가 틀립니다");
			}
		}
		function update(realPassword, id){
			var userPassword = 
				prompt("비밀번호를 입력해 주세요");
			if(userPassword == realPassword){
				//수정화면으로 이동
				$("#hidden-input").val(id);
				$("#hidden-form").attr("action","/book/update");
				$("#hidden-form").submit();
			}else{
				alert("비밀번호가 틀립니다");
			}
		}
	</script>
</body>
</html>
