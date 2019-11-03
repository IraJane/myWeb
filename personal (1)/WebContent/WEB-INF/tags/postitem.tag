<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>





<div class="post-container">
	<div >
		<c:if test="${not empty member }">
			<a class="post-wbtn" href="<c:url value="/item/write"/>">Write</a>
		</c:if>
	</div>
	
	<div class="post-title">
	
		<p>What happened in your life today?</p>
	
	
	</div>
	
	
	
	
	
	
	<div class="post-item-container">
		<c:forEach items="${items }" var="i">
			<c:url value="/item" var="itemUrl">
				<c:param name="id" value="${i.id }" />
			</c:url>
			
			<div class="post-items">
				<div>${i.id }</div>
				<a class="post-t" href="${itemUrl }">${i.title }</a>
				<div class="post-uc">${i.userId }</div>
				<div class="post-uc">${i.created }</div>
			</div>
		
		</c:forEach>
	
	
	
	
	
		
	
	<div class="pagenum"">
			<a href="<c:url value="/post" />">Front</a>
			<c:forEach begin="${minPage }" end="${maxPage}" var="p">
				<c:url value="/post" var="pageUrl">
					<c:param name="page" value="${p }" />
				</c:url>
				<a href="${pageUrl }">${p }</a>
			</c:forEach>
		</div>
	</div>
	
	
</div>





