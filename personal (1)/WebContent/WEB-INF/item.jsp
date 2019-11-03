<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="mystyle.css" />">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		var update = function() {
			var commentContainer = $(this).closest('.comment-container');
			var commentContent = commentContainer.html();
			var form = $('<form />').attr({'action' : $(this).attr('update-url'),'method' : 'post'}).css({
				'display' : 'flex','flex-grow' : '1'});
			var textArea = $('<textArea />').attr({'name' : 'comment'}).text(commentContainer.find('.comment-body')
				.text()).css({'flex-grow' : '1'});
			var submit = $('<button />').attr({'type' : 'submit'}).html('<i class="material-icons">send</i>')
				.addClass('plain-text-btn');
			var cancelBtn = $('<button />').html(
				'<i class="material-icons">Cancel</i>')
				.click(function() {
					commentContainer.html(commentContent);
					commentContainer.find('.update-btn').click(update);
				}).addClass('plain-text-btn');
				form.append(textArea).append(submit);
				commentContainer.empty();
				commentContainer.append(form).append(cancelBtn);
		};
		$('.update-btn').click(update);
	});
</script>


<title>itmmmee</title>
</head>
<body>
	<my:navbar></my:navbar>
	
	


	<c:url value="/item/update" var="updateUrl">
	</c:url>
	
	
	
	<div class="item-view-info">
		
		
		<table class="item-view-info-bar">
			<th>${item.title }</th>
			<th>writer : ${item.userId }</th>
			<th>${item.created }</th>
			<th>${item.timeAgo }</th>
			
		
		
		</table>
		
		</div>
	
	
	
	
	
	
	

	
	
	
	
	
		<c:if test="${not empty item.file }">
			<div class="item-image">
				<img src="<c:url value="/image/i/${item.id }/${item.file }" />">
			</div>
		</c:if>
		<div class="item-body">
			<pre><c:out value="${item.body }" /></pre>
	
	
	
	</div>
	
	
	
	<div class="item-cdbtn">
	<c:if test="${item.userId eq member.user }">
		<button class="item-cdbtn-cd" type="button" onclick="location.href='${updateUrl}'">Change</button>

		<button class="item-cdbtn-cd" type="button"
			onclick="location.href='<c:url value = "/item/delete" />'">Delete</button>
	</c:if>
</div>


	<!-- comment -->

	<div class="comment-box">
		<c:if test="${not empty member }">
			<form action="<c:url value="/comment/insert" />" method="post">
				<div><textarea name="comment">${comment.comment }</textarea></div>
				<button class="item-cdbtn-cd threadbtn" type="submit">Thread</button>



			</form>
		</c:if>

		<c:forEach items="${comments }" var="comment">
			<div class="comment-container">
				<div class="comment-body-container">
					<pre class="comment-body">${comment.comment }</pre>
				</div>
				<div class="comment-update-container"></div>
				<div class="comment-userId-container">
					<span>${comment.nickName }</span>
				</div>
				<div class="comment-timeAgo-container">
					<span>${comment.timeAgo }</span>
				</div>
				<c:if test="${comment.userId eq member.user }">
					<c:url value="/comment/delete" var="commentDeleteUrl">
						<c:param name="id" value="${comment.id }" />
					</c:url>
					<c:url value="/comment/update" var="commentUpdateUrl">
						<c:param name="id" value="${comment.id }" />
					</c:url>
					<button class="update-btn plain-text-btn item-cdbtn-cd"
						update-url="${commentUpdateUrl }">create</button>
					<button class="delete-btn item-cdbtn-cd" onclick="location.href='${commentDeleteUrl }'"> delete</button>
					
					
					
					
					
				</c:if>

			</div>
		</c:forEach>

	</div>













</body>
</html>