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
<link href="https://fonts.googleapis.com/css?family=Cairo&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="<c:url value="mystyle.css" />">
<title>login</title>
</head>
<body>
	<my:navbar></my:navbar>

	<div class="login-big-container">
		<div class="login-form login-title">Login</div>


		<div class="login-form">
			<form action="<%=contextPath%>/login" method="post">
				ID : <input class="login-input" type="text" name="id"> <br>
				PW: <input class="login-input" type="password" name="password"><br>
				<input class="login-input-btn" type="submit" value="로그인">

			</form>
		</div>
	</div>
	${error }

</body>
</html>