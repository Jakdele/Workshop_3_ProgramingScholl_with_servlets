<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>User details</title>
</head>
<body>

<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="/users">Users</a>
    </li>
    <li class="breadcrumb-item active">User ${user.id}</li>
</ol>

<div class="text-center">
    <h1>User ${user.id}</h1>
</div>
<div>
    <table class="table table-bordered" width="100%" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th>Username</th>
            <th>Email</th>
            <th>Password</th>
            <th>Usergroup id</th>
        </tr>
        </thead>
        <tbody>

        <tr>
            <td>${user.id}</td>
            <td>${user.username} </td>
            <td>${user.email} </td>
            <td>${user.user_group_id} </td>
        </tr>

        </tbody>
    </table>
</div>
<hr>
<div class="text-center">
    <h2>User ${user.id} solutions</h2>
</div>
<div>
    <table class="table table-bordered" width="100%" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th>Created</th>
            <th>Updated</th>
            <th>Description</th>
            <th>Assigned to</th>
            <th>Exercise</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="solution" items="${solutions}">
            <tr>
                <td><a href="<c:url value="/solutionDetails"/>?solution.id=${solution.id}"> ${solution.id} </a></td>
                <td> ${solution.created} </td>
                <td> ${solution.updated} </td>
                <td> ${solution.description} </td>
                <td> ${solution.exercise_id} </td>
                <td> ${solution.users_id} </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<hr>
<div class="text-center">
    <a class="btn btn-primary btn-block-short" href="<c:url value="/userDelete"/>?user.id=${user.id}"> Delete user</a>
    <a class="btn btn-primary btn-block-short" href="<c:url value="/editUser"/>?user.id=${user.id}">Edit user</a>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>