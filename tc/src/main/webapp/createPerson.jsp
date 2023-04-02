<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>createPerson</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/createPerson" method="post">
        Ім'я:<br>
        <input type="text" name="firstname"><br>
        Фамілія:<br>
        <input type="text" name="lastname"><br>
        Телефон:<br>
        <input type="text" name="phone"><br>
        Поштова скринька:<br>
        <input type="text" name="email"><br>
        <input type="radio" name="role" value="student" checked> student
        <input type="radio" name="role" value="teacher"> teacher<br><br>
        <input type="submit" value="Submit">

    </form>
    <a href="${pageContext.request.contextPath}/">Back</a>
</body>
</html>
