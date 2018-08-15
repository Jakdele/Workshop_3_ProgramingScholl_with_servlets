<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>New user form</title>
</head>
<body>

<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="/users">Users</a>
    </li>
    <li class="breadcrumb-item active">New user</li>
</ol>
<div class="container">
    <div class="text-center">
        <h1>Add new user</h1>
    </div>
    <form method="post" action="/addUser">
        <div class="form-group">
            <label for="name">Username</label>
            <input type="text" class="form-control" id="name" name="username" placeholder="Username">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Email">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            <label for="user-group">Group</label>
            <select class="custom-select" id="user-group" name="group-id">
                <c:forEach items="${groups}" var="group">
                    <option value="${group.id}">${group.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="text-center">
            <input class="btn btn-primary btn-block-short" type="submit" value="Add" name="confirm">
            <input class="btn btn-primary btn-block-short" type="submit" value="Cancel" name="confirm">
        </div>
    </form>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>