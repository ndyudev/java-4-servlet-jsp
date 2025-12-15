<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 

<c:url var="empURL" value="/asm/completed/employee" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="/views/asm/completed/Layout.jsp" />

    <div class="container mt-4">
    <h2>Quản lý Nhân Viên</h2>
        <div class="row">
            <div class="col-md-3">
                <div class="list-group">
                    <a href="${empURL}/index" class="list-group-item list-group-item-action active">All Departments</a>
                    <c:forEach var="d" items="${departments}">
                        <a href="${empURL}/index?dpId=${d.id}" class="list-group-item list-group-item-action">
                            ${d.name}
                        </a>
                    </c:forEach>
                </div>
            </div>

            <div class="col-md-9">
                <c:if test="${not empty message}"><div class="alert alert-success">${message}</div></c:if>
                <c:if test="${not empty error}"><div class="alert alert-danger">${error}</div></c:if>

                <form method="post" class="row g-3 p-3 border rounded mb-3">
                    <div class="col-md-6">
                        <label>Employee ID (Number)</label>
                        <input type="number" name="id" value="${item.id}" class="form-control" ${not empty item.name ? 'readonly' : ''}>
                    </div>
                    <div class="col-md-6">
                        <label>Fullname</label>
                        <input type="text" name="name" value="${item.name}" class="form-control">
                    </div>
                    <div class="col-md-6">
                        <label>Salary</label>
                        <input type="number" step="0.01" name="salary" value="${item.salary}" class="form-control">
                    </div>
                    <div class="col-md-6">
                        <label>Department</label>
                        <select name="dp_id" class="form-select">
                            <c:forEach var="d" items="${departments}">
                                <option value="${d.id}" ${d.id == item.department.id ? 'selected' : ''}>${d.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    
                    <div class="col-12 mt-3">
                        <button formaction="${empURL}/create" class="btn btn-primary">Create</button>
                        <button formaction="${empURL}/update" class="btn btn-warning">Update</button>
                        <a href="${empURL}/reset" class="btn btn-info">Reset</a>
                    </div>
                </form>

                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Salary</th>
                            <th>Department</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="e" items="${employees}">
                            <tr>
                                <td>${e.id}</td>
                                <td>${e.name}</td>
                                <td><fmt:formatNumber value="${e.salary}"/></td>
                                <td>${e.department.name}</td>
                                <td>
                                    <a href="${empURL}/edit?id=${e.id}" class="btn btn-sm btn-warning">Edit</a>
                                    <a href="${empURL}/delete?id=${e.id}" class="btn btn-sm btn-danger">Delete</a>  
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>