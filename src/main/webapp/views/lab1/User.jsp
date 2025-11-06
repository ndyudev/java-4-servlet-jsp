<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lesson Lab 1 | Java 4</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <c:if test="${not empty listUsers}">
        <table>
            <tr>
                <th>STT</th>
                <th>Student ID</th>
                <th>Full Name</th>
                <th>Email</th>
                <th>Admin</th>
            </tr>
            <c:forEach var="u" items="${listUsers}" varStatus="count">
                <tr>
                    <td>${count.count}</td>
                    <td>${u.id}</td>
                    <td>${u.fullname}</td>
                    <td>${u.email}</td>
                    <td><c:out value="${u.admin ? 'Admin' : 'User'}" /></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>