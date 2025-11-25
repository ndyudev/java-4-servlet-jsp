<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page 1</title>
</head>
<body>
	<h2>Có ${applicationScope.countUsers} users đang online</h2>
	
	<a href="${pageContext.request.contextPath}/close">Close Session</a>
</body>
</html>