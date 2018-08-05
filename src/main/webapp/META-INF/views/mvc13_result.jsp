<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> You are inside mvc13_result. Book data below: </h1>
<h1>

    <c:out value="${ksiazka.title}" default="title here"/>
    <c:out value="${ksiazka.author}" default="author here"/>
    <c:out value="${ksiazka.isbn}" default="isbn here"/>


</h1>
</body>
</html>
