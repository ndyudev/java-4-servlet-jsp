<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Video</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"> 
<style>.container { margin-top: 30px; }</style>
</head>
<body>
<div class="container">
    <h2 class="mb-4 text-primary">Search Video</h2>
    
    <form action="${pageContext.request.contextPath}/lab4/cau3/searchVideo" method="post" class="mb-4">
        <div class="input-group">
            <input type="text" name="keyword" class="form-control" placeholder="Nhập từ khóa tiêu đề..." 
                   value="${keyword != null ? keyword : ''}" required>
            <button class="btn btn-primary" type="submit">Tìm Kiếm</button>
        </div>
    </form>

    <c:if test="${not empty message}">
        <div class="alert alert-info" role="alert">
            ${message}
        </div>
    </c:if>

    <c:if test="${not empty results}">
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>STT</th>
                    <th>Tiêu đề Video</th>
                    <th>Số lượt thích</th>
                    <th>Trạng thái (Active)</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="stats" items="${results}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        
                        <td>${stats[0]}</td> <td>
                            <span class="badge bg-secondary">${stats[1]}</span> </td>
                        
                        <td> <c:choose>
                                <c:when test="${stats[2] == true}">
                                    <span class="badge bg-success">CÓ</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="badge bg-danger">KHÔNG</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>