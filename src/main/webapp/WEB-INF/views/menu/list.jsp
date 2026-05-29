<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>메뉴 목록</title>
</head>
<body>
<h2>카페 메뉴 목록</h2>
<a href="${pageContext.request.contextPath}/cafemenu/new">메뉴 등록</a>

<table border="1">
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
        <c:when test="${empty cafeMenus}">
            <tr><td colspan="5">등록된 메뉴가 없습니다.</td></tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="cafeMenu" items="${cafeMenus}">
                <tr>
                    <td>${cafeMenu.id}</td>
                    <td><a href="${pageContext.request.contextPath}/cafemenu/${cafeMenu.id}">${cafeMenu.menuName}</a></td>
                    <td>${cafeMenu.category}</td>
                    <td>${cafeMenu.price}원</td>
                    <td>${cafeMenu.releaseDate}</td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>
</body>
</html>
