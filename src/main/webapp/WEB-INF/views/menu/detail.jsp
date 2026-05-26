<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>메뉴 상세</title>
    <style>
        body { font-family: sans-serif; max-width: 480px; margin: 40px auto; }
        h2 { margin-bottom: 24px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { padding: 12px; border: 1px solid #ddd; }
        th { background: #ecf0f1; width: 30%; text-align: left; }
        .badge { display: inline-block; padding: 2px 10px; border-radius: 12px;
                 background: #2980b9; color: #fff; font-size: 0.85em; }
        a { color: #2980b9; text-decoration: none; }
        a:hover { text-decoration: underline; }
        .actions { margin-top: 20px; }
    </style>
</head>
<body>
<h2>메뉴 상세 정보</h2>

<table>
    <tr>
        <th>번호</th>
        <td>${menu.id}</td>
    </tr>
    <tr>
        <th>메뉴명</th>
        <td>${menu.menuName}</td>
    </tr>
    <tr>
        <th>카테고리</th>
        <td><span class="badge">${menu.category}</span></td>
    </tr>
    <tr>
        <th>가격</th>
        <td><fmt:formatNumber value="${menu.price}" type="number"/>원</td>
    </tr>
    <tr>
        <th>출시일</th>
        <td>${menu.releaseDate}</td>
    </tr>
</table>

<div class="actions">
    <a href="${pageContext.request.contextPath}/menu/list">← 목록으로</a>
    &nbsp;|&nbsp;
    <a href="${pageContext.request.contextPath}/menu/new">+ 새 메뉴 등록</a>
</div>
</body>
</html>
