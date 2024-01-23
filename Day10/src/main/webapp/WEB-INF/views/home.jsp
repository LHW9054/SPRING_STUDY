<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<h1>메인페이지</h1>


<h1>Day10</h1>
<hr>
<h3>java path:${javaVersion }</h3>
<h3>Srping version:${springVersion }</h3>

<ul>
	<li><a href="${cpath }/ex01">ex01 - 예외처리(ExceptionHandler)</a></li>
	<li><a href="${cpath }/ex02">ex02 - 예외처리(ControllerAdvice)</a></li>
</ul>

<h3>현재 로그인 : ${login.userid }</h3>
<ul>
	<li><a href="${cpath }/login">ex03 - 로그인</a></li>
	<li><a href="${cpath }/board">ex03 - 게시판</a></li>
	<li><a href="${cpath }/sitemap">ex03 - 사이트맵</a></li>
	<li><a href="${cpath }/mypage">ex03 - 내정보</a></li>
</ul>



</body>
</html>