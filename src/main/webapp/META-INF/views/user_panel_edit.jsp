<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="userPanel/header.jsp" %>
<html>
<head>
    <title>Edit Solution</title>
</head>
<body>

<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="/userPanel">Your panel</a>
    </li>
    <li class="breadcrumb-item active">Solution ${solutionId}</li>
</ol>
<div class="container">

    <form method="post" action="/userEditSolution">
        <div class="form-group">
            <label for="name">Description</label>
            <input type="text" class="form-control" id="name" name="description" placeholder="Enter exercise solution here">
        </div>
        <div class="text-center">
            <input class="btn btn-primary btn-block-short" type="submit" value="Edit" name="confirm">
            <input class="btn btn-primary btn-block-short" type="submit" value="Cancel" name="confirm">
            <input type="hidden" name="solution-id" value="${solutionId}">
        </div>
    </form>
</div>
</body>
</html>
<%@include file="userPanel/footer.jsp" %>