<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new link</title>
</head>
<body>
<div style="width: 800px; margin-left: auto; margin-right: auto">
    <h1>Add new candidate to vacancy</h1>
    <form method="POST" action='VacancyCandidateLinkController' name="frmAddDirector">
        <table>
            <tr>
                <td>Vacancy ID:</td>
                <td><input type="text" name="vacancyID" value="<c:out value="${vacancyID}" />" /></td>
            </tr>
            <tr>
                <td>Candidate ID:</td>
                <td><input type="text" name="candidateID" value="<c:out value="${candidateID}" />" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
