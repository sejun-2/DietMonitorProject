<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>search페이지</h1>
	
	
	<c:forEach var="dataSort" items="${dataSortList}">
		
		<label><input type="checkbox" value="${dataSort.dataSortId}" name="${dataSortId}" onclick="findMainCategory()">${dataSort.dataSortName}</label><br>
		
		<c:forEach var="mainCategory" items="${mainCategoryList}">
		
			<c:if test="${mainCategory.dataSortId == dataSort.dataSortId}">
			
				<label><input type="checkbox" value="${mainCategory.mainCategoryId}" name="${mainCategoryId}">${mainCategory.mainCategoryName}</label>
			
			</c:if>
			
		</c:forEach>
		<br><br>
	</c:forEach>
	
	
	
	<p>foodList 목록</p>
	<table>
	<tr>
		<th>번호</th>
		<th>식품명</th>
		<th>대분류명</th>
		<th>중분류명</th>
		<th>칼로리</th>
	</tr>
	<c:forEach var="food" items="${foodList}">
		<c:set var="i" value="${i+1}"/>
		<tr>
			<td>${i}</td>
			<td>${food.foodName}</td>
			<td>${food.mainCategoryName}</td>
			<td>${food.midCategoryName}</td>
			<td>${food.kcal}</td>
		</tr>
	</c:forEach>
	</table>
	
	<script>
		
	
	</script>
</body>
</html>