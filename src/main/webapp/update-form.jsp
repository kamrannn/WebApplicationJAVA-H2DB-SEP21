<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kamranabbasi
  Date: 9/23/2021
  Time: 11:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Java Trainee Management</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="http://localhost:8081/FirstWebApplicationJAVA_war_exploded/" class="navbar-brand"> Java Trainees
                Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/" class="nav-link">Home</a></li>
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Trainees List</a></li>
        </ul>
    </nav>
</header>
<br>
<form action="<%=request.getContextPath()%>/update" method="post">
    <input value="<c:out value='${javaTrainees.id}' />" type="hidden" name="id"/>
    <p>FirstName.
        <input value="<c:out value='${javaTrainees.firstName}' />" type="text" name="firstname"/></p>
    <p>LastName.
        <input value="<c:out value='${javaTrainees.lastName}' />" type="text" name="lastName"/></p>
    <p>Email.
        <input value="<c:out value='${javaTrainees.email}' />" type="text" name="email"/></p>
    <p>Age.
        <input value="<c:out value='${javaTrainees.age}' />" type="text" name="age"/></p>
    <p>Gender.
        <input value="<c:out value='${javaTrainees.gender}' />" type="text" name="gender"/></p>
    <p>PhoneNo.
        <input value="<c:out value='${javaTrainees.phoneNo}' />" type="text" name="phoneNo"/></p>
    <p>Address.
        <input value="<c:out value='${javaTrainees.address}' />" type="text" name="address"/></p>
    <p>Submit button.
        <input type="submit" name="submit" value="submit"/></p>
</form>
</body>
</html>
