<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Books</h1>
<a href=<c:url value="/mvc15_dl"/> >Add</a>
<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Isbn</th>
    </tr>
    </thead>
    <tbody>
    <%--<c:forEach items="${sessionScope.books}" var="book">--%>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.isbn}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

