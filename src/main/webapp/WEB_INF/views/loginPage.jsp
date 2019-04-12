<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8"%>
<html>

<head>
    <title>MusicOn</title>
    <meta charset="UTF-8"/>
    <style>
        .login-form {
            width: 500px;
            margin: 100px auto;
            border: 2px solid darkgray;
            border-radius: 5px;
        }
        .inputField {
            margin: 20px;
        }
        .red {
            color:red;
        }
    </style>
</head>

<body>
<%@include file="header.jsp"%>
<div class="login-form" align="center">
    <%--@elvariable id="user" type="com.pokorili.musicOn.entity.Users"--%>
    <form:form method="post" action="/login" modelAttribute="user">
        <div class="inputField">
            <label>
                Login
                <form:input type="text" path="login"/>
            </label>
        </div>
        <div class="inputField">
            <label>
                Password
                <form:input type="password" path="password"/>
            </label>
        </div>
        <div class="inputField">
            <p class="red">${errMessage}</p>
        </div>
        <div class="inputField">
            <a href="/resetPassword">Reset Password</a>
        </div>
        <div class="inputField">
            <input type="submit" value="Login">
        </div>
    </form:form>
</div>
</body>

</html>