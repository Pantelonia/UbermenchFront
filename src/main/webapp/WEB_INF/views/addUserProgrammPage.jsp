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
    .mainContent {
        margin-top: 20px;
    }

    .userInfo {
        margin: 30px 20px;

    }

    .changeButton {
        color: white;
        text-decoration: none;
        padding: 12px 15px;
        font-weight: 500;
        border-radius: 10px;
        background: #2e197b;
        border: none;

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
</style>
<div class="mainContent">
    <div class="info-block">
        <p>${errMessage}</p>
    </div>

    <%--@elvariable id="programms" type="com.pokorili.musicOn.entity.WeeklyDiet[]"--%>

    <div class="inner">
        <div class="head">Select Programme</div>
        <div class="userInfo">
            <c:forEach items="${programms}" var="programm">
                <p class="userInfo" >${programm.name} - ${programm.author} - ${programm.description}</p>
                <a class="changeButton"  href="/addMyProgramm/${programm.id}">Add</a>
            </c:forEach>
        </div>

    </div>

</div>


</body>

</html>