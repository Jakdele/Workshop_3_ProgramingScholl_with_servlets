<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Group details</title>
</head>
<body>

<ol class="breadcrumb">
    <li class="breadcrumb-item">
        <a href="/userGroups">Groups</a>
    </li>
    <li class="breadcrumb-item active">Group ${group.id}</li>
</ol>

<div class="text-center">
    <h1>Group ${group.id}</h1>
</div>
<div>
    <table class="table table-bordered" width="100%" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>${group.id}</td>
                <td>${group.name} </td>
            </tr>
        </tbody>
    </table>
</div>
<div class="text-center">
    <a class="btn btn-primary btn-block-short" href="<c:url value="/deleteGroup"/>?group.id=${group.id}"> Delete group</a>
    <a class="btn btn-primary btn-block-short" href="<c:url value="/editGroup"/>?group.id=${group.id}">Edit group</a>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>