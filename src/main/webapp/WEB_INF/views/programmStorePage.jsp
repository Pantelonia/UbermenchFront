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

    <%--@elvariable id="programms" type="com.pokorili.musicOn.entity.WeeklyDiet[]"--%>
    <c:forEach items="${programms}" var = "programm">
        <p>${programm.name} - ${programm.author}</p>
    </c:forEach>


</div>
</body>

</html>