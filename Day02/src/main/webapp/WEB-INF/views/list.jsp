<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="main">
	<div class="wrap">
	<c:forEach var="dto" items="${list }">
	<div class="item">
		<div class="thumbnail" style="background-image : url('${dto.thumbnail}')">
			<a href="${cpath }/view/${dto.idx}"></a>
		</div>
		<div>
			<h4>			<!-- %@ taglib prefix="fn" /> -->
				<c:if test="${fn:length(dto.title) > 40 }">
					${fn:substring(dto.title, 0, 40) }...
				</c:if>
				<c:if test="${fn:length(dto.title <= 40 }">
					${dto.title }
				</c:if>
				|
				${dto.channel }
			</h4>
		</div>
	</div>
	</c:forEach>
	</div>
</div>


</body>
</html>