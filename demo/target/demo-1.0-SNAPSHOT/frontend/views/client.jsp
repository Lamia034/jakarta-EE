<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 09/10/2023
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="../style/style.css">
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
</head>
<body>
<!--navbar-->
<!--header-->
<header class="bg">
    <a href="#" ><img src="../images/banklogo.png" style="width: auto ; height: 50px;" alt=""></a>

    <ul class="navbar" >
        <li><a href="" >Home</a></li>
        <li><a href="" >Employee space</a></li>
        <li><a href="client.jsp" >Client space</a></li>

    </ul>
</header>





<!-- component -->
<div class="button-container">
    <a  href="formAddClient.jsp"><button class="buttonminibar">Add new client</button></a>
    <a href="${pageContext.request.contextPath}/client-servlet"><button class="buttonminibar">List clients</button></a>

    <button class="buttonminibar">Search for a client</button>
</div>

</body>
</html>
