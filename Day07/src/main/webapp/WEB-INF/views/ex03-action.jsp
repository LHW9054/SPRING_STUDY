<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<script>
	const msg = '${msg}'
	if(msg != ''){
		alert(msg)
	}
	location.href = '${cpath}/ex02'
</script>

</body>
</html>