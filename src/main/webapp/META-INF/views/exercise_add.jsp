<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>New exercise form</title>
</head>
<body>

<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="/exercises">Exercises</a>
    </li>
    <li class="breadcrumb-item active">New exercise</li>
</ol>
<div class="container">
    <div class="text-center">
        <h1>Add new exercise</h1>
    </div>
    <form method="post" action="/addExercise">
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="Title">
            <label for="description">Description</label>
            <input type="text" class="form-control" id="description" name="description" placeholder="Description">
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