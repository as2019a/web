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
<title>ItTEM</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
<link rel="stylesheet" href="/public/css/shop.css" />
<style>
	.search-box{
		display:flex;
	}
</style>
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
		<div class="container">
			<div class="row">
				<div class="col-sm-5">
					<div class="btn-group btn-group-sm">
						<a href="?order=price&base=asc"<c:if test="${param.category != null }">&category=${param.category }</c:if>
							class="btn btn-primary">낮은가격순</a>
						<a href="?order=price&base=desc"<c:if test="${param.category != null }">&category=${param.category }</c:if>
							class="btn btn-primary">높은가격순</a>
						<a href="?order=popular&base=desc"<c:if test="${param.category != null }">&category=${param.category }</c:if> 
							class="btn btn-primary">인기많은순</a>
						<a href="?order=popular&base=asc"<c:if test="${param.category != null }">&category=${param.category }</c:if> 
							class="btn btn-primary">인기적은순</a>
					</div>
				</div>
				<div class="col-sm-4 col-sm-offset-3">
					<form action="" method="get">
						<c:if test="${param.category != null }">
						<input type="hidden" name="category"
								value="${param.category }" />
						</c:if>
						<div class="search-box">
							<div class="select-box">
								<select name="type" id="" class="form-control">
									<option value="model">모델</option>
									<option value="content">내용</option>
									<option value="manufacturer">제조사</option>
								</select>
							</div>
							<div class="text-box">
								<input type="text" name="text" class="form-control" />
							</div>
							<div class="button-box">
								<button type="submit" class="btn btn-primary btn-block">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="row">
				<c:forEach var="product" 
						   items="${productList }">
					<div class="col-md-3 col-sm-4 col-xs-6">
						<div class="product">
							<div class="product-header">
								<img src="/upload/image/${product.image }"/>
							</div>
							<div class="product-content">
								[${product.manufacturer }] ${product.content }
								<hr />
							</div>
							<div class="product-footer">
								<span class="discount">
									<fmt:formatNumber value="${product.discount*100 }"
														type="number"/>%
								</span>
								<span class="price">
									<fmt:formatNumber value="${product.price * (1-product.discount) }"
														type="number" /><span class="won">원</span>
								</span>
								<span class="realprice">
									<fmt:formatNumber value="${product.price }"
														type="number" />원
								</span>	
								<button type="button" class="btn btn-primary btn-block" 
										onclick="addToCart('${product.model}');"
										<c:if test="${product.count == 0 }" >
										disabled
										</c:if>>
									<c:if test="${product.count == 0}">품절</c:if>
									<c:if test="${product.count != 0}"><span class="glyphicon glyphicon-shopping-cart"></span>장바구니담기</c:if>
								</button>						
							</div>
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
	<script>
		function addToCart(model){
			var check = confirm("장바구니에 담으시겠습니까?");
			if(check){
				location.href="/cart/insert?model="+model;
			}
		}
	</script>
</body>
</html>