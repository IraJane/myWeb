<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="mystyle.css" />">
<link href="https://fonts.googleapis.com/css?family=Cairo&display=swap"
	rel="stylesheet">
<title>UPDATE </title>

<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>

<script>
$(document).ready(function() {
	$("#pw-confirm").keyup(function() {
		var origin = $("#pw").val();
		var confirm = $(this).val();
		if (origin == confirm) {
			var message = "correct";
		} else {
			var message = "not correct";
		}
		$("#message").text(message);

	});

});

</script>


</head>
<body>
<my:navbar></my:navbar>

<div class="login-big-container">
<div class="login-form login-title">Change Information</div>



	<form action="<c:url value="/update" />" method="post">
		password : <input class="login-input" id="pw" type="password" name="password"><br>
		pw-confim : <input class="login-input" id="pw-confirm" type="password"> <span	id="message"></span><br> 
		nick name : <input class="login-input" type="text"	name="nickName"><br> 

		<input class="login-input-btn-info" type="submit" value="정보 수정">
	</form>


</div>
</body>
</html>