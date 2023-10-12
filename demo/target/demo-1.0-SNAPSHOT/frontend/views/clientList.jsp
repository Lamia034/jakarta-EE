<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 12/10/2023
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clients' list</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/frontend/style/style.css">
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
</head>
<body>
<header class="bg">
    <div style="display: flex;" >
        <a href="#" ><img src="frontend/images/banklogo.png" style="width: auto ; height: 50px;" alt="">
        </a>
        <span style="display: flex; align-items: center; justify-content: center;text-align: center;font-weight: 700;">Easy</span>
    </div>

    <ul class="navbar" >
        <li><a href="" >Home</a></li>
        <li><a href="" >Employee space</a></li>
        <li><a href="frontend/views/client.jsp" >Client space</a></li>

    </ul>
</header>
<h2 style="text-align: center;">Client List</h2>
<%-- Display the success message --%>
<% if (request.getAttribute("successMessage") != null) { %>
<div class="success-message-add" id="success-container">
    <%= request.getAttribute("successMessage") %>
</div>
<% } %>


<table class="tablelist" style="margin: 0 auto;">
    <tr>
        <th>Client ID</th>
        <th>Name</th>
        <th>Prenoun</th>
        <th>Phone</th>
        <th>Birth Date</th>
        <th>Adresse</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${clientList}" var="client">
        <tr>
            <td>${client.code}</td>
            <td>${client.name}</td>
            <td>${client.prenoun}</td>
            <td>${client.phone}</td>
            <td>${client.birthDate}</td>
            <td>${client.adresse}</td>
            <td>
                <a href="${pageContext.request.contextPath}/frontend/views/formEditClient.jsp?clientId=${client.code}">
                    <button class="editb">Edit</button>
                </a>

                <a href="${pageContext.request.contextPath}/client-servlet?clientId=${client.code}"><button class="deleteb">Delete</button></a>
            </td>
        </tr>
    </c:forEach>
</table>


<script>
    setTimeout(function () {
        var successContainer = document.getElementById("success-container");
        if (successContainer) {
            successContainer.style.display = "none";
        }
    }, 10000);
</script>
</body>
</html>
