<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Schema: Online school.</title>
</head>
<body>
<h1>Schema: Online school.</h1>
<p>Виберіть пункт для отримання необхідної інформації:</p>
<ul>
    <li> <a href="${pageContext.request.contextPath}/person">Список осіб =></a></li>
    <li> <a href="${pageContext.request.contextPath}/createPerson">Додати особу =></a></li>
    <li> <a href="${pageContext.request.contextPath}/student_by_lastname">Дані про студентів, відсортовані за прізвищем =></a></li>
    <li> <a href="${pageContext.request.contextPath}/lecture_before_2023">Назва лекції та кількість додаткових матеріалів, які вони містять, відсортовані за датою та якіпроходили до 2023 року =></a></li>
    <li> <a href="${pageContext.request.contextPath}/first_lecture">Інформація про лекцію, яка створена раніше за всіх та тає найбільшу кількість домашніх завдань =></a></li>
    <li> <a href="${pageContext.request.contextPath}/additional_materials">Кількість додаткових матеріалів по кожній категорії =></a></li>
    <li> <a href="${pageContext.request.contextPath}/teacher_by_letter">Список вчителів, прізвища яких починаються з літер, які стоять до літери N англійського алфавіту або 'Н' українського =></a></li>
    <li>
    <form action="${pageContext.request.contextPath}/student_on_course" method="get">
        <label for >Прізвище та ім'я студентів, відсортовані за прізвищем, що записані на:</label>
        <input type="radio" name="course_count" value="1" checked> тільки один курс
        <input type="radio" name="course_count" value="2"> на два курси
        <input type="radio" name="course_count" value="3"> на три та більше курсів.
        <input    type="submit" value="Submit">
    </form>
    </li>

</ul>
</body>
</html>
