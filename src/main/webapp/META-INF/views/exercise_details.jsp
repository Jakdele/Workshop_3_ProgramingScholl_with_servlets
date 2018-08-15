<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Exercise details</title>
</head>
<body>

<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="/exercises">Exercises</a>
    </li>
    <li class="breadcrumb-item active">Exercise ${exercise.id}</li>
</ol>

<div class="text-center">
    <h1>Exercise ${exercise.id}</h1>
</div>
<div>
    <table class="table table-bordered" width="100%" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>${exercise.id}</td>
                <td>${exercise.title} </td>
                <td>${exercise.description} </td>
            </tr>
        </tbody>
    </table>
</div>
<div class="text-center">
    <a class="btn btn-primary btn-block-short" href="<c:url value="/deleteExercise"/>?exercise.id=${exercise.id}"> Delete exercise</a>
    <a class="btn btn-primary btn-block-short" href="<c:url value="/editExercise"/>?exercise.id=${exercise.id}">Edit exercise</a>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>