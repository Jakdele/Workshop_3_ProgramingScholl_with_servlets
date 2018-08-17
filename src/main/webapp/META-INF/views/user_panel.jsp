<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="userPanel/header.jsp" %>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<c:if test="${not empty allUserSolutions}">
    <div class="text-center">
        <h3>Your assignments list</h3>
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
        <c:forEach var="solution" items="${allUserSolutions}">
            <tr>
                <td> ${solution.id}</td>
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
</c:if>
<c:if test="${not empty unsolved}">
    <div class="text-center">
        <h3>Your unsolved exercises</h3>
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
            <c:forEach var="solution" items="${unsolved}">
                <tr>
                    <td> ${solution.id} </td>
                    <td> ${solution.created} </td>
                    <td> ${solution.updated} </td>
                    <td> ${solution.description} </td>
                    <td> ${solution.exercise_id} </td>
                    <td> ${solution.users_id} </td>
                    <td><a class="btn btn-primary btn-block-short" href="<c:url value="/userEditSolution"/>?solution-id=${solution.id}"> Edit </a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>
<c:if test="${empty unsolved}">
    <div class="text-center">
        <h3>You have no pending exercises</h3>
    </div>
</c:if>
<%@include file="userPanel/footer.jsp" %>