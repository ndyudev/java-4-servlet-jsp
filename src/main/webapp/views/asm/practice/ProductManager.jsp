<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="prodURL" value="/asm/practice/product" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="/views/asm/practice/Layout.jsp" />

    <div class="container mt-4">
    <h2>Quản lý Danh Mục</h2>
        <div class="row">
            <div class="col-md-3">
                <div class="list-group">
                    <a href="${prodURL}/index" class="list-group-item list-group-item-action active">All Categories</a>
                    <c:forEach var="c" items="${cates}">
                        <a href="${prodURL}/index?cid=${c.id}" class="list-group-item list-group-item-action">
                            ${c.name}
                        </a>
                    </c:forEach>
                </div>
            </div>

            <div class="col-md-9">
                <c:if test="${not empty message}"><div class="alert alert-success">${message}</div></c:if>
                <c:if test="${not empty error}"><div class="alert alert-danger">${error}</div></c:if>

                <form method="post" class="row g-3 p-3 border rounded mb-3">
                    <div class="col-md-6">
                        <label>Name</label>
                        <input type="hidden" name="id" value="${item.id}">
                        <input type="text" name="name" value="${item.name}" class="form-control">
                    </div>
                    <div class="col-md-6">
                        <label>Price</label>
                        <input type="number" name="price" value="${item.price}" class="form-control">
                    </div>
                    <div class="col-md-12">
                        <label>Category</label>
                        <select name="category_id" class="form-select">
                            <c:forEach var="c" items="${cates}">
                                <option value="${c.id}" ${c.id == item.category.id ? 'selected' : ''}>${c.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    
                    <div class="col-12 mt-3">
                        <button formaction="${prodURL}/create" class="btn btn-primary">Create</button>
                        <button formaction="${prodURL}/update" class="btn btn-warning">Update</button>
                        <a href="${prodURL}/reset" class="btn btn-info">Reset</a>
                    </div>
                </form>

                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Category Name</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${products}">
                            <tr>
                                <td>${p.id}</td>
                                <td>${p.name}</td>
                                <td>${p.price}</td>
                                <td>${p.category.name}</td>
                                <td>
                                    <a href="${prodURL}/edit?id=${p.id}" class="btn btn-sm btn-warning">Edit</a>
                                    <a href="${prodURL}/delete?id=${p.id}" class="btn btn-sm btn-danger"">Delete</a>  
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