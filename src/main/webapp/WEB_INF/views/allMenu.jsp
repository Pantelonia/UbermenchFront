<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8"%>
<html>

<head>
    <title>MusicOn</title>
    <meta charset="UTF-8"/>
</head>

<body>
<%@include file="header.jsp"%>
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

    <div class="allMyProgramm">
        <%--@elvariable id="programms" type="com.pokorili.musicOn.entity.DaillyMenu[]"--%>
        <c:forEach items="${userProgramms}" var = "userProgramm">
            <p>
                <a href = "/Programm/${userProgramm.id}">${userProgramm.name} - ${userProgramm.author}</a>

            </p>
        </c:forEach>
    </div>

    <div class="addProgramm">
        <a class="changeButton" href="/chooseMyProgramm">Add Programm</a>

    </div>





</div>
</body>

</html>