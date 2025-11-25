<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page 2</title>
</head>
<body>
	<!--  Chạy bằng Internet Explorer -->
	<h2>Có ${applicationScope.countUsers} đang online</h2>
	<a href="${pageContext.request.contextPath}/close">Close Session</a>
</body>
</html>