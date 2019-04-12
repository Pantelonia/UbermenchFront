<%--@elvariable id="parametrs" type="com.pokorili.musicOn.entity.Parametrs"--%>
<%@page contentType="text/html;charset=UTF-8"%>
<html>

<head>
    <title>Ubermensch</title>
    <meta charset="UTF-8"/>
</head>

<body>
<%@include file="header.jsp"%>
<style>

    .mainContent{
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
    .head{
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

    .left{
        display: inline-block;
        width: 50%;
        float: left;
    }

    .right{
        display: inline-block;
        width: 49%;
        float: left;
    }

    .inner{
        margin: 0 20px;
        border: 2px solid gainsboro;
        border-radius: 45px;
    }

    @media screen and (max-width: 1086px) {
        .left, .right{
            display: block;
            width: 100%;
            float: left;
            margin-bottom: 30px;

        }
        .mainContent{

            height: 100%;
        }

    }
</style>
<div class="mainContent">
    <div class="left">
        <div class="inner">
            <div class="head">
                <h5>User info</h5>
            </div>
            <div class="info-block">
                <p>${infoMessage}</p>
            </div>
            <div class="userInfo">
                <p class="label">Your nickname:</p>
                <h3 class="nickname"> <%=user.getLogin()%></h3>
                <br>
                <p class="label">Your email:</p>
                <h3 class="nickname"> <%=user.getEmail()%></h3>
                <br>
                <br>
                <div>
                    <a class="changeButton" href="/changeLogin">Change nickname</a>
                    <a class="changeButton" href="/changeEmail">Change email</a>
                    <a class="changeButton" href="/changePassword">Change password</a>

                </div>
            </div>
        </div>

    </div>

    <div class="right" >
        <div class="inner">
            <div class="head">
                <h5>Name block</h5>
            </div>
            <div class="userInfo">
                <h4>Возраст:${parametrs.age}</h4>
                <h4>Пол: ${parametrs.gender} </h4>
                <h4>Рост:${parametrs.height}</h4>
                <h4>Вес:${parametrs.weight}</h4>
                <h4>Дата фиксирования:${parametrs.date}</h4>
                <br>
                <br>
                <a class="changeButton" href="/changeParametrs">Edit parametrs</a>
            </div>

        </div>


    </div>
</div>
</body>

</html>