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
<%--@elvariable id="newParam" type="com.pokorili.musicOn.entity.Parametrs"--%>
<form:form method="post" action="/addParametrs" modelAttribute="newParam">
    <form:input type="hidden" path="users" value ="<%=user%>"/>
    <label>
        Age:
        <form:input type="text" path="age"/>
    </label>
    <label>
        Height:
        <form:input type="text" path="height"/>
    </label>
    <label>
        Weight:
        <form:input type="text" path="weight"/>
    </label>
    <label>
        Gender:
        <form:select path="gender" size="2">
            <form:option selected="1" value="m" >Male</form:option>
            <form:option  value="w" >Female</form:option>

        </form:select>
    </label>
    <input type="submit" value="Add"/>
</form:form>

</body>