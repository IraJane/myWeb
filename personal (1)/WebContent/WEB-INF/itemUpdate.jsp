<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/mystyle.css" />">
<title>changeer</title>


<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>

<script>
	$(document).ready(function() {
		$("#update-radio").click(function() {
			$("#file-input").show();
		});

		$("#remove-radio").click(function() {
			$("#file-input").hide();
		});

	});
</script>


</head>
<body>
	<my:navbar></my:navbar>
	<my:loginbar></my:loginbar>
	<div class="write-form-container">
		<div class="login-form login-title">Rewrite</div>

		<c:url value="/item/update" var="updateUrl">
			<c:param name="id" value="${item.id }" />
		</c:url>
		<div class="item-image">
			<c:if test="${not empty item.file }">
				<img src="<c:url value="/image/i/${item.id }/${item.file }" />">
				<br>

			</c:if>
		</div>
		<div class="write-form">
		<form action="${updateUrl }" method="post"
			enctype="multipart/form-data">
			<div class="write-form-title"> <input type="text" name="title" value="${item.title }"><br></div>
			<p>write</p>
				<div class="write-textarea">
			<textarea name="body">${item.body }</textarea>
			<br></div>
			 <label> <input id="remove-radio" type="radio"
				name="file-update" value="remove"> 삭제
			</label> <label> <input id="update-radio" type="radio"
				name="file-update" value="update" checked> 변경
			</label> <input id="file-input" type="file" name="file"><br>

			<button class="login-input-btn" type="submit">Save Change</button>
			<button class="login-input-btn" type="button" onclick="location.href='<c:url value = "/" />'">Leave</button>


		</form>
		</div>
</body>
</html>