<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>
    <title>Java Trainees Management App</title>
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
<li><a href="<%=request.getContextPath()%>/list" class="btn btn-success" style="align-items: center">Trainees List</a>
</li>
</body>

</html>