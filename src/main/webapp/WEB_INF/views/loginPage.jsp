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
    </style>
</head>

<body>
<%@include file="header.jsp"%>
<div class="login-form" align="center">
    <%--@elvariable id="user" type="com.pokorili.musicOn.entity.Visitor"--%>
    <form method="post" action="/">
        <div class="inputField">
            <label>
                Login
                <input type="text" name="nickname"/>
            </label>
        </div>
        <div class="inputField">
            <label>
                Password
                <input type="password" name="password"/>
            </label>
        </div>
        <div class="inputField">
            <input type="submit" value="Login">
        </div>
    </form>
</div>
</body>

</html>