<%--
  Created by IntelliJ IDEA.
  User: A2
  Date: 30.03.2023
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Person.${conPersons.lastname}</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Lastname</th>
        <th>Firstname</th>
        <th>Phone</th>
        <th>E-Mail</th>
        <th>Role</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${conPersons.idSQL}</td>
        <td>${conPersons.lastname}</td>
        <td>${conPersons.firstname}</td>
        <td>${conPersons.phone}</td>
        <td>${conPersons.email}</td>
        <td>${conPersons.role}</td>
    </tr>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/person">Back</a>
</body>
</html>

