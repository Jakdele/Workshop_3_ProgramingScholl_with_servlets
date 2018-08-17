<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="userPanel/header.jsp" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<h3 class="text-center">Programming School App</h3>

<div class="text-center">
    <a class="btn btn-primary btn-block-short" href="/home">Work as an administrator</a>
    <br>
    <hr>
</div>
<div class="container" >
    <div class="text-center">

        <form method="post" action="/userPanel">
            <div class="form-group">
                <label for="title">Enter your Id</label>
                <br>
                <input type="number" class="form-control-input" id="title" name="user-id" placeholder="Id">
                <br>
                <input class="btn btn-primary btn-block-short" type="submit" value="Log in" name="confirm">
            </div>

        </form>
    </div>
</div>

<%@include file="userPanel/footer.jsp" %>