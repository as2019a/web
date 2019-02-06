<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" 
 	  content="width=device-width, initial-scale=1">
<title>Score</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
</head>
<body>
	<div class="content">
		<table border="1">
			<caption>성적리스트</caption>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>
				<th>비고</th>
			</tr>
			<c:forEach var="score" items="${scoreList }">
			<tr>
				<td>${score.id }</td>
				<td>${score.name }</td>
				<td>${score.kor }</td>
				<td>${score.eng }</td>
				<td>${score.math }</td>
				<td>${score.total }</td>
				<td>${score.average }</td>
				<td>
					<!-- 수정진행방식 : location.href='/score/update?id=${score.id}' -->
					<button type="button" onclick="">수정</button>
					<button type="button" onclick="location.href='/score/delete?id=${score.id}'">삭제</button>
					<!-- 삭제진행방식 : location.href='/score/delete?id=${score.id}' -->
					<!-- id(key 값)=${score.id}(value 값) -->
					<!-- /score/delete는 ScoreDeletServlet요청을 받는다. -->
					<!-- 버튼연결방식 
						온클릭=연결경로
						1. (Servlet에 있는 /score/delete경로) 
						2. Servlet내부에서 문자에서 숫자로 변환하고(파라미터) 
						3. ScoreDao로 가서 delete(id) 받은id를 가지고 delete함수를 호출한다.
						4. 호출한 함수는 ScoreDao내부 마이바티스커넥터(Sqlsession 변수종류와
							변수선언된 이름 session에서 시작한다. 그리고 마이바티스 커넥터는
							MybatisConnector -> getInstance() -> getSqlSession();
							변수선언된 session에서 id = delete(삭제)("맵퍼(score).id(delete), id(int id)
							삭제할 해당 맵퍼를 필요로 한다.
						5. 맵퍼내부(score.xml)에서 delete에 id는 delete(삭제), parameterType으로는"int"
						   그리고 삭제버튼을 누르면 삭제할 SQL루트는 score에서 받은 id(?=25) 샵{vaule}(1행)가
						   맵퍼 xml에 있는 SQL경로를 따라서 해당 리스트에 있는 1행이 삭제가 된다.-->
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script>
		
	</script>
</body>
</html>