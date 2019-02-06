<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>글수정</h4>
				</div>
				<div class="panel-body">
					<form action="/board/update" method="post" >
						<input type="hidden" value="${board.id }" name="id" />
						<div class="from-group">
							<input type="text" class="form-control"
									name="title" 
									value="${board.title }"
									placeholder="제목을 입력해주세요."/>
						</div>
						<div class="form-group">
							<textarea class="form-control" id="content"
										name="content" placeholder="내용을 입력해주세요.">
										${board.content }</textarea>
						</div>
						<div class="form-group text-right">
							<button class="btn btn-primary"
									type="button" 
									onclick="checkForm(this.form);">등록</button>
						</div>
					</form>
				</div>
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