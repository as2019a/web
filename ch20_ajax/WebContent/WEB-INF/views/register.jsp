<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<select id="category" onchange="setSubcategory()">
		<c:forEach var="category" 
				   items="${categoryList }">
		<option value="${category }">
			${category }
		</option>
		</c:forEach>
	</select>
	<select id="subcategory"></select>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		setSubcategory();
		function setSubcategory(){
			var category = $("#category").val();
			//console.log(category);
			$.ajax({
				type:"get",
				url:"/subcategory/list",
				data:{"category":category},
				success:function(data){
					console.log(data);
					var subList = JSON.parse(data);
					console.log(subList);
					var $subselect = $("#subcategory");
					$subselect.empty();
					for(var sub of subList){
						var $op = $("<option>");
						$op.val(sub);
						$op.text(sub);
						$subselect.append($op);
					}
				}
			});
		}
	</script>
</body>
</html>