<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Solution details</title>
</head>
<body>

<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="/solutions">Solutions</a>
    </li>
    <li class="breadcrumb-item active">Solution ${solution.id}</li>
</ol>

<div class="text-center">
    <h1>Solution ${solution.id}</h1>
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

        <tr>
            <td>${solution.id}</td>
            <td> ${solution.created} </td>
            <td> ${solution.updated} </td>
            <td> ${solution.description} </td>
            <td> ${solution.users_id} </td>
            <td> ${solution.exercise_id} </td>
        </tr>

        </tbody>
    </table>
</div>
<div class="text-center">
    <a class="btn btn-primary btn-block-short" href="<c:url value="solutionDelete"/>?solution.id=${solution.id}"> Delete solution</a>
    <a class="btn btn-primary btn-block-short" href="/editSolution">Edit solution</a>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>