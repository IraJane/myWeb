<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"  uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="mystyle.css" />">
<script src= "https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
<title>SignUp</title>

<script>
$(document).ready(function(){
	$("#pw-confirm").keyup(function(){
		var origin = $("#pw").val();
		var confirm = $(this).val();
		
		if(origin == confirm) {
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
<div class="signup-big-container">
		<div class="signup-form login-title">Sign Up</div>
	<div class="signup-form">
	<form action="<c:url value = "/signup" />" method="post">
	ID :  <input class="signup-input" type= "text" name = "id" value = "${member.id }"><br>
	PW : <input class="signup-input"  id="pw" type="password" name="password" value="${member.password }"><br>
	PW - confirm : <input class="signup-input"  id="pw-confirm" type="password">
	<div class="signup-mess" id="message" value="${member.password }"></div><br>
	Nick-Name : <input class="signup-input"  type="text" name="nickName" value="${member.nickName }"><br>
	 
	
	<input class="singup-input-btn" type="submit" value ="가입"><br>
	
	
	
	</form>
	</div>
</div>	
	${error }
</body>
</html>