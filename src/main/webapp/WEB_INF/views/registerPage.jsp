<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8"%>
<html>

<head>
    <title>MusicOn</title>
    <meta charset="UTF-8"/>
    <style>
        .register-form {
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
<div class="register-form" align="center">
    <%--@elvariable id="newUser" type="com.pokorili.musicOn.entity.Visitor"--%>
    <form:form method="post" action="/register" modelAttribute="newUser">
        <div class="inputField">
            <label>
                Email
                <form:input type="text" path="email"/>
            </label>
        </div>
        <div class="inputField">
            <label>
                Nickname
                <form:input type="text" path="login"/>
            </label>
        </div>
        <div class="inputField">
            <p class="red">${errMessage}</p>
        </div>
        <div class="inputField">
            <label>
                Password
                <form:input type="password" path="password"/>
            </label>
        </div>
        <div class="inputField">
            <input type="submit" value="Login">
        </div>
    </form:form>
</div>
</body>

</html>