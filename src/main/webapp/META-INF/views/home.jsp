<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Programming School</title>
</head>
<h1>Programming School App</h1>
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
        <c:forEach var="solution" items="${lastFive}">
            <tr>
                <td><a href="<c:url value="/solutionDetails"/>?solution.id=${solution.id}"> ${solution.id} </a></td>
                <td> ${solution.created} </td>
                <td> ${solution.updated} </td>
                <td> ${solution.description} </td>
                <td> <a href="<c:url value="/exerciseDetails"/>?exercise.id=${solution.exercise_id}"> ${solution.exercise_id} </a></td>
                <td> <a href="<c:url value="/userDetails"/>?user.id=${solution.users_id}"> ${solution.users_id} </a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>



<%@include file="default/footer.jsp" %>