<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>메뉴 등록</title>
    <style>
        body { font-family: sans-serif; max-width: 480px; margin: 40px auto; }
        h2 { margin-bottom: 24px; }
        .field { margin-bottom: 16px; }
        label { display: block; font-weight: bold; margin-bottom: 4px; }
        input, select { width: 100%; padding: 8px; box-sizing: border-box; }
        .error { color: #c0392b; font-size: 0.85em; margin-top: 4px; display: block; }
        button { padding: 10px 24px; background: #2c3e50; color: #fff; border: none; cursor: pointer; }
        button:hover { background: #34495e; }
        a { color: #2980b9; text-decoration: none; }
    </style>
</head>
<body>
<h2>카페 메뉴 등록</h2>

<form:form method="post" modelAttribute="menuRegisterRequest">
    <div class="field">
        <label for="menuName">메뉴명</label>
        <form:input path="menuName" id="menuName" placeholder="예) 아메리카노"/>
        <form:errors path="menuName" cssClass="error"/>
    </div>

    <div class="field">
        <label for="category">카테고리</label>
        <form:select path="category" id="category">
            <form:option value="" label="-- 선택 --"/>
            <form:option value="커피" label="커피"/>
            <form:option value="차" label="차"/>
            <form:option value="디저트" label="디저트"/>
        </form:select>
        <form:errors path="category" cssClass="error"/>
    </div>

    <div class="field">
        <label for="price">가격 (원)</label>
        <form:input path="price" id="price" type="number" placeholder="예) 4500"/>
        <form:errors path="price" cssClass="error"/>
    </div>

    <div class="field">
        <label for="releaseDate">출시일</label>
        <form:input path="releaseDate" id="releaseDate" type="date"/>
        <form:errors path="releaseDate" cssClass="error"/>
    </div>

    <button type="submit">등록</button>
    &nbsp;
    <a href="${pageContext.request.contextPath}/menu/list">목록으로</a>
</form:form>
</body>
</html>
