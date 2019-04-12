<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <title>MusicOn</title>
    <meta charset="UTF-8"/>
    <style>
        .inputField {
            margin: 20px;
        }
        .input-form {
            width: 500px;
            margin: 100px auto;
            border: 2px solid darkgray;
            border-radius: 5px;
        }
        .red {
            color:red;
        }
    </style>
</head>

<body>
<%@include file="header.jsp" %>

<div class="input-form" align="center">
    <%--@elvariable id="newUser" type="com.pokorili.musicOn.entity.Users"--%>
    <form:form action="/resetPassword" method="post" modelAttribute="newUser">
        <div class="inputField">
            <label>Enter your email:
            <form:input type="email" path="email"/>
            </label>
        </div>
        <div class="inputField">
            <p class = "red">${errMessage}</p>
        </div>
        <div class="inputField">
            <input type="submit" value="Request new password "/>
        </div>
    </form:form>
</div>
</body>
</html>