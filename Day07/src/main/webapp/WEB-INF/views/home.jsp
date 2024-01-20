<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<h3>home.jsp</h3>

<p><a href="${cpath }/ex01"><button>ex01- 회원가입 구현(Hash적용)</button></a></p>
<p><a href="${cpath }/ex02"><button>ex02- 로그인 구현 (Hash적용)</button></a></p>
<p><a href="${cpath }/ex03"><button>ex03- 비밀번호 재발급 (hash적용)</button></a></p>
<p><a href="${cpath }/ex04"><button>ex04- 비밀번호 변경 (로그인전용)</button></a></p>

<fieldset>
	<legend>hash test</legend>
	<form method="POST">
		<input type="text" name="source" placeholder="source" autofocus>
		<input type="text" name="salt" placeholder="salt">
		<input type="submit">
	</form>
	<c:if test="${not empty hash }">
		<h3>source : ${param.source }</h3>
		<h3>hash : ${hash }</h3>
		<h3>salt : ${salt }</h3>
	</c:if>
</fieldset>





</body>
</html>