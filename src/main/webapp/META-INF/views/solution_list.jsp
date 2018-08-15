<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Solutions list</title>
</head>
<body>
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
                <td> ${solution.users_id} </td>
                <td> ${solution.exercise_id} </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="text-center">
    <a class="btn btn-primary btn-block-short" href="/addSolution">Add a new solution</a>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>