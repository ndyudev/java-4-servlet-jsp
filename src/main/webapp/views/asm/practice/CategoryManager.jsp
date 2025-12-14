<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="catURL" value="/asm/practice/category" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Category Manager</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="/views/asm/practice/Layout.jsp" />

    <div class="container mt-3">
        <h2>Quản lý Danh Mục</h2>
        
        <c:if test="${not empty message}"><div class="alert alert-success">${message}</div></c:if>
        <c:if test="${not empty error}"><div class="alert alert-danger">${error}</div></c:if>

        <form method="post" class="card p-3 mb-3">
            <div class="mb-3">
                <label>Category ID</label>
                <input name="id" value="${item.id}" class="form-control" placeholder="Ví dụ: cat01" ${not empty item.name ? 'readonly' : ''}>
            </div>
            <div class="mb-3">
                <label>Category Name</label>
                <input name="name" value="${item.name}" class="form-control">
            </div>
            <div>
                <button formaction="${catURL}/create" class="btn btn-primary">Create</button>
                <button formaction="${catURL}/update" class="btn btn-warning">Update</button>
                <a href="${catURL}/reset" class="btn btn-info">Reset</a>
            </div>
        </form>

        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="c" items="${items}">
                    <tr>
                        <td>${c.id}</td>
                        <td>${c.name}</td>
                        <td>
                            <a href="${catURL}/edit?id=${c.id}" class="btn btn-sm btn-success">Edit</a>
                            <a href="${catURL}/delete?id=${c.id}" class="btn btn-sm btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>