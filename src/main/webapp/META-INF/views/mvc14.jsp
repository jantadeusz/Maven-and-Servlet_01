<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="/Mvc14">

    <h1> Wypełnij dane książek </h1>
    <c:forEach begin="0" step="1" end="4" var="i">
        Book ${i+1}:<br>
        <input type="text" name="title${i}" placeholder="type title${i+1}"/>
        <input type="text" name="author${i}" placeholder="type author${i+1}"/>
        <input type="text" name="isbn${i}" placeholder="type isbn${i+1}"/><br>
    </c:forEach>
    <input type="submit" value="Send"/>

</form>

</body>
</html>
