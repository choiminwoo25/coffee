<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>메뉴 목록</title>
    <style>
        body { font-family: sans-serif; max-width: 700px; margin: 40px auto; }
        h2 { margin-bottom: 20px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { padding: 10px 12px; border: 1px solid #ddd; text-align: left; }
        th { background: #2c3e50; color: #fff; }
        tr:nth-child(even) { background: #f9f9f9; }
        tr:hover { background: #eaf2fb; }
        a { color: #2980b9; text-decoration: none; }
        a:hover { text-decoration: underline; }
        .btn { display: inline-block; margin-bottom: 16px; padding: 8px 20px;
               background: #27ae60; color: #fff; border-radius: 3px; }
        .btn:hover { background: #2ecc71; text-decoration: none; }
    </style>
</head>
<body>
<h2>카페 메뉴 목록</h2>
<a class="btn" href="${pageContext.request.contextPath}/menu/new">+ 메뉴 등록</a>

<table>
    <thead>
    <tr>
        <th>번호</th>
        <th>메뉴명</th>
        <th>카테고리</th>
        <th>가격</th>
        <th>출시일</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${empty menus}">
            <tr><td colspan="5" style="text-align:center;">등록된 메뉴가 없습니다.</td></tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="menu" items="${menus}">
                <tr>
                    <td>${menu.id}</td>
                    <td><a href="${pageContext.request.contextPath}/menu/${menu.id}">${menu.menuName}</a></td>
                    <td>${menu.category}</td>
                    <td><fmt:formatNumber value="${menu.price}" type="number"/>원</td>
                    <td>${menu.releaseDate}</td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>
</body>
</html>
