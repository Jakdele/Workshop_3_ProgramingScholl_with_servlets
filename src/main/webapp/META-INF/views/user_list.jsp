<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Users list</title>
</head>
<body>
<div>
    <table class="table table-bordered" width="100%" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th>Username</th>
            <th>Email</th>
            <th>Password (hashed)</th>
            <th>Usergroup id</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><a href="<c:url value="/userDetails"/>?user.id=${user.id}"> ${user.id} </a></td>
                <td> ${user.username} </td>
                <td> ${user.email} </td>
                <td> ${user.password} </td>
                <td> ${user.user_group_id}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="text-center">
    <a class="btn btn-primary btn-block-short" href="/addUser">Add a new user</a>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>