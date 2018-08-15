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
        <a href="/userGroups">Usergroups</a>
    </li>
    <li class="breadcrumb-item active">New usergroup ${id}</li>
</ol>
<div class="container">
    <div class="text-center">
        <h1>Add usergroup</h1>
    </div>
    <form method="post" action="/addGroup">
        <div class="form-group">
            <label for="title">Name</label>
            <input type="text" class="form-control" id="title" name="name" placeholder="name">
        </div>

        <div class="text-center">
            <input class="btn btn-primary btn-block-short" type="submit" value="Add" name="confirm">
            <input class="btn btn-primary btn-block-short" type="submit" value="Cancel" name="confirm">
            <input type="hidden" name="group-id" value="${id}">
        </div>
    </form>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>