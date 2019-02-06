<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" 
 	  content="width=device-width, initial-scale=1">
<title>ItTem</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
<link rel="stylesheet" href="/public/css/shop.css" />
</head>
<body>
	<div class="header">
		<div class="jumbotron">
			<h1 class="text-center">
				<i class="fas fa-tshirt" 
				   style="font-size:85%"></i>
				ItTEM SHOP
			</h1>
		</div>
		<jsp:include page="/WEB-INF/views/menu.jsp"/>
	</div>
	<div class="content">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="glyphicon glyphicon-user"></span>
				<h4>회원정보 수정</h4>
			</div>
			<div class="panel-body">
				<!-- 추후 작업 -->
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="glyphicon glyphicon-shopping-cart"></span>
				<h4>장바구니</h4>
			</div>
			<div class="panel-body">
				<table class="table table-stipped text-center">
					<thead>
						<tr>
							<th></th>
							<th class="text-center">모델명</th>
							<th class="text-center">수량</th>
							<th class="text-center">가격</th>
							<th class="text-center">합계</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="cart" items="${cartList }">
						<tr>
							<td>
								<img src="/upload/image/${cart.product.image }" 
									 alt="" style="width:50px;"/>
							</td>
							<td>${cart.product.model }</td>
							<td>
								<input type="text" value="${cart.count }"
									   class="form-control" 
									   id="input_${cart.id }"
									   style="width:40px; display:inline"/>
								<button type="button" class="btn btn-warning"
								        onclick="updateCart(${cart.id});">수정</button>	   
							</td>
							<td>
								<fmt:formatNumber type="number" 
									value="${cart.product.price * (1-cart.product.discount) }"/>원
							</td>
							<td>
								<fmt:formatNumber type="number"
									value="${cart.product.price*(1-cart.product.discount)*cart.count}"/>원
							</td>
							<td>
								<button type="button" 
										class="btn btn-danger"
										onclick="deleteCart(${cart.id});">삭제</button>
							</td>
						</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>
								<fmt:formatNumber type="number" value="${total }"/>원
							</td>
							<td>
								<button class="btn btn-primary" 
										type="button">구매</button>	
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
	<div class="footer">
		Item Shopping mall Made By <a href="">me</a>
	</div>
	<jsp:include page="/WEB-INF/views/login.jsp"></jsp:include>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script>
	// 장바구니 수량 수정
	function updateCart(id) {
		var count = $("#input_"+id).val();
		location.href = "/cart/update?id"+id+"&count="+count;
	}
		
	// 장바구니 수량 삭제
	function deleteCart(id) {
		console.log(id);
		location.href = "/cart/delete?id="+id;
	}
	</script>
</body>
</html>