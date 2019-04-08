<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8"%>
<html>

<head>
    <title>MusicOn</title>
    <meta charset="UTF-8"/>
    <style>
        .input-form {
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

<div class="input-form" align="center">
    <%
        String setting = (String) request.getAttribute("setting");
        if (setting.equals("email")) {
    %>
    <%--@elvariable id="newUser" type="com.pokorili.musicOn.entity.Visitor"--%>
    <form:form method="post" action="/changeEmail" modelAttribute="newUser">

        <div class="inputField">
            <label>
                Email
                <form:input type="email" path="email"/>
            </label>
        </div>
        <div class="inputField">
            <p class = "red">${errMessage}</p>
        </div>
        <div class="inputField">
            <input type="submit" value="Change email">
        </div>
    </form:form>
        <%
                } else {
            if (setting.equals("nickname")) {
                %>
    <form:form method="post" action="/changeNickname" modelAttribute="newUser">

        <div class="inputField">
            <label>
                Nickname
                <form:input type="text" path="nickname"/>
            </label>
        </div>
        <div class="inputField">
            <p class = "red">${errMessage}</p>
        </div>
        <div class="inputField">
            <input type="submit" value="Change nickname">
        </div>
    </form:form>
    <%
            } else {
                %>
    <form:form method="post" action="/changePassword" modelAttribute="newUser">

        <div class="inputField">
            <label>
                Old password
                <form:input type="password" path="email"/>
            </label>
        </div>
        <div class="inputField">
            <p class = "red">${errMessage}</p>
        </div>
        <div class="inputField">
            <label>
                New password
                <form:input type="password" path="nickname"/>
            </label>
        </div>
        <div class="inputField">
            <label>
                Repeat password
                <form:input type="password" path="password"/>
            </label>
        </div>

        <div class="inputField">
            <input type="submit" value="Change password">
        </div>
    </form:form>
    <%
            }
                }
        %>
</div>
</body>

</html>