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
	$(document).ready(
			function() {
				var update = function() {
					var commentContainer = $(this)
							.closest('.comment-container');
					var commentContent = commentContainer.html();
					var form = $('<form />').attr({
						'action' : $(this).attr('update-url'),
						'method' : 'post'
					}).css({
						'display' : 'flex',
						'flex-grow' : '1'
					});
					var textArea = $('<textArea />').attr({
						'name' : 'comment'
					}).text(commentContainer.find('.comment-body').text()).css(
							{
								'flex-grow' : '1'
							});
					var submit = $('<button />').attr({
						'type' : 'submit'
					}).html('<i class="material-icons">send</i>').addClass(
							'plain-text-btn');
					var cancelBtn = $('<button />').html(
							'<i class="material-icons">Cancel</i>').click(
							function() {
								commentContainer.html(commentContent);
								commentContainer.find('.update-btn').click(
										update);
							}).addClass('plain-text-btn');
					form.append(textArea).append(submit);
					commentContainer.empty();
					commentContainer.append(form).append(cancelBtn);
				};
				$('.update-btn').click(update);
			});
</script>
<title>Insert title here</title>
</head>
<body>


	<my:navbar></my:navbar>
	



	<c:url value="/mitem/update" var="update2Url">
	</c:url>
	<div class="item-view-container">
		<div class="item-view-info">
		
		
		<table class="item-view-info-bar">
			<th>${item.title2 }</th>
			<th>writer : ${item.userId2 }</th>
			<th>${item.created2 }</th>
			<th>${item.timeAgo }</th>
			
		
		
		</table>
		
		</div>
	




		<c:if test="${not empty item.file2 }">
			<div class="item-image">
				<img src="<c:url value="/image/m/${item.id2 }/${item.file2 }" />">
			</div>
		</c:if>
		<div class="item-body">
			<pre><c:out value="${item.body2 }" /></pre>

		</div>

	</div>
	<div class="bb-con">
		<div class="bb"></div>
		<div class="bb-in"></div>
	</div>




<div class="item-cdbtn">
	<c:if test="${item.userId2 eq member.user }">
		<button class="item-cdbtn-cd" type="button" onclick="location.href='${update2Url}'">Change</button>

		<button class="item-cdbtn-cd" type="button"
			onclick="location.href='<c:url value = "/mitem/delete" />'">Delete</button>
	</c:if>
</div>

	<!-- comment -->

	<div class="comment-box">
	
		<c:if test="${not empty member }">
			<form action="<c:url value="/comment2/insert" />" method="post">
				<div><textarea name="comment2">${comment2.comment2 }</textarea></div>
				<button  class="item-cdbtn-cd threadbtn" type="submit">Thread</button>



			</form>
		</c:if>

		<c:forEach items="${comments }" var="comment2">
			<div class="comment-container">
				<div class="comment-body-container">
					<pre class="comment-body">${comment2.comment2 }</pre>
				</div>
				<div class="comment-update-container"></div>
				<div class="comment-userId-container">
					<span>${comment2.userId2 }</span>
				</div>
				<div class="comment-timeAgo-container">
					<span>${comment2.timeAgo }</span>
				</div>
				<c:if test="${comment2.userId2 eq member.user }">
					<c:url value="/comment2/delete" var="comment2DeleteUrl">
						<c:param name="id" value="${comment2.id2 }" />
					</c:url>
					<c:url value="/comment2/update" var="comment2UpdateUrl">
						<c:param name="id" value="${comment2.id2 }" />
					</c:url>
					<button class="update-btn plain-text-btn item-cdbtn-cd"
						update-url="${comment2UpdateUrl }">create</button>
					<button class="delete-btn item-cdbtn-cd"
						onclick="location.href='${comment2DeleteUrl }'">delete</button>





				</c:if>

			</div>
		</c:forEach>

	</div>



</body>
</html>