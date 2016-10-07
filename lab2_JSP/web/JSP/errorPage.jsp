<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ERROR</title>
</head>
<body style="padding: 20px 10px;">
    <h1>ERROR</h1>
    <span style="font-weight: bold; font-size: 125%;">Exception: </span><c:out value="${exceptionName}" />
    <br />
    <br />
    <span style="font-weight: bold; font-size: 125%;">Message: </span><c:out value="${message}" />
    <br />
    <br />
    <span style="font-weight: bold; font-size: 125%;">StackTrace:</span> <br />
    <c:forEach items="${stackTrace}" var="stack">
        <c:out value="${stack}" />
        <br />
    </c:forEach>
</body>
</html>
