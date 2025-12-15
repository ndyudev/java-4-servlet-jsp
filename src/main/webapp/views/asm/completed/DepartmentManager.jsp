<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="deptURL" value="/asm/completed/department" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Department Manager</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="/views/asm/completed/Layout.jsp" />

    <div class="container mt-3">
        <h2>Quản lý Phòng Ban</h2>
        
        <c:if test="${not empty message}"><div class="alert alert-success">${message}</div></c:if>
        <c:if test="${not empty error}"><div class="alert alert-danger">${error}</div></c:if>

        <form method="post" class="card p-3 mb-3">
            <div class="mb-3">
                <label>Department ID</label>
                <input name="id" value="${item.id}" class="form-control" placeholder="Ví dụ: dp01" ${not empty item.name ? 'readonly' : ''}>
            </div>
            <div class="mb-3">
                <label>Department Name</label>
                <input name="name" value="${item.name}" class="form-control" placeholder="Ví dụ: Phòng Kế toán">
            </div>
            <div>
                <button formaction="${deptURL}/create" class="btn btn-primary">Create</button>
                <button formaction="${deptURL}/update" class="btn btn-warning">Update</button>
                <a href="${deptURL}/reset" class="btn btn-info">Reset</a>
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
                <c:forEach var="d" items="${items}">
                    <tr>
                        <td>${d.id}</td>
                        <td>${d.name}</td>
                        <td>
                            <a href="${deptURL}/edit?id=${d.id}" class="btn btn-sm btn-success">Edit</a>
                            <a href="${deptURL}/delete?id=${d.id}" class="btn btn-sm btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>