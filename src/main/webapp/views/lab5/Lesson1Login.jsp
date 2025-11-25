<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lab 5 Lesson 1 Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/f4e3fc99b3.js" crossorigin="anonymous"></script>
</head>
<body>
    <c:if test="${not empty sessionScope.user}">
        <div class="alert alert-success">Xin chào: ${sessionScope.user.fullName}</div>
    </c:if>	

    <div class="container d-flex justify-content-center align-items-center" style="min-height: 80vh;">
    
        <c:url value="/lab5/lesson1/login" var="loginLink"/>
        
        <form action="${loginLink}" method="post" class="border p-4 rounded shadow bg-white" style="width: 100%; max-width: 400px;">
            
            <h2 class="text-info text-center mb-4">Login</h2>
            
            <c:if test="${not empty message}">
                <div class="alert alert-${message.contains('thành công') ? 'success' : 'danger'}">
                    ${message}
                </div>
            </c:if>

            <div class="mb-3">
                <label class="form-label" for="username">Username:</label>
                <input class="form-control" id="username" name="username" value="${username}">
            </div>
            
            <div class="mb-3">
                <label class="form-label" for="password">Password:</label>
                <input class="form-control" id="password" name="password" type="password">
            </div>
            
            <div>
                <button class="btn btn-info text-white w-100">Login</button>
            </div>
        </form>
    
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>