<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

</head>

<style>


</style>

<body>

<form action="/goal" method="POST">
    <input type="hidden" name="idUser" value="${idUser}">
    <label for="goall">Set new goal in calories/day</label>
    <input type="number" min="0" step="1" id="goall" name="goall" value=0>

    <button id="submit" type="submit" class="btn" value="setGoal">Submit Goal</button>
</form>

<p>You should eat today: ${caloriesToday}</p>
<p>Your current goal is: ${goal}</p>

<p>Will be waste? ${waste}</p>

<form action="/groceryList" method="GET">
    <input type="hidden" name="idUser" value="${idUser}">
    <button id="skip" type="skip" class="btn" value="skip">Skip</button>
</form>

</body>
</html>