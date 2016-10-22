<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Display DB</title>
</head>
<body>
<div style="width: 49%; float: left;">
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
                <td><c:out value="${vacancy.company.id}" /></td>
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
    <p><a href="VacancyController?action=insert&object=vacancy">Add Vacancy</a></p>
    <br />
    <h1>Candidate</h1>
    <table border=1>
        <thead>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Surname</th>
            <th>Email</th>
            <th>CV URI</th>
            <th colspan=2>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allCandidate}" var="candidate">
            <tr>
                <td><c:out value="${candidate.id}" /></td>
                <td><c:out value="${candidate.firstname}" /></td>
                <td><c:out value="${candidate.surname}" /></td>
                <td><c:out value="${candidate.email}" /></td>
                <td><c:out value="${candidate.cvURI}" /></td>
                <td><a href="CandidateController?action=edit&id=<c:out value="${candidate.id}"/>">Update</a></td>
                <td><a href="CandidateController?action=delete&id=<c:out value="${candidate.id}"/>">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p><a href="CandidateController?action=insert">Add Candidate</a></p>
    <br />
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
                <td><c:out value="${company.director.id}" /></td>
                <td><a href="CompanyController?action=edit&id=<c:out value="${company.id}"/>">Update</a></td>
                <td><a href="CompanyController?action=delete&id=<c:out value="${company.id}"/>">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p><a href="CompanyController?action=insert">Add Company</a></p>
</div>
<div style="width: 49%; float: right;">
    <h1>Vacancy_Candidate</h1>
    <table border=1>
        <thead>
        <tr>
            <th>Vacancy Id</th>
            <th>Candidate ID</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allVacancy}" var="vacancy">
            <c:forEach items="${vacancy.candidates}" var="candidate">
                <tr>
                    <td><c:out value="${vacancy.id}" /></td>
                    <td><c:out value="${candidate.id}" /></td>
                    <td><a href="VacancyCandidateLinkController?action=delete&vacID=<c:out value="${vacancy.id}"/>&canID=<c:out value="${candidate.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </c:forEach>
        </tbody>
    </table>
    <p><a href="VacancyCandidateLinkController?action=insert">Add Vacancy-Candidate</a></p>
    <br />
    <h1>Director</h1>
    <table border=1>
        <thead>
        <tr>
            <th>Id</th>
            <th>Firsr Name</th>
            <th>Surname</th>
            <th>Company</th>
            <th colspan=2>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allDirector}" var="director">
            <tr>
                <td><c:out value="${director.id}" /></td>
                <td><c:out value="${director.firstname}" /></td>
                <td><c:out value="${director.surname}" /></td>
                <td><c:out value="${director.company.id}" /></td>
                <td><a href="DirectorController?action=edit&id=<c:out value="${director.id}"/>">Update</a></td>
                <td><a href="DirectorController?action=delete&id=<c:out value="${director.id}"/>">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p><a href="DirectorController?action=insert">Add Director</a></p>
</div>
</body>
</html>
