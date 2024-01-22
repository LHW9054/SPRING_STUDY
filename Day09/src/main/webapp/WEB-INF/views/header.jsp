<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>::: 파일첨부 회원제 게시판 :::</title>
<style>
	div#main{
		width:900px;
		margin:auto;
	}
	.sb700{
		display : flex;
		width : 700px;
		margin : auto;
		justify-content : space-between;
		align-items:center;
	}
	table{
		border-collapse : collapse;
		border: 2px solid black;
	}
	td, th{
		padding:10px;
		border: 1px solid #dadada;
	}
	a{
		text-decoration:none;
		color:inherit;
	}
	a:hover{
		text-decoration:underline;
	}
</style>
</head>
<body>

<header>
	<h1><a href="${cpath }">Day09</a></h1>
	<p align="right">
		<c:if test="${not empty login }">
			${login.userid } (${login.username })
		</c:if>
	</p>
	<nav>
		<ul>
			<li><a href="${cpath }/board/list">게시판</a></li>
			<li><a href="${cpath }/member/${empty login ? 'login' : 'logout'}">
				${empty login ? '로그인' : '로그아웃' }</a></li>
		</ul>
	</nav>
</header>



