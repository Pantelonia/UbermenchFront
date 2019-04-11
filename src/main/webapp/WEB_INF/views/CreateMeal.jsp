<%@ page import="com.pokorili.musicOn.entity.DaillyMenu" %>
<%@ page import="com.pokorili.musicOn.entity.Meal" %>
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
<%--@elvariable id="newMeal" type="com.pokorili.musicOn.entity.Meal"--%>


<form action="/addMeal/${programm_id}" method="post" >
    <input type ="text" name="name"/>
    <input type="submit" value="add">
</form>



</body>