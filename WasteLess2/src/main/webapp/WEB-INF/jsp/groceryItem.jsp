<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

</head>

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

    h1{
        color: red;
    }

</style>
<body>

<form method="post" action="/groceryItems">
    <div1>
        <h2>Introduce items for the grocery list ${listName}</h2>
        <h1>${errorMessage}</h1>
    </div1>
    <input type="hidden" name="idList" value=${idList}>
    <input type="hidden" name="listName" value=${listName}>

    <label for="iname">Item name </label>
    <input type="text" id="iname" name="iname" value=""><br><br>

    <label for="quantity">Quantity </label>
    <input type="text" id="quantity" name="quantity" value=""><br><br>

    <label for="calories">Calories </label>
    <input type="text" id="calories" name="calories" value=""><br><br>

    <label for="pDate">Purchase Date</label>
    <input type="text" id="pDate" name="pDate" value=""><br><br>

    <label for="eDate">Expiration Date </label>
    <input type="text" id="eDate" name="eDate" value=""><br><br>

    <label for="cDate">Consumption Date </label>
    <input type="text" id="cDate" name="cDate" value=""><br><br>

    <input type="submit" value="Submit">
</form>

<table>
    <tr>
        <th>Item Name</th>
        <th>Quantity</th>
        <th>Calories</th>
        <th>Purchase Date</th>
        <th>Expiration Date</th>
        <th>Consumption Date</th>
    </tr>

    <form method="post" action="/groceryItems/donate">
        <input type="hidden" name="idList" value="${idList}">
        <input type="hidden" name="listName" value="${listName}">
        <c:forEach items="${items}" var="item">
            <tr>
                <div1>
                    <td>${item.name}</td>
                    <td>${item.quantity}</td>
                    <td>${item.calories}</td>
                    <td>${item.purchaseDate}</td>
                    <td>${item.expirationDate}</td>
                    <td>${item.consumptionDate}</td>
                    <td>
                        <button id="submit" type="submit" class="btn" value="${item.idItem}" name="idItem">Donate</button>
                    </td>
                </div1>
            </tr>
        </c:forEach>
    </form>

</table>

</body>
</html>