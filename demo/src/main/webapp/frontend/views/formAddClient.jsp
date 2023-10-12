<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 09/10/2023
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add client</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontend/style/style.css">

    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
</head>
<body>

<%-- Display the error message --%>
<% if (request.getAttribute("errorMessage") != null) { %>
<div class="error-message-add" id="error-container">
    <%= request.getAttribute("errorMessage") %>
</div>
<% } %>
<div class="center-container">
    <div class="form-container">
    <h2 style="text-align:center;">Add Client</h2>
    <form action="${pageContext.request.contextPath}/client-servlet" method="post" class="custom-form">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="prenoun">Prenoun:</label>
            <input type="text" id="prenoun" name="prenoun" required>

        </div>
        <div class="form-group">
            <label for="birthdate">Birthdate:</label>
            <input type="date" id="birthdate" name="birthdate" required>
        </div>
        <div class="form-group">
            <label for="phone">Phone:</label>
            <input type="tel" id="phone" name="phone" required>
        </div>
        <div class="form-group">
            <label for="adresse">Address:</label>
            <input type="text" id="adresse" name="adresse" required>
        </div>
        <button type="submit" class="buttonminibar" >Add Client</button>
    </form>
</div >

</div>


<script>
    setTimeout(function () {
        var errorContainer = document.getElementById("error-container");
        if (errorContainer) {
            errorContainer.style.display = "none";
        }
    }, 10000);
</script>
</body>
</html>



































