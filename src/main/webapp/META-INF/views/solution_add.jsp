<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="default/header.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<body>
<div class="text-center">
    <h2>Assign task to a user</h2>
</div>
<div class="container">
    <form action="/addSolution" method="post">
        <div class="form-group">
            <div class="text-center">
                <label for="user-id">User Id</label>
                <select id="user-id" name="userId">
                    <c:forEach items="${users}" var="user">
                        <option value="${user.id}">${user.username}</option>
                    </c:forEach>
                </select>

            </div>

            <div class="text-center">
                <label for="exercise-id">Exercise Id</label>

                <select id="exercise-id" name="exerciseId">
                    <c:forEach items="${exercises}" var="exercise">
                        <option value="${exercise.id}">${exercise.title}</option>
                    </c:forEach>
                </select>

            </div>
        </div>
        <div class="text-center">
            <input lass="btn btn-primary btn-block-short" type="submit" value="Assign">
        </div>
        <%--<a class="btn btn-primary btn-block" href="login.html">Register</a>--%>
    </form>
</div>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>


</body>
</body>
</html>
<%@include file="default/footer.jsp" %>