<%--@elvariable id="daillyMenu" type="com.pokorili.musicOn.entity.DaillyMenu"--%>
<%--@elvariable id="programm" type="com.pokorili.musicOn.entity.WeeklyDiet"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <title>MusicOn</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"/>

</head>

<body>
<%@include file="header.jsp" %>
<style>
    .mainContent {
        margin-top: 20px;
    }

    .changeButton {
        color: white;
        text-decoration: none;
        padding: 12px 15px;
        font-weight: 500;
        border-radius: 10px;
        background: #2e197b;
        border: none;
        margin: 20px;

    }

    .head {
        background: #2e197b;
        color: white;
        text-align: center;
        font-size: 22px;
        padding-top: 5px;
        padding-bottom: 5px;
        font-weight: 500;
        border-top-left-radius: 45px;
        border-top-right-radius: 45px;
    }

    .left {
        display: inline-block;
        width: 50%;
        float: left;
    }

    .right {
        display: inline-block;
        width: 49%;
        float: left;
    }

    .inner {
        margin: 0 20px;
        border: 2px solid gainsboro;
        border-radius: 45px;
        text-align: center;

    }

    @media screen and (max-width: 1086px) {
        .left, .right {
            display: block;
            width: 100%;
            float: left;
            margin-bottom: 30px;

        }

        .mainContent {

            height: 100%;
        }
    }

    .info-block {
        color: #00b900;
    }
    .userInfo {
        margin: 30px 20px;



    }
</style>
<div class="mainContent">
    <div class="info-block">
        <p>${infoMessage}</p>
    </div>


    <div class="jumbotron ">
        <h1 class="display-4">Programm name: ${programm.name}</h1>
        <h2 class="display-3">Description: ${programm.description}</h2>
        <hr class="my-4">
        <h3 class="lead">Author: ${programm.author}</h3>
    </div>

    <div class="inner">
        <div class="head">Select Day's Meal</div>
        <div class="allMyMealsDish userInfo">
            <%--@elvariable id="meals" type="com.pokorili.musicOn.entity.Meal[]"--%>
            <c:forEach items="${meals}" var="meal">

                <a  href="/activeMeal/${programm.id}/${meal.id}/" style="padding: auto; margin: 30px">${meal.name} </a>

            </c:forEach>
        </div>
    </div>
    <div class="addMeal mainContent" align="center">
        <a class="changeButton" href="/addMeal/${programm.id}/${daillyMenu.id}">Add Meal</a>

    </div>


</div>
</body>

</html>