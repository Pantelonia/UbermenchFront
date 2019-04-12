<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8"%>
<html>

<head>
    <title>Ubermensch</title>
    <meta charset="UTF-8"/>
    <style>
        .register-form {
            width: 500px;
            margin: 100px auto;
            border: 1px solid darkgray;
            border-radius: 45px;
            height: auto;
        }
        .inputField {
            margin: 20px;
        }
        .red {
            color:red;
        }
        .head{
            background: #2e197b;
            color: white;
            text-align: center;
            font-size: 22px;
            padding-top: 20px;
            padding-bottom: 20px;
            font-weight: 500;

            border-top-left-radius: 45px;
            border-top-right-radius: 45px;
        }

        input[type=text] {
            width: 100%;
            font-size: 18px;
            padding: 12px 16px;
            margin: 8px 0;
            box-sizing: border-box;
        }

        input[type=password] {
            width: 100%;
            font-size: 18px;
            padding: 12px 16px;
            margin: 8px 0;
            box-sizing: border-box;
        }

        .butt{
            background: #2e197b;
            border-radius: 25px;
            border: none;
            width: 100%;
            color: white;
            font-size: 16px;
            padding: 20px 0;
        }

    </style>
</head>

<body>
<%@include file="header.jsp"%>
<div class="register-form" align="left">
    <div class="head">
        Регистрация
    </div>
    <%--@elvariable id="newUser" type="com.pokorili.musicOn.entity.Visitor"--%>
    <form:form method="post" action="/register" modelAttribute="newUser">
        <div class="inputField">
            <label>
                Email<br>
                <form:input type="text" path="email"/>
            </label>
        </div>
        <div class="inputField">
            <label>
                Login<br>
                <form:input type="text" path="login"/>
            </label>
        </div>
        <div class="inputField">
            <p class="red">${errMessage}</p>
        </div>
        <div class="inputField">
            <label>
                Password <br>
                <form:input type="password" path="password"/>
            </label>
        </div>
        <div class="inputField">
            <input type="submit" value="Register" class="butt">
        </div>
    </form:form>
</div>
</body>

</html>