<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    Create a new grocery list

    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 50%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 5px;
        }

        tr:nth-child(even) {
            background-color: cornflowerblue;
        }
    </style>
</head>

<body>

<input type="hidden" name="idUser" value="${idUser}">

<form method="post" action="/groceryList">
    <input type="hidden" name="idUser" value="${idUser}">
    <br><label for="lname">Grocery list name </label>
    <input type="text" id="lname" name="lname" value="">
    <input type="submit" value="Create list">
</form>


<h1>All lists</h1>

<table>

    <tr>
        <th>List Name</th>
        <th>Edit List</th>
    </tr>

    <form action="/groceryList/edit" method="POST">
        <input type="hidden" name="idUser" value="${idUser}">
        <c:forEach items="${lists}" var="list">
            <tr>
                <div1>
                    <td>${list.name}</td>
                    <td>
                        <button id="submit" type="submit" class="btn" value="${list.idList}" name="idList">Edit</button>
                    </td>
                </div1>
            </tr>
        </c:forEach>
    </form>

</table>

<form action="/report" method="GET">
    <input type="hidden" name="idUser" value="${idUser}">
    <button id="wReport" type="submit" class="btn" value="WEEKLY" name="type">Weekly Report</button>
    <button id="mReport" type="submit" class="btn" value="MONTHLY" name="type">Montly Report</button>
</form>

</body>

</html>