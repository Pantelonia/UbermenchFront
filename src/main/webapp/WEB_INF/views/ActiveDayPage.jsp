<%--@elvariable id="daillyMenu" type="com.pokorili.musicOn.entity.DaillyMenu"--%>
<%--@elvariable id="programm" type="com.pokorili.musicOn.entity.WeeklyDiet"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <title>MusicOn</title>
    <meta charset="UTF-8"/>
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
        margin-top: 90px;
        padding: auto;
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

    <h1>Name: ${programm.name}</h1>
    <h2>Description: ${programm.description}</h2>
    <h3>Author: ${programm.author}</h3>
    <div class="allMyMealsDish">
        <%--@elvariable id="meals" type="com.pokorili.musicOn.entity.Meal[]"--%>
        <c:forEach items="${meals}" var="meal">

            <a href="/activeMeal/${programm.id}/${meal.id}/" style="padding: auto; margin: 30px">${meal.name} </a>




        </c:forEach>
    </div>
    <div class="addMeal">
        <a class="changeButton" href="/addMeal/${daillyMenu.id}">Add Meal</a>

    </div>


</div>
</body>

</html>