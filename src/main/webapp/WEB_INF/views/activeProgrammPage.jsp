<%--@elvariable id="programm" type="com.pokorili.musicOn.entity.WeeklyDiet"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <title>MusicOn</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" />

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

    <div class="jumbotron">
        <h1 >Programm name: ${programm.name}</h1>
        <h2>Description: ${programm.description}</h2>
        <h3>Author: ${programm.author}</h3>
    </div>



    <div class="allMyProgrammDays">
        <%--@elvariable id="programms" type="com.pokorili.musicOn.entity.WeeklyDiet[]"--%>
        <%--@elvariable id="days" type="com.pokorili.musicOn.entity.DaillyMenu[]"--%>
        <c:forEach items="${days}" var="day">
            <p style="padding: auto; margin: 30px">

            <a class="" href="/activeDay/${programm.id}/${day.id}" style="padding: auto; margin: 30px">${day.day} </a>
            <%--<div class="addMeal">--%>
                <%--<a class="changeButton" href="/addMeal/${day.id}">Add Meal</a>--%>

            <%--</div>--%>

            </p>
        </c:forEach>
    </div>




</div>
</body>

</html>