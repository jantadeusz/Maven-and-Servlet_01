<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${empty param.km}">
    <h1>Brak parametrów</h1>
</c:if>

<c:if test="${not empty param.km}">
    <h1>Przeliczenie dla <c:out value="${param.km}" default=": Brak wartości"/> km </h1>
    <p>${param.km}km *  1,609344 = ${param.km *  1.609344}mil</p>
</c:if>



</body>
</html>