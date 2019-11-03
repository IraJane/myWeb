<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String contextPath = request.getContextPath();
%>









<div class="heading-container">
	<div>
		<a id="logo-heading" href="<c:url value="/" />">
			<h1>Hello!</h1>
		</a>
	</div>
	
	
	
	
	
	<c:choose>
		<c:when test="${empty member }">
			<div class="head-postbtn-right">
				<button class="login-wait" type="button"
					onclick="location.href='<c:url value="/login" />'">Login</button>
				<button class="login-wait" type="button"
					onclick="location.href='<c:url value = "/signup" />'">
					Sign Up</button>
			</div>



		</c:when>
		<c:otherwise>
			<div class="head-postbtn-right">
				<b>Welcome ${member.nickName },</b>
				<a href="<c:url value="/userinfo.jsp"/>">Info</a> 
				<button class="head-postbtn-right-logout" type="submit"
					onclick="location.href='<c:url value="/logout"/> '">Log
					Out</button>
			</div>
		</c:otherwise>
	</c:choose>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	<div class="head-menu">
		<div class="head-post">
		<button class="head-postbtn" type="button"
							onclick="location.href='<c:url value="/" />'">Home</button>
			<button class="head-postbtn" type="button"
							onclick="location.href='<c:url value="/post" />'">post</button>
			<button class="head-postbtn" type="button"
							onclick="location.href='<c:url value="/mpost" />'">Music</button>
		</div>
	</div>
</div>




