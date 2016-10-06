<%--
  Created by IntelliJ IDEA.
  User: Bogdan Kaftanatiy
  Date: 04.10.2016
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Show all Vacancy</title>
</head>
<body>
    <div style="width: 1200px; margin-left: auto; margin-right: auto;">
    <table border=1>
        <thead>
        <tr>
            <th>Id</th>
            <th>Company</th>
            <th>Position</th>
            <th>Requirements</th>
            <th>Description</th>
            <th>E-mail</th>
            <th colspan=2>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allVacancy}" var="vacancy">
            <tr>
                <td><c:out value="${vacancy.id}" /></td>
                <td><c:out value="${vacancy.company}" /></td>
                <td><c:out value="${vacancy.position}" /></td>
                <td><c:out value="${vacancy.requirements}" /></td>
                <td><c:out value="${vacancy.description}" /></td>
                <td><c:out value="${vacancy.email}" /></td>
                <td><a href="VacancyController?action=edit&id=<c:out value="${vacancy.id}"/>">Update</a></td>
                <td><a href="VacancyController?action=delete&id=<c:out value="${vacancy.id}"/>">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p><a href="VacancyController?action=insert">Add User</a></p>
    </div>
</body>
</html>
