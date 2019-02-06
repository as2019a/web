<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" 
 	  content="width=device-width, initial-scale=1">
<title>TtTem</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
<link rel="stylesheet" href="/public/css/shop.css" />
<style>
	.reply{
		padding: 10px;
		border: 1px solid white;
		border-radius: 3px;
	}
	
	.reply + .reply{
		margin-top: 10px;
	}
	
	.reply-header{
		color:#286090;
	}
	
	.reply-body{
		padding: 10px;
	}
</style>
</head>
<body>
	<div class="header">
		<div class="jumbotron">
			<h1 class="text-center">
				<i class="fas fa-tshirt" 
				   style="font-size:85%"></i>
				ItTem SHOP
			</h1>
		</div>
		<jsp:include page="/WEB-INF/views/menu.jsp"/>
	</div>
	<div class="content">
		<div class="container-fluid" style="width:60% ">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>${board.title }</h4>
					<hr style="margin: 5px 0;"/>
					<div class="text-right">
						<span class="glyphicon glyphicon-user"></span>
						${board.users_id }
						&nbsp;&nbsp;
						<span class="glyphicon glyphicon-time"></span>
						${board.regdate }
						&nbsp;&nbsp;
						<span class="badge">${board.hit }</span>
					</div>
				</div>
				<div class="panel-body">
					${board.content }
				</div>
				<div class="border-footer text-right"
					style="padding: 20px;">
					<c:if test="${board.users_id eq sessionScope.user.id 
									|| sessionScope.user.id eq 'admin'}">
						<a href="/board/update?id=${board.id }" class="btn btn-warning">수정</a>
						<a href="/board/delete?id=${board.id }" class="btn btn-danger">삭제</a>
					</c:if>
					<a href="javascript:history.back();" class="btn btn-primary">목록</a>
				</div>
			</div>
			<div class="reply-form">
				<h4>Leave a Comment</h4>
				<form action="/reply/insert" method="post">
					<input type="hidden" name="board_id" 
						   value="${board.id}" />
					<div class="form-group">
						<textarea name="content" rows="3" 
								  class="form-control"
								  required></textarea>	  
					</div>
					<div class="form-group text-right">
						<button type="submit" 
								class="btn btn-primary">등록</button>
					</div>
				</form>
			</div>
			<div class="reply-list">
				<p>
					<span class="badge">
						${fn:length(board.replyList) }
					</span> 
					Comments
				</p>
				<c:forEach var="reply" items="${board.replyList }">
				<div class="reply" style="margin-left: ${reply.depth*30}px">
					<div class="reply-header">
						<span class="glyphicon glyphicon-user"></span>
						${reply.users_id } &nbsp;&nbsp;
						<span class="glyphicon glyphicon-time"></span>
						${reply.regdate } &nbsp;&nbsp;
						<button class="btn btn-primary btn-xs"
								type="button"
								data-toggle="collapse"
								data-target="#form_${reply.id }">댓글</button>
					</div>
					<div class="reply-body">
						<c:if test="${reply.depth != 0 }">
						<i class="fas fa-reply" style="transform:rotate(180deg)"></i>
						</c:if>
						${reply.content }
					</div>
					<div class="rereply-form collapse" id="form_${reply.id }">
						<form action="/reply/rereply" method="post">
							<input type="hidden" name="board_id" 
								   value="${board.id}" />
							<input type="hidden" name="ref" 
								   value="${reply.id}" />
							<div class="form-group">
								<textarea name="content" rows="3" 
										  class="form-control"
										  required></textarea>	  
							</div>
							<div class="form-group text-right">
								<button type="submit" 
										class="btn btn-primary">등록</button>
							</div>
						</form>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<div class="footer">
		Item Shopping mall Made By <a href="">LYS</a> 
	</div>
	<jsp:include page="/WEB-INF/views/login.jsp"></jsp:include>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/lang/summernote-ko-KR.min.js"></script>
    <script>
	    function checkForm(f){
			if(f.title.value == ""){
				alert("제목을 입력해 주세요");
				f.title.focus();
				return;
			}
			
			if(f.content.value == ""){
				alert("내용을 입력해 주세요");
				//f.content.focus();
				$(".note-editable").focus();
				return;
			}
			
			f.submit();
			
			//게시판글 삭제
			
			
			//게시판글 수정
			
		}
    
    	$("#content").summernote({
    		height:400,
    		//focus: true,
    		disableResizeEditor:true,
    		lang:'ko-KR',
    		callbacks:{
    			onImageUpload:sendFile,
    			onMediaDelete:deleteFile
    		}
    	});
    	
    	function deleteFile(target){
    		//console.log(target);
    		var src = target[0].src.substring(21);
    		console.log("src",src);
    		$.ajax({
    			url:"/filedelete",
    			type:"post",
    			data:{src:src},
    			success:function(data){
    				console.log(data);
    			}
    		});
    	}
    	
    	function sendFile(files, editor, welEditable){
    		//console.log(files[0]);
    		var data = new FormData();
    		data.append('upload', files[0]);
    		
    		$.ajax({
    			url:"/fileupload",
    			contentType:false,
    			processData:false,
    			data:data,
    			type:"post",
    			success:function(data){
    				//console.log(data);
    				$("#content").summernote(
    						'editor.insertImage', data.url);
    			},error:function(error){
    				console.error(error);
    			}
    		})
    	}
    	
    </script>
</body>
</html>