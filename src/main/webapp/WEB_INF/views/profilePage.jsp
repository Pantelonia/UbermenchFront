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
        <h1 class="nickname"><%=user.getNickname()%></h1>
        <p class="label">Your email:</p>
        <p class="email"><%=user.getEmail()%></p>
        <a class="changeButton" href="/changeNickname">Change nickname</a>
        <a class="changeButton" href="/changeEmail">Change email</a>
        <a class="changeButton" href="/changePassword">Change password</a>
    </div>
</div>
</body>

</html>