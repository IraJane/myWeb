<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="mystyle.css" />">
<link
	href="https://fonts.googleapis.com/css?family=Liu+Jian+Mao+Cao&display=swap"
	rel="stylesheet">
<title>Music posts</title>
</head>
<body>
<my:navbar></my:navbar>

<div class="mpost-title">
	
		<p>What a wonderful day</p>
	
	
	</div>

<div class=" mpost-bigcontainer">
	<c:if test="${not empty member }">
	<a class="mpost-write" href="<c:url value="/mitem/write"/>">Write</a>
	</c:if>

<div class="mpost-item-con">
	<c:forEach items="${items }" var="i">
		<c:url value="/mitem" var="item2Url">
			<c:param name="id" value="${i.id2 }" />
		</c:url>
		
		<div class="mpost-item-box" >
			<div class="mpost-i">${i.id2 }</div>
			<a class="mpost-it" href="${item2Url }">${i.title2 }</a>
			<div class="mpost-uc">${i.userId2 }</div>
			<div class="mpost-uc">${i.created2 }</div>
		
		</div>
		
		
		
		
		
		
		
	</c:forEach>
</div>
<div class="pagenum">
		<a href="<c:url value="/mpost" />">Front</a>
		<c:forEach begin="${minPage }" end="${maxPage}" var="p">
			<c:url value="/mpost" var="pageUrl">
				<c:param name="page" value="${p }" />
			</c:url>
			<a href="${pageUrl }">${p }</a>
		</c:forEach>
	</div>









</div>




</body>
</html>