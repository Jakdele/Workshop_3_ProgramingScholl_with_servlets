<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Programming School</title>
    <link href="../../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../vendor/bootstrap/css/bootstrap-grid.min.css" rel="stylesheet">
    <link href="../../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="../../vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
    <link href="../../css/sb-admin.css" rel="stylesheet">
    <link href="../../css/style.css" rel="stylesheet">
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
                <td><c:out value="${solution.id}"></c:out></td>
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


<%@include file="default/footer.jsp" %>