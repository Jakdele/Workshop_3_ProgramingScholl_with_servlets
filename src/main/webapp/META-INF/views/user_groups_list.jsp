<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Usergroups list</title>
</head>
<body>
<div>
    <table class="table table-bordered" width="100%" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="group" items="${groups}">
            <tr>
                <td><a href="<c:url value="/groupDetails"/>?group.id=${group.id}"> ${group.id} </a></td>
                <td> ${group.name} </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="text-center">
    <a class="btn btn-primary btn-block-short" href="/addGroup">Add new usergroup</a>
</div>
</body>
</html>
<%@include file="default/footer.jsp" %>