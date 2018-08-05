<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:if test="${not empty error}">

    <section class="error"> ${error}</section>
</c:if>

<c:if test="${not empty start && not empty end && start<=end}">
<%-- ponizszy foreach dziala na kolekcji wiec start i end musza byc naturalne
wiec trzeba pokombinowac--%>
    <c:forEach begin="${start}" end="${end}" var="i">
        <li> ${i}</li>
    </c:forEach>
</c:if>


</body>
</html>
