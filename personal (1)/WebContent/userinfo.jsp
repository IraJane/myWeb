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
<title>INFO</title>
</head>
<body>
<my:navbar></my:navbar>

<div class="login-big-container">
<div class="login-form login-title">Information</div>



	
	<div class="login-form">
		<div class="profile-pic-cover"><div class="profile-pic"><p class="p-img"></p></div></div>
		<p>ID: ${member.user }</p>
		<p>Password: ${member.password }</p>
		<p>Nick Name:  ${member.nickName }</p>
	</div>
	
	<button  class="login-input-btn-info" type="button"
							onclick="location.href='<c:url value="/delete" />'">탈퇴</button>
							
	<button  class="login-input-btn-info" type="button"
						onclick="location.href='<c:url value="/update.jsp" />'">수정</button>
</div>
</body>
</html>