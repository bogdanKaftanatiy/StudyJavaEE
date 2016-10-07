<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new director</title>
</head>
<body>
<div style="width: 900px; margin-left: auto; margin-right: auto">
    <h1>Add new director</h1>
    <form method="POST" action='DBController' name="frmAddDirector">
        <input type="hidden" name="formName" value="companyForm">
        <table>
            <tr>
                <td>ID:</td>
                <td><input type="text" readonly="readonly" name="id" value="<c:out value="${director.id}" />" /></td>
            </tr>
            <tr>
                <td>First name:</td>
                <td><input  type="text" name="company" value="<c:out value="${director.firstName}" />" /></td>
            </tr>
            <tr>
                <td>Surname:</td>
                <td><input type="text" name="position" value="<c:out value="${director.surName}" />" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
