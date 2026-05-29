<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>메뉴 상세</title>
</head>
<body>
<h2>메뉴 상세 정보</h2>

<table border="1">
    <tr>
        <th>번호</th>
        <td>${cafeMenu.id}</td>
    </tr>
    <tr>
        <th>메뉴명</th>
        <td>${cafeMenu.menuName}</td>
    </tr>
    <tr>
        <th>카테고리</th>
        <td>${cafeMenu.category}</td>
    </tr>
    <tr>
        <th>가격</th>
        <td>${cafeMenu.price}원</td>
    </tr>
    <tr>
        <th>출시일</th>
        <td>${cafeMenu.releaseDate}</td>
    </tr>
</table>

<a href="${pageContext.request.contextPath}/cafemenu/list">목록으로</a>
</body>
</html>
