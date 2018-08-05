<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${ksiazki}" var="ksiazka" varStatus="Counter" begin="0" end="4" step="1">

    <tr>
        Dane ksiazki nr ${Counter.index+1}: <br>
        <td>Title: ${ksiazka.title}, Author: ${ksiazka.author}, Isbn: ${ksiazka.isbn}</td>
        <br>
    </tr>

</c:forEach>


</body>
</html>
