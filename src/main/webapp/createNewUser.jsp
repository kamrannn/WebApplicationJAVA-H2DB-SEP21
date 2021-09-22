<%--
  Created by IntelliJ IDEA.
  User: kamranabbasi
  Date: 9/22/2021
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> User Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
        </ul>
    </nav>
</header>
<br>
<form action="<%=request.getContextPath()%>/insert" method="post">
    <p>FirstName.
        <input type="text" name="firstname"/></p>
    <p>LastName.
        <input type="text" name="lastName"/></p>
    <p>Email.
        <input type="text" name="email"/></p>
    <p>Age.
        <input type="text" name="age"/></p>
    <p>Gender.
        <input type="text" name="gender"/></p>
    <p>PhoneNo.
        <input type="text" name="phoneNo"/></p>
    <p>Address.
        <input type="text" name="address"/></p>
    <p>Submit button.
        <input type="submit" name="submit" value="submit"/></p>
</form>
</body>

</html>