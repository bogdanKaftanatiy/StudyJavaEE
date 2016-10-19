<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new link</title>
</head>
<body>
<div style="width: 800px; margin-left: auto; margin-right: auto">
    <h1>Add new candidate to vacancy</h1>
    <form method="POST" action='!!!!!!' name="frmAddDirector">
        <table>
            <tr>
                <td>Vacancy ID:</td>
                <td><input type="text" readonly="readonly" name="id" value="<c:out value="${director.id}" />" /></td>
            </tr>
            <tr>
                <td>Candidate ID:</td>
                <td><input type="text" readonly="readonly" name="id" value="<c:out value="${director.id}" />" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
