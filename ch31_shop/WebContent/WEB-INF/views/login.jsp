<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="loginModal">
	<div class="modal-dialog modal-sm"">
		<div class="modal-content">
			<div class="modal-header">
				<div type="button"
					class="button close"
					data-dismiss="modal">&times;</div>
				<h4><span class="span glyphicon glyphicon-log-in"></span>Sign in</h4>
			</div>
			<div class="modal-body">
				<form action="/user/signin" method="post">
					<div class="form-group">
						<input type="text" class="form-control"
							   placeholder="Enter ID" name="id"
							   value="admin" />
					</div>
					<div class="form-group">
						<input type="password" class="form-control"
							   placeholder="Enter Password" 
							   name="password"
							   value="1111" />
					</div>
					<button class="btn btn-primary btn-block"
							type="button" 
							onclick="signin(this.form);">Sign in</button>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
	function showLoginModal(){
		$("#loginModal").modal("show");
	}
	function signin(f){
		if(f.id.value == ""){
			alert("아이디를 입력해 주세요");
			f.id.focus;
			return;
		}
		
		if(f.password.value == ""){
			alert("비밀번호를 입력해 주세요");
			f.password.focus;
			return;
		}
		
		f.submit();
	}
</script>