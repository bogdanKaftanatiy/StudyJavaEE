<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new Director</title>
</head>
<body>
<div style="width: 800px; margin-left: auto; margin-right: auto">
    <h1>Add new director</h1>
    <form method="POST" action='DirectorController' name="frmAddDirector">
        <table>
            <tr>
                <td>ID:</td>
                <td><input type="text" readonly="readonly" name="id" value="<c:out value="${director.id}" />" /></td>
            </tr>
            <tr>
                <td>First name:</td>
                <td><input  type="text" name="firstname" value="<c:out value="${director.firstname}" />" /></td>
            </tr>
            <tr>
                <td>Surname:</td>
                <td><input type="text" name="surname" value="<c:out value="${director.surname}" />" /></td>
            </tr>
            <tr>
                <td>Company ID: </td>
                <td><input type="text" readonly="readonly" name="companyID" value="<c:out value="${director.company.id}" />"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
