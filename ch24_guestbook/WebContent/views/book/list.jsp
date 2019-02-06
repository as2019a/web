<%@page import="java.util.List"%>
<%@page import="com.inc.domain.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
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
		background-color: tomato;
		color: white;
		border: none;
		border-radius: 4px;
		box-shadow: 2px 2px 4px gray;
	}
	.search-btn{
		display:inline;
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
		<div class="text-right">
			<form action="/book/list">
				<select name="type">
					<option value="writer">이름</option>
					<option value="msg">내용</option>
				</select>
				<input type="text" name="word" />
				<button type="submit" class="search-btn">검색</button>
			</form>
		</div>
		<%-- <%if(((List<Book>)request
		      .getAttribute("bookList")).size() == 0){ %>
		      <p class="text-center">게시물이 존재하지 않습니다.</p>
		<%} %> --%>
		<c:if test="${empty bookList}">
			<p class="text-center">게시물이 존재하지 않습니다.</p>
		</c:if>
		<%-- <%for(Book book : 
		(List<Book>)request.getAttribute("bookList")){ %> --%>
		<c:forEach var="book" items="${bookList}">
		<div class="book">
			<div class="msg">${book.msg }</div>
			<div class="flex-container">
				<div class="flex-col-4">Writer</div>
				<div class="flex-col-8">
					${book.writer }(${book.ip })
				</div>
			</div>
			<div class="flex-container">
				<div class="flex-col-4">Date</div>
				<div class="flex-col-8">
					${book.writedate }
				</div>
			</div>
			<div class="flex-container">
				<div class="flex-col-6">
					<button type="button"
					        class="small"
       onclick="del(${book.id });">DELETE</button>
				</div>
				<div class="flex-col-6">
					<button type="button"
					        class="small"
    onclick="update(${book.id })">UPDATE</button>
				</div>
			</div>
		</div>
		</c:forEach>
		<%-- <%} %> --%>
	</div>
	<form id="hidden-form" method="post">
		<input id="hidden-input" 
		       type="hidden" name="id" />
	</form>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		function del(id){
			var userPassword = 
				prompt("비밀번호를 입력해 주세요");
			
			$.ajax({
				type:"get",
				url:"/checkpassword",
				data:{id:id, password:userPassword},
				success:function(data){
					if(data == "correct"){
						//지우기
						$("#hidden-input").val(id);
						$("#hidden-form").attr("action","/book/delete");
						$("#hidden-form").submit();
					}else{
						alert("비밀번호가 틀립니다");
					}
				},
				error:function(error){
					console.error(error);
				}
			});
			
			
		}
		function update(id){
			var userPassword = 
				prompt("비밀번호를 입력해 주세요");
			$.ajax({
				type:"get",
				url:"/checkpassword",
				data:{id:id, password:userPassword},
				success:(data) => {
					if(data == 'correct'){
						$("#hidden-input").val(id);
						$("#hidden-form").attr("action", "/book/update");
						$("#hidden-form").submit();
					}else{
						alert("비밀번호가 틀립니다");
					}
				}
			});
		}
	</script>
</body>
</html>