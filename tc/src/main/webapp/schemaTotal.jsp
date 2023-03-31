<%@ page import="aMySql.AmySQL" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Person" %>
<%@ page import="model.AmySQLForServlet" %><%--
  Created by IntelliJ IDEA.
  User: A2
  Date: 29.03.2023
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Schema: Online school.</title>
</head>
<body>
<h2>Schema: Online school.Person.</h2>
<table border="2">
    <thead>
    <tr>
        <th>ID</th>
        <th>Lastname</th>
        <th>Role</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="person" items="${persons}">
        <tr>
            <td>${person.idSQL}</td>
            <td>
                <a href="${pageContext.request.contextPath}/concretePerson?personIdSQL=${person.idSQL}">${person.lastname}</a>
            </td>
            <td>${person.role}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</body>
</html>
