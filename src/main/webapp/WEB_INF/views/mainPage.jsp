<%--@elvariable id="soundtrackTitle" type="java.lang.String"--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8"%>
<html>

<head>
    <title>Svetetcom</title>
    <meta charset="UTF-8"/>
</head>
<style>
    body{
        font-family: Roboto;
    }
    .gradient{
        background: -moz-linear-gradient(90deg, rgba(74,125,255,1) 0%, rgba(46,25,123,1) 100%); /* ff3.6+ */
        background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, rgba(46,25,123,1)), color-stop(100%, rgba(74,125,255,1))); /* safari4+,chrome */
        background: -webkit-linear-gradient(90deg, rgba(74,125,255,1) 0%, rgba(46,25,123,1) 100%); /* safari5.1+,chrome10+ */
        background: -o-linear-gradient(90deg, rgba(74,125,255,1) 0%, rgba(46,25,123,1) 100%); /* opera 11.10+ */
        background: -ms-linear-gradient(90deg, rgba(74,125,255,1) 0%, rgba(46,25,123,1) 100%); /* ie10+ */
        background: linear-gradient(0deg, rgba(74,125,255,1) 0%, rgba(46,25,123,1) 100%); /* w3c */
        height: 900px;
        width: 100%;
        margin: auto;
    }

    .image{
        float: right;

    }

    .left{
        display: inline-block;
        width: 50%;
    }

    .right{
        display: inline-block;
        float: right;
        width: 49%;
    }

    .text1{
        color: white;
        font-family: Roboto;
        font-weight: 600;
        font-size: 40px;
        padding-top: 100px;
        padding-left: 5%;
    }

    .text2{
        padding-left: 5%;
        padding-top: 20px;
        padding-bottom: 20px;
        color: white;
        font-size: 18px;

    }


    @media screen and (max-width: 885px) {
        .left, .right{
            display: block;
            width: 100%;
            float: right;
            position: sticky;
        }

        .text2{
            padding-right: 5%;
        }
        .text1{
            padding-top: 50px;
        }
        .gradient{
            height: auto;
            display: block;
            float: left;
        }
    }
</style>
<body>
<%@include file="header.jsp"%>

<div>
    <div class="gradient" >
        <div class="left">
            <div class="text1">Ubermensch - составь свой рацион</div>
            <div class="text2">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                    Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>


            </div>

            <div class="text2">
                <p>Laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure
                    dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                    proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </div>

            <div class="text2">
                <p>Laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure
                    dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                    proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </div>


        </div>
        <div class="right">
            <img src="https://i.ibb.co/cTrQbPg/photoeditorsdk-export.png" class="image" style="width: auto; height: auto; max-width: 100%" >
        </div>

    </div>
</div>

</body>

</html>