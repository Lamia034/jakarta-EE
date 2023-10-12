<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 12/10/2023
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>edit client</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontend/style/style.css">

    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
</head>
<body>
<div class="center-container">
    <div class="form-container">
        <h2 style="text-align:center;">Edit Client</h2>
        <form action="${pageContext.request.contextPath}/client-servlet" method="post" class="custom-form">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" value="${existingClient.name}" required>
            </div>
            <div class="form-group">
                <label for="prenoun">Prenoun:</label>
                <input type="text" id="prenoun" name="prenoun" value="${existingClient.prenoun}" required>
            </div>
            <div class="form-group">
                <label for="birthdate">Birthdate:</label>
                <input type="date" id="birthdate" name="birthdate" value="${existingClient.birthDate}" required>
            </div>
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="tel" id="phone" name="phone" value="${existingClient.phone}" required>
            </div>
            <div class="form-group">
                <label for="adresse">Address:</label>
                <input type="text" id="adresse" name="adresse" value="${existingClient.adresse}" required>
            </div>
            <input type="hidden" name="clientId" value="${existingClient.code}">
            <button type="submit" class="buttonminibar">Update Client</button>
        </form>

    </div >

</div>
</body>
</html>
