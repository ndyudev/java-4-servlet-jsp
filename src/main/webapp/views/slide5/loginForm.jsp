<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login form</title>
</head>
<body>
	<c:url value="/slide5/login" var="login"/>
	<form action="login" method="post">
		Username: <input name="username" value="${user.username}"> <br>
		Password: <input type="password" name="password"> <br>
		<button>Submit</button> <br>
	</form>
</body>
</html>