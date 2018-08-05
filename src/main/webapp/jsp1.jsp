<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ zeby dzialalo musisz w maven podpiac  %>--%>


<html>
<head>
    <title>Title</title>
</head>
<body>

<h1> Przeliczenie dla <c:out value="${param.km}" default=":Brak wartości"/>km </h1>

<c:if test="${param.km>0}">

    <p> ${param.km}/1,609344 = ${param.km/1.609344} mil</p>
</c:if>

<c:if test="${param.km<=0}">

    <p> Nieprawidłowe dane </p>
</c:if>


</body>
</html>
