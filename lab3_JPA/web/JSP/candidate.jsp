<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new candidate</title>
</head>
<body>
<div style="width: 800px; margin-left: auto; margin-right: auto">
    <h1>Add new candidate</h1>
    <form method="POST" action='CandidateController' name="frmAddDirector">
        <table>
            <tr>
                <td>ID:</td>
                <td><input type="text" readonly="readonly" name="id" value="<c:out value="${candidate.id}" />" /></td>
            </tr>
            <tr>
                <td>First name:</td>
                <td><input  type="text" name="firstname" value="<c:out value="${candidate.firstname}" />" /></td>
            </tr>
            <tr>
                <td>Surname:</td>
                <td><input type="text" name="surname" value="<c:out value="${candidate.surname}" />" /></td>
            </tr>
            <tr>
                <td>E-mail:</td>
                <td><input type="text" name="email" value="<c:out value="${candidate.email}" />" /></td>
            </tr>
            <tr>
                <td>CV URI:</td>
                <td><input type="text" name="cvURI" value="<c:out value="${candidate.cvURI}" />" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
