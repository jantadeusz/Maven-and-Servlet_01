<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${empty param.a && empty param.b}">
    <h1>Brak parametrów</h1>
</c:if>

<c:if test="${not empty param.a && not empty param.b}">

    <p> pierwszy parametr: ${param.a}, drugi parametr: ${param.b}</p>
</c:if>

<%--<p> Wartosc ciasteczka z zadania 4 </p>--%>
<h1>${cookie.foo.value}</h1>
</body>
</html>
