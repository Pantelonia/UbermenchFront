<%--@elvariable id="parametrs" type="com.pokorili.musicOn.entity.Parametrs"--%>
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
    <div class="userInfo">
        <h1 class="nickname"><%=user.getLogin()%></h1>
        <p class="label">Your email:</p>
        <p class="email"><%=user.getEmail()%></p>

        <a class="changeButton" href="/changeLogin">Change nickname</a>
        <a class="changeButton" href="/changeEmail">Change email</a>
        <a class="changeButton" href="/changePassword">Change password</a>
    </div>
    <div class="param">
        <h1>Возраст:${parametrs.age}</h1>
        <h1>Пол: ${parametrs.gender} </h1>
        <h1>Рост:${parametrs.height}</h1>
        <h1>Вес:${parametrs.weight}</h1>
        <h1>Дата фикирования:${parametrs.date}</h1>
        <a class="changeButton" href="/changeParametrs">Edit parametrs</a>

    </div>
</div>
</body>

</html>