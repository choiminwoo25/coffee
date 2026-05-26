<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>메뉴 등록</title>
</head>
<body>
<h2>카페 메뉴 등록</h2>

<form:form method="post" modelAttribute="menuRegisterRequest">
    <div>
        <label>메뉴명</label>
        <form:input path="menuName"/>
        <form:errors path="menuName"/>
    </div>
    <div>
        <label>카테고리</label>
        <form:input path="category"/>
        <form:errors path="category"/>
    </div>
    <div>
        <label>가격 (원)</label>
        <form:input path="price" type="number"/>
        <form:errors path="price"/>
    </div>
    <div>
        <label>출시일</label>
        <form:input path="releaseDate" placeholder="yyyy-MM-dd"/>
        <form:errors path="releaseDate"/>
    </div>
    <button type="submit">등록</button>
    <a href="${pageContext.request.contextPath}/menu/list">목록으로</a>
</form:form>
</body>
</html>
