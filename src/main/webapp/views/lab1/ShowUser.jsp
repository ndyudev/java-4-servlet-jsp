<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab 1 - Show Users</title>
</head>
<body>
	<c:url var="showUsersUrl" value="/lab1/user" />
	<form action="${showUsersUrl}" method="get">
		<button type="submit">Show Users</button>
	</form>
</body>
</html>
