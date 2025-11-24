<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Slide 5</title>
</head>
<body>
	<c:url value="/slide5/tutorial" var="slide5"/>
	<a href="slide5">Lấy slide</a>
	<div class="container">
		<h1>${ applicationScope.message}</h1>
		<h1>${ request.message}</h1>
	</div>
</body>
</html>