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

    h1 {
        color: deeppink;
    }

</style>
<body>

<form method="get" action="/groceryList">
    <input type="hidden" name="idUser" value="${idUser}">
    <input type="submit" value="back">
</form>

<h1>${type} Report</h1>
<p>Purchased items: ${nbPurchasedItems}</p><br>

<table>
    <tr>
        <th>Item Name</th>
        <th>Quantity</th>
        <th>Calories</th>
        <th>Purchase Date</th>
        <th>Expiration Date</th>
        <th>Consumption Date</th>
    </tr>

    <c:forEach items="${purchasedItems}" var="item">
        <tr>
            <div1>
                <td>"${item.name}"</td>
                <td>"${item.quantity}"</td>
                <td>"${item.calories}"</td>
                <td>"${item.purchaseDate}"</td>
                <td>"${item.expirationDate}"</td>
                <td>"${item.consumptionDate}"</td>
            </div1>
        </tr>
    </c:forEach>
</table>

<br><p>Number of consumed calories: ${nbConsumedCalories}</p><br>
<br><p>Number of wasted calories: ${nbWastedCalories}</p><br>

<table>
    <tr>
        <th>Item Name</th>
        <th>Quantity</th>
        <th>Calories</th>
        <th>Purchase Date</th>
        <th>Expiration Date</th>
        <th>Consumption Date</th>
    </tr>

    <c:forEach items="${wastedItems}" var="item">
        <tr>
            <div1>
                <td>"${item.name}"</td>
                <td>"${item.quantity}"</td>
                <td>"${item.calories}"</td>
                <td>"${item.purchaseDate}"</td>
                <td>"${item.expirationDate}"</td>
                <td>"${item.consumptionDate}"</td>
            </div1>
        </tr>
    </c:forEach>
</table>

</body>
</html>