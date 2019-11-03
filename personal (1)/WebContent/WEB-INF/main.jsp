<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>

<%
	String contextPath = request.getContextPath();
%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://fonts.googleapis.com/css?family=Liu+Jian+Mao+Cao&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="<c:url value="mystyle.css" />">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
<title>Hey people</title>

</head>
<body>

	<my:navbar></my:navbar>

	


	<div class="itembox">

		<!-- 여기는 최신 5개만 불러오게 할 것  -->
		<div class="itembox-post">
			<p class="itembox-recent"><a>Recent</a></p>
			<div class="itembox-item">
				<c:forEach items="${items }" var="i">
					<c:url value="/item" var="itemUrl">
						<c:param name="id" value="${i.id }" />
					</c:url>
					<div class="itembox-item-recent">
						<div>${i.id }</div>
						<a href="${itemUrl }">${i.title }</a>
						<div class="itembox-wd">Writer: ${i.userId }</div>
	
						<div  class="itembox-wd">Date: ${i.created }</div>
					</div>
				</c:forEach>
			</div>
		</div>
		
		<div class="itembox-post-mpost">
			<p class="itembox-recent"><a>New Lyrics</a></p>
			<div class="itembox-item">
				<c:forEach items="${items2 }" var="i">
					<c:url value="/mitem" var="item2Url">
						<c:param name="id" value="${i.id2 }" />
					</c:url>
					<div class="itembox-item-recent">
						<div>${i.id2 }</div>
						<a href="${item2Url }">${i.title2 }</a>
						<div class="itembox-wd">Writer: ${i.userId2 }</div>
	
						<div  class="itembox-wd">Date: ${i.created2 }</div>
					</div>
				</c:forEach>
			</div>
		</div>
		
		

		
		
		
		
	</div>

</body>
</html>