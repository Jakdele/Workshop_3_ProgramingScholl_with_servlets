<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Exercises administration panel</title>
</head>
<body>
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
        <c:forEach var="exercise" items="${exercises}">
            <tr>
                <td><a href="<c:url value="/exerciseDetails"/>?exercise.id=${exercise.id}"> ${exercise.id} </a></td>
                <td> ${exercise.title} </td>
                <td> ${exercise.description} </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
<div class="text-center">
    <a class="btn btn-primary btn-block-short" href="/addExercise">Add a new exercise</a>
</div>
<%@include file="default/footer.jsp" %>