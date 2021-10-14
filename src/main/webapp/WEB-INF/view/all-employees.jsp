<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
    </tr>

   <c:forEach var="emp" items="${allEmps}">
       <tr>
           <td>${emp.name}</td>
           <td>${emp.surname}</td>
           <td>${emp.department}</td>
           <td>${emp.salary}</td>
       </tr>

   </c:forEach>

</table>

</body>

</html>