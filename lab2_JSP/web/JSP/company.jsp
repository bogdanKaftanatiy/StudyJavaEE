<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Add new company</title>
</head>
<body>
<div style="width: 900px; margin-left: auto; margin-right: auto">
    <h1>Add new company</h1>
    <form method="POST" action='DBController' name="frmAddCompany">
        <input type="hidden" name="formName" value="companyForm">
        <table>
            <tr>
                <td>ID:</td>
                <td><input type="text" readonly="readonly" name="id" value="<c:out value="${company.id}" />" /></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input  type="text" name="name" value="<c:out value="${company.name}" />" /></td>
            </tr>
            <tr>
                <td>Director ID:</td>
                <td><input type="text" name="directorID" value="<c:out value="${company.directorID}" />" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
