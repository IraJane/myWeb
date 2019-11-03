<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/mystyle.css" />">
<link href="https://fonts.googleapis.com/css?family=Cairo&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Raleway&display=swap"
	rel="stylesheet">
<title>Write</title>

<script>
	
</script>











</head>
<body>
	<my:navbar></my:navbar>
	

	<div class="write-form-container">
		<div class="login-form login-title">What are your thoughts</div>







		<div class="write-form">
			<form action="<c:url value="/item/write" />" method="post"
				enctype="multipart/form-data">
				<div class="write-form-title">
					Title: <input type="text" name="title"><br>
				</div>
				<p>write</p>
				<div class="write-textarea">
					<textarea name="body"></textarea>
					<br>
				</div>
				<div>
					file: <input type="file" name="file"><br>
				</div>
				<button class="login-input-btn" type="submit">Let's Post</button>

			</form>

		</div>
	</div>


	
</body>
</html>