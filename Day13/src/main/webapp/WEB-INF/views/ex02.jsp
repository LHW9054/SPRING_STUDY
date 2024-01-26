<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>ex02 - 캐시 적용해서 매일 전송하기</h3>

<form method="POST">
	<p><input type="email" name="receiver" placeholder="받는사람"></p>
	<p><input type="text" name="subject" placeholder="제목"></p>
	<p><textarea name="content" placeholder="내용"
					style="width: 500px; height: 200px; resize: none;"></textarea></p>
	<p><input type="submit" value="보내기"></p>
</form>






</body>
</html>