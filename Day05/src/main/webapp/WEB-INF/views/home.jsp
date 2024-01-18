<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>대문페이지</h3>
<h3>접속된 DB정보 : ${version }</h3>

<p><a href="${cpath }/board/list"><button>게시판</button></a></p>
<p><a href="${cpath }/ex01"><button>파일업로드 예제1</button></a></p>
<p><a href="${cpath }/ex02"><button>파일업로드 예제2 (DTO)</button></a></p>
<p><a href="${cpath }/ex03"><button>파일업로드 예제3 (컴포넌트 활용)</button></a></p>


</body>
</html>