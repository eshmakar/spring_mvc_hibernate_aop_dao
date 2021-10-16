<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<%--ЗАГОЛОВОК--%>
<h2>All Employees</h2>
<br>


<%--<table> - таблица, <tr> - первая строка таблицы, <th> - столбцы (шапка таблицы) --%>
<%--<td> - ячейка таблицы--%>
<table>
    <tr>
<%--        СТОЛБЦЫ--%>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>

<%--    ВЫВОДИМ КАЖДОГО РАБОТНИКА--%>
    <c:forEach var="emp" items="${allEmps}"> <%--берем список всех работников--%>
        <c:url var="updateButton" value="updateInfo"> <%--создаем ссылку на метод updateEmployee который находится в MyController--%>
            <c:param name="empId" value="${emp.id}"/> <%--из этого метода вытаскиваем id работника--%>
        </c:url>

        <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>

            <%--потом выводим у каждого работника кнопку Update который содержит id этого работника--%>
            <td> <input type="button" value="Update" onclick="window.location.href='${updateButton}'"/> </td>
        </tr>

    </c:forEach>

</table>
<br><br>

<%--создаем кнопку Add после таблицы--%>
<input type="button" value="Add" onclick="window.location.href='addNewEmployee'"/>

</body>

</html>