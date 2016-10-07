<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Display DB</title>
</head>
<body>
    <div style="width: 1200px; margin-left: auto; margin-right: auto;">
        <h1>Vacancy</h1>
        <table border=1>
            <thead>
            <tr>
                <th>Id</th>
                <th>CompanyID</th>
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
                    <td><c:out value="${vacancy.companyID}" /></td>
                    <td><c:out value="${vacancy.position}" /></td>
                    <td><c:out value="${vacancy.requirements}" /></td>
                    <td><c:out value="${vacancy.description}" /></td>
                    <td><c:out value="${vacancy.email}" /></td>
                    <td><a href="DBController?action=edit&object=vacancy&id=<c:out value="${vacancy.id}"/>">Update</a></td>
                    <td><a href="DBController?action=delete&object=vacancy&id=<c:out value="${vacancy.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    <p><a href="DBController?action=insert&object=vacancy">Add Vacancy</a></p>
    </div>
    <div style="width: 1200px; margin-left: auto; margin-right: auto;">
        <h1>Company</h1>
        <table border=1>
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>DirectorID</th>
                <th colspan=2>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${allCompany}" var="company">
                <tr>
                    <td><c:out value="${company.id}" /></td>
                    <td><c:out value="${company.name}" /></td>
                    <td><c:out value="${company.directorID}" /></td>
                    <td><a href="DBController?action=edit&object=company&id=<c:out value="${company.id}"/>">Update</a></td>
                    <td><a href="DBController?action=delete&object=company&id=<c:out value="${company.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p><a href="DBController?action=insert&object=company">Add Company</a></p>
    </div>
    <div style="width: 1200px; margin-left: auto; margin-right: auto;">
        <h1>Director</h1>
        <table border=1>
            <thead>
            <tr>
                <th>Id</th>
                <th>Firsr Name</th>
                <th>Surname</th>
                <th colspan=2>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${allDirector}" var="director">
                <tr>
                    <td><c:out value="${director.id}" /></td>
                    <td><c:out value="${director.firstName}" /></td>
                    <td><c:out value="${director.surName}" /></td>
                    <td><a href="DBController?action=edit&object=director&id=<c:out value="${director.id}"/>">Update</a></td>
                    <td><a href="DBController?action=delete&object=director&id=<c:out value="${director.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p><a href="DBController?action=insert&object=director">Add Director</a></p>
    </div>
</body>
</html>
