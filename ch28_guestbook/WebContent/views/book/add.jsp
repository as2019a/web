<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
<style>
	body{
		width:400px;
		margin:0 auto;
	}
	textarea{
		width:100%;
		min-height: 200px;
	}
</style>
</head>
<body>
	<form id="addform" action="/book/add" method="post">
		<table>
			<caption>ADD</caption>
			<tr>
				<th>Writer</th>
				<td>
					<input type="text" name="writer"/>
				</td>
			</tr>
			<tr>
				<th>Password</th>
				<td>
					<input type="password" name="password"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea name="msg" id="msg"></textarea>
				</td>
			</tr>
			<tr>
				<td>
					<button type="button" 
					        onclick="check();">SEND</button>	
				</td>
				<td>
					<button type="button"
		        onclick="location.href='/book/list'">CANCLE</button>
				</td>
			</tr>		
		</table>
	</form>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/lang/summernote-ko-KR.min.js"></script>
	<script>
		$("#msg").summernote({
			height:300,
    		focus: true,
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
    				$("#msg").summernote(
    						'editor.insertImage', data.url);
    			},error:function(error){
    				console.error(error);
    			}
    		})
    	}
    	
		function check(){
			if($("[name='writer']").val() == ""){
				alert("이름을 입력해 주세요");
				$("[name='writer']").focus();
				return;
			}
			
			if($("[name='password']").val() == ""){
				alert("비밀번호를 입력해 주세요");
				$("[name='password']").focus();
				return;
			}
			
			$("#addform").submit();
		}
	</script>
</body>
</html>



