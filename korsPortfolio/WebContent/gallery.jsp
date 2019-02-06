<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Kors Gallery</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
    <link href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" >
  <style>
  	body{
			font-family: 'Noto Sans KR', sans-serif;
		}
		
	.navbar {
      		margin-bottom: 0;
      		border-radius: 0;
    }
    
    footer {
      		background-color: #f2f2f2;
      		padding: 25px;
    }
    
    .table>thead>tr>th{
    	margin: 0;
    	vertical-align: middle;
    	text-align: center;
    }
        
    .table>tbody{
    	margin: 0;
    	vertical-align: middle;
    	text-align: center;
    }
    
    #imagesearch{
    	background-color: #1B1464;
    	color: #dfe6e9;
    }
    
    #filedownload{
    	background-color: #00cec9;
    	color: #e1b12c;
    }
  </style>
  </head>
  <body>
    
    <nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>                        
	      </button>
	      <a class="navbar-brand" href="#">Kors Folio</a>
	    </div>
	    <div class="collapse navbar-collapse" id="myNavbar">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#">Home</a></li>
	        <li><a href="/about.html">About</a></li> <!-- html로 활용할 About 페이지 링크 -->
	        <li><a href="/gallery.jsp">Gallery</a></li> <!-- 오픈소스(카카오개발자 활용) Model2를 활용할 갤러리 링크 -->
	        <li><a href="">Jobtype</a></li> <!-- 자체소스 Model2를 활용할 컨텐츠 페이지 링크 -->
	        <li><a href="#">Shopping</a></li> <!-- 자체소스 Model2를 활용할 kors쇼핑몰 페이지 링크 -->
	        <li><a href="#">Summernote</a></li> <!-- summernote 연결 페이지 링크 -->
	        <li><a href="#">Sign up</a></li> <!-- 회원가입 페이지 링크 -->
	        <li><a href="#" onclick="location.href='http://localhost:8080/WebContent/korshomepageone.jsp';">KorsHomepage</a></li> <!-- kors_hompage 프로젝트에 있는 html연결 링크 -->
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> <!-- 회원 로그인 링크 -->
	        <!-- 회원관리는 별도 SQL과 JSP를 활용하여 데이터전송 보관 관리 -->
	        <!-- SQL 오라클 conn_kors에 insert into ... values();를 활용 튜플 추가 및 리스트 활용 -->
	      </ul>
	    </div>
	  </div>
	</nav>

	<div class="jumbotron">
	  <div class="container text-center">
	    <h1>Kors Portfolio</h1>      
	    <p class=>Hello We are a kors research center operated by our company.</p>
	  </div>
	</div>
	<div class="content">
		<div class="container">
    	<div class="row">
    		<div class="col-sm-12 col sm-offset-2">
    			<div class="row">
    				<div class="col-sm-2" style="padding-right:0">
		    			<select id="type" class="form-control">
		    				<option value="title">제목</option>
		    				<option value="imagename">이름</option>
		    				<option value="contents">컨텐츠</option>
		    			</select>
    				</div>
    				<div class="col-sm-3" style="padding:0">
		    			<input type="text" class="form-control"
		    				   onkeyup="searchimage(event);" />
    				</div>
    			<form action="/imagesearch" method="get">
    				<div class="col-sm-1 button-box" style="padding:0">
						<button type="submit" class="btn btn-default btn-block"
								formmethod="get" id="imagesearch">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</div>
				</form>
				<form action="/imageupload" method="get">
    				<div class="col-sm-1 button-box" style="padding:0">
						<button type="submit" class="btn btn-warning btn-block"
								formmethod="get" id="imageupload">
							<span class="far fa-images"></span>
						</button>
					</div>
				</form>
				<form action="/googles" method="get">
    				<div class="col-sm-1 button-box" style="padding:0">
						<button type="button" class="btn btn-info btn-block"
								onclick="location.href='https://www.google.co.kr/';" id="googles">
							<span class="fab fa-google-plus"></span>
							<!-- https://www.google.co.kr -->
						</button>
					</div>
				</form>
				<form action="/shield" method="get">
    				<div class="col-sm-1 button-box" style="padding:0">
						<button type="submit" class="btn btn-primary btn-block"
								formmethod="get" id="shield">
							<span class="fas fa-shield-alt"></span>
						</button>
					</div>
				</form>
				<form action="/filedownload" method="get">
    				<div class="col-sm-1 button-box" style="padding:0">
						<button type="submit" class="btn btn btn-block"
								formmethod="get" id="filedownload">
							<span class="fas fa-paperclip"></span>
						</button>
					</div>
				</form>
				<form action="/cafesearch" method="get">
					<div class="col-sm-1" style="padding:0">
			    		<button type="submit" class="btn btn btn-block"
			    				formmethod="get" id="cafesearch"/>
							<span class="fas fa-coffee"></span>
						</button>
	    			</div>
	    		</form>
				<form action="/spiderweb" method="get">
    				<div class="col-sm-1 button-box" style="padding:0">
						<button type="submit" class="btn btn-success btn-block"
								formmethod="get" id="spiderweb">
							<span class="fas fa-spider"></span>
						</button>
					</div>
				</form>
				<form action="/infolink" method="get">
    				<div class="col-sm-1 button-box" style="padding:0">
						<button type="submit" class="btn btn-danger btn-block"
								formmethod="get" id="infolink">
							<span class="fas fa-info-circle"></span>
						</button>
					</div>
				</form>
	    		</div>
    			<table class="table table-striped" id="image" >
    				<thead>
    					<tr id="thclass">
    						<th></th>
    						<th>컬렉션</th>
    						<th>썸네일</th>
    						<th>출처명</th>
    						<th>컨텐츠</th>
    						<th></th>
    					</tr>
    				</thead>
    				<tbody>
    					<c:forEach var="image" items="${imageList }">
    					<tr>
    						<td>
    							<button type="button"></button>
    						</td>
    						<td>${image.collection }</td>
    						<td><img src="/images/${image.thumbnails }" alt="이미지를 넣어주세요" id="thumbnails" /></td>
    						<td>${image.display_sitename }</td>
    						<td>${image.contents }</td>
    						<td>
    							<a class="btn btn-primary" href="/image/delete?collection=${image.collection }">삭제</a>
    						</td>
    					</tr>
    					</c:forEach>
    				</tbody>
    			</table>
    		</div>
    	</div>
   	 </div>
	</div>
	<footer class="container-fluid text-center">
	  <p>Kors Group Company <span class=""></span><a href="">LHN</a></p> <!-- 요것 추후... -->
	</footer>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script>
	    function searchimage(event){
			if(event.key != 'Enter'){
				return;
			}
				
		}
	    
	    
    </script>
  </body>
</html>