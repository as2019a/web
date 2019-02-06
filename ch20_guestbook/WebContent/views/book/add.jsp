<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
					<textarea name="msg"></textarea>
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
	<script>
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



