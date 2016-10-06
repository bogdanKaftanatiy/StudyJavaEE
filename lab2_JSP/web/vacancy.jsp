<%--
  Created by IntelliJ IDEA.
  User: Bogdan Kaftanatiy
  Date: 04.10.2016
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Add new vacancy</title>
</head>
<body>
    <div style="width: 900px; margin-left: auto; margin-right: auto">
        <h1>Add new vacancy</h1>
        <form method="POST" action='VacancyController' name="frmAddVacancy">
            <table>
                <tr>
                    <td>ID:</td>
                    <td><input type="text" readonly="readonly" name="id" value="<c:out value="${vacancy.id}" />" /></td>
                </tr>
                <tr>
                    <td>Company:</td>
                    <td><input  type="text" name="company" value="<c:out value="${vacancy.company}" />" /></td>
                </tr>
                <tr>
                    <td>Position:</td>
                    <td><input type="text" name="position" value="<c:out value="${vacancy.position}" />" /></td>
                </tr>
                <tr>
                    <td>Requirements:</td>
                    <td><input type="text" name="requirements" value="<c:out value="${vacancy.requirements}" />" /></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><input type="text" name="description" value="<c:out value="${vacancy.description}" />" /></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email" value="<c:out value="${vacancy.email}" />" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
