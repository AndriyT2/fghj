<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Student On ${cc} Course</title>
</head>
<body>
<h2>StudentOn ${cc} Course</h2>
<table border="1">
    <thead>
    <tr>
        <th>Lastname</th>
        <th>Firstname</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.lastname}</td>
            <td>${student.firstname}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<a href="${pageContext.request.contextPath}/">Back</a>
</body>
</html>
