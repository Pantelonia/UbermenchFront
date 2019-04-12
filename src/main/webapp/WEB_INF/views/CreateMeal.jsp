<%@ page import="com.pokorili.musicOn.entity.DaillyMenu" %>
<%@ page import="com.pokorili.musicOn.entity.Meal" %>
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
            border: 1px solid darkgray;
            border-radius: 45px;
            height: auto;
        }
        .inputField {
            margin: 20px;
        }
        .red {
            color:red;
        }
        .head{
            background: #2e197b;
            color: white;
            text-align: center;
            font-size: 22px;
            padding-top: 20px;
            padding-bottom: 20px;
            font-weight: 500;

            border-top-left-radius: 45px;
            border-top-right-radius: 45px;
        }

        input[type=text] {
            width: 100%;
            font-size: 18px;
            padding: 12px 16px;
            margin: 8px 0;
            box-sizing: border-box;
        }

        input[type=password] {
            width: 100%;
            font-size: 18px;
            padding: 12px 16px;
            margin: 8px 0;
            box-sizing: border-box;
        }

        .butt{
            background: #2e197b;
            border-radius: 25px;
            width: 100%;
            color: white;
            border: none;
            font-size: 16px;
            padding: 20px 0;
        }

    </style>
</head>
<body>
<%@include file="header.jsp"%>
<%--@elvariable id="newMeal" type="com.pokorili.musicOn.entity.Meal"--%>
<div class="login-form" align="left">
    <div class="head">
        Add meal's name
    </div>
    <form action="/addMeal/${programm_id}/${day_id}" method="post" >
        <input class="inputField" type ="text" name="name"/>
        <input class="butt" type="submit" value="add">
    </form>
</div>





</body>