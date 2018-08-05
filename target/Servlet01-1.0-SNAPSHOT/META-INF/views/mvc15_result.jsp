<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1> You are inside mvc15_result.jsp </h1>

<table>
    <c:forEach items="${sessionScope.books}" var="book">
        <tr>
            <td>${book.title}, ${book.author}</td>
        </tr>
    </c:forEach>
</table>
<%--<c:forEach items="${ksiazki}" var="ksiazka" varStatus="Counter" begin="0" end="4" step="1">--%>

<%--<tr>--%>
<%--Dane ksiazki nr ${Counter.index+1}: <br>--%>
<%--<td>Title: ${ksiazka.title}, Author: ${ksiazka.author}, Isbn: ${ksiazka.isbn}</td>--%>
<%--<br>--%>
<%--</tr>--%>

<%--</c:forEach>--%>


</body>
</html>
