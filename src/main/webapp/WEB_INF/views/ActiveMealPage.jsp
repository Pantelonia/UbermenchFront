<%--@elvariable id="meal" type="com.pokorili.musicOn.entity.Meal"--%>
<%--@elvariable id="programm" type="com.pokorili.musicOn.entity.WeeklyDiet"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <title>MusicOn</title>
    <meta charset="UTF-8"/>

    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body>
<%@include file="header.jsp" %>
<style>
    .userInfo {
        margin: 30px;
    }

    .nickname {

        color: #41435b;
        margin: 20px;
    }

    .email {
        margin: 20px;
    }

    .changeButton {
        padding: 5px;
        border: 2px solid #41435b;
    }

    .info-block {
        color: #00b900;
    }
</style>
<div class="mainContent">
    <div class="info-block">
        <p>${infoMessage}</p>
    </div>

    <div>
        <h1>Name: ${programm.name}</h1>
        <h2>Description: ${programm.description}</h2>
        <h3>Author: ${programm.author}</h3>
    </div>

    <div>Meal's name ${meal.name}</div>


    <div class="allMyMealsDish">
        <%--@elvariable id="dishes" type="com.pokorili.musicOn.entity.Dish[]"--%>
        <c:forEach items="${dishes}" var="dish">

            <h3><p style="padding: auto; margin: 30px">Name ${dish.name} </p></h3>

            <p style="padding: auto; margin: 30px">description ${dish.description} </p>

            <p style="padding: auto; margin: 30px">kkal ${dish.kkal} </p>

            <p style="padding: auto; margin: 30px">protein ${dish.protein} </p>

            <p style="padding: auto; margin: 30px">carbohydrates ${dish.carbohydrates} </p>

            <p style="padding: auto; margin: 30px">fat ${dish.fat} </p>

            <p style="padding: auto; margin: 30px">type_dish ${dish.type_dish} </p>


        </c:forEach>
    </div>
    <div class="addDish">
    <a class="changeButton" href="/chooseMyDish/${meal.id}">Add Dish</a>

    </div>


</div>
</body>

</html>