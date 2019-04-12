<%--@elvariable id="meal" type="com.pokorili.musicOn.entity.Meal"--%>
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
        /*font-weight: 500;*/
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

    .rightin {
        display: inline-block;
        width: 50%;
        float: left;
    }

    .inner {
        margin: 0 20px;
        border: 2px solid gainsboro;
        border-radius: 45px;
        text-align: center;

    }

    @media screen and (max-width: 1086px) {
        .left, .rightin {
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


    <div class="head">Meal's name ${meal.name}</div>
    <div class="addDish userInfo "  align="center">
        <a class="changeButton" href="/chooseMyDish/${meal.id}">Add Dish</a>

    </div>
    <div class="allMyMealsDish userInfo">
        <%--@elvariable id="dishes" type="com.pokorili.musicOn.entity.Dish[]"--%>
        <c:forEach items="${dishes}" var="dish">

            <div class="rightin mainContent">
                <div class="inner">
                    <div class="head">Name ${dish.name}</div>
                    <p style="padding: auto; margin: 30px">description ${dish.description} </p>

                    <p style="padding: auto; margin: 30px">kkal ${dish.kkal} </p>

                    <p style="padding: auto; margin: 30px">protein ${dish.protein} </p>

                    <p style="padding: auto; margin: 30px">carbohydrates ${dish.carbohydrates} </p>

                    <p style="padding: auto; margin: 30px">fat ${dish.fat} </p>

                    <p style="padding: auto; margin: 30px">type_dish ${dish.type_dish} </p>

                </div>

            </div>


        </c:forEach>

    </div>


</div>
</body>

</html>