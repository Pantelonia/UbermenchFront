<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <title>Ubermensch</title>
    <meta charset="UTF-8"/>
    <style>
        .select-css {
            display: block;
            font-size: 16px;
            font-family: sans-serif;
            font-weight: 700;
            color: #444;
            line-height: 1.3;
            padding: .6em 1.4em .5em .8em;
            width: 100%;
            max-width: 100%;
            box-sizing: border-box;
            margin: 0;
            border: 1px solid #aaa;
            box-shadow: 0 1px 0 1px rgba(0,0,0,.04);
            border-radius: .5em;
            -moz-appearance: none;
            -webkit-appearance: none;
            appearance: none;
            background-color: #fff;
            background-image: url('data:image/svg+xml;charset=US-ASCII,%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20width%3D%22292.4%22%20height%3D%22292.4%22%3E%3Cpath%20fill%3D%22%23007CB2%22%20d%3D%22M287%2069.4a17.6%2017.6%200%200%200-13-5.4H18.4c-5%200-9.3%201.8-12.9%205.4A17.6%2017.6%200%200%200%200%2082.2c0%205%201.8%209.3%205.4%2012.9l128%20127.9c3.6%203.6%207.8%205.4%2012.8%205.4s9.2-1.8%2012.8-5.4L287%2095c3.5-3.5%205.4-7.8%205.4-12.8%200-5-1.9-9.2-5.5-12.8z%22%2F%3E%3C%2Fsvg%3E'),
            linear-gradient(to bottom, #ffffff 0%,#e5e5e5 100%);
            background-repeat: no-repeat, repeat;
            background-position: right .7em top 50%, 0 0;
            background-size: .65em auto, 100%;
        }
        .select-css::-ms-expand {
            display: none;
        }
        .select-css:hover {
            border-color: #888;
        }
        .select-css:focus {
            border-color: #aaa;
            box-shadow: 0 0 1px 3px rgba(59, 153, 252, .7);
            box-shadow: 0 0 0 3px -moz-mac-focusring;
            color: #222;
            outline: none;
        }
        .select-css .option {
            font-weight:normal;
        }
        .param-form {
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
<%@include file="header.jsp" %>
<div class="param-form" align="left">
    <div class="head">
        Edit parameters
    </div>
    <%--@elvariable id="newParam" type="com.pokorili.musicOn.entity.Parametrs"--%>
    </h1>

    <form:form method="post" action="/addParametrs" modelAttribute="newParam">
        <form:input type="hidden" path="users" value="<%=user%>"/>
        <div class="inputField">
            <label>
                Age:<br>
                <form:input type="text" path="age"/>
            </label>
        </div>
        <div class="inputField">
            <label>
                Height:<br>
                <form:input type="text" path="height"/>
            </label>
        </div>
        <div class="inputField">
            <label>
                Weight:<br>
                <form:input type="text" path="weight"/>
            </label>
        </div>
        <div class="inputField">

        </div>
        <div class="inputField">
            <label>
                Gender:<br>
                <form:select  path="gender" size="2" cssClass="select-css">

                        <form:option cssClass="option" selected="1" value="m">Male</form:option>
                        <form:option cssClass="option"  value="w">Female</form:option>


                </form:select>
            </label>
        </div>
        <div class="inputField">
            <input type="submit" value="Add" class="butt"/>
        </div>


    </form:form>
</div>
</body>