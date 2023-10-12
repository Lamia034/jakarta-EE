<%@ page import="com.sun.jdi.connect.spi.Connection" %>
<%@ page import="backend.helper.DatabaseConnection" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="frontend/style/style.css">
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
</head>
<body>
<!--navbar-->
<!--header-->
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

<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet" class="text-red-500">Hello Servlet</a>


<script type="text/javascript" src="frontend/js/script.js" defer></script>

</body>

</html>