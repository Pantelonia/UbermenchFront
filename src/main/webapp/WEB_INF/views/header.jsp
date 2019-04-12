<%@ page import="com.pokorili.musicOn.entity.Users" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    function openNav() {
        document.getElementById("myNav").style.width = "100%";
    }

    function closeNav() {
        document.getElementById("myNav").style.width = "0%";
    }

</script>
<style>
    * {
        padding: 0;
        margin: 0;
        font-family: Roboto;
    }
    .headlink:visited {
        color: white;
    }
    .headlink {
        color: white;
        text-decoration: none;
        padding: 5px 15px;
        font-weight: 500;

    }
    .headlink:hover{
        border: 5px solid white;
        background: white;
        border-radius: 15px;
        padding: 5px 10px;
        color: #2e197b;
        font-weight: 700;
    }
    .header {
        height: 100px;
        background-color: #2e197b;
        color: white;
    }
    .header-mobile{
        display: none;
    }
    .icon {
        width: fit-content;
        margin: 30px;
    }
    .searchInput {
        margin: 30px;
    }
    .inline-block {
        display: inline-block;


    }
    .right-block div {
        margin: 0 20px;
    }
    .right-block {
        float: right;
        margin: 40px;
    }

    @media screen and (max-width: 978px) {
        .header{
            display: none;
        }
        .header-mobile{
            height: 100px;
            background-color: #2e197b;
            color: white;
            display: block;
        }

        header {
            background-color: white;
            color: black;
            font-family: 'Roboto';
            letter-spacing: 1px;
            font-weight: 500;
            border-bottom: 1px solid gainsboro;
            display: block;


        }

        .overlay {
            height: 100%;
            width: 0;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: rgb(0,0,0);
            background-color: rgba(0,0,0, 0.9);
            overflow-x: hidden;
            transition: 0.5s;
        }

        .overlay-content {
            position: relative;
            top: 25%;
            width: 100%;
            text-align: center;
            margin-top: 30px;
        }

        .overlay a {
            padding: 8px;
            text-decoration: none;
            font-size: 36px;
            color: #818181;
            display: block;
            transition: 0.3s;
        }

        .overlay a:hover, .overlay a:focus {
            color: #f1f1f1;
        }

        .overlay .closebtn {
            position: absolute;
            top: 20px;
            right: 45px;
            font-size: 60px;
        }

        .menuBtn {
            display: inline-block;
            line-height: 85px;
            text-align: right;
            padding-right: 20px;
            float: right;
            cursor: pointer;
        }

        .menuBtn:hover { opacity: 0.7; }

        .menuBtn img {
            height: 60px;
            position: relative;

            top: 22px;

        }

    }
</style>
<div class = "header">
    <div class="icon inline-block">
        <h1><a href="/" class="headlink">Ubermensch</a></h1>
    </div>
    <%--<div class="searchInput inline-block">--%>
    <%--<form method="get" action="/search">--%>
    <%--<input type="text" name="title" value="${title}"/>--%>
    <%--<input type="hidden" name="searchtype" value="soundtrackByTitle">--%>
    <%--<input type="submit" value="Find"/>--%>
    <%--</form>--%>
    <%--</div>--%>
    <%
        Users user = (Users) session.getAttribute("user");
        if (user.getEmail() == null) {
    %>
    <div class="right-block inline-block">
        <div class="login inline-block">
            <a href="/login" class="headlink">Login</a>
        </div>
        <div class="register inline-block">
            <a href="/register" class="headlink">Register</a>
        </div>
    </div>
    <%
    } else {
    %>
    <div class="right-block inline-block">
        <div class="inline-block">
            <a href="/profile" class="headlink"><%=user.getLogin()%></a>
        </div>
        <div class="inline-block">
            <a href="/logout" class="headlink">Logout</a>
        </div>
        <div class="inline-block">
            <a href="/MyProgramm" class="headlink">My programm</a>
        </div>
        <div class="inline-block">
            <a href="/Programm" class="headlink">ProgrammStore</a>
        </div>
    </div>
    <%
        }
    %>
</div>

<header class="header-mobile">


    <div class="icon inline-block">
        <h1><a href="/" class="headlink">Ubermensch</a></h1>
    </div>
    <span class="menuBtn" onclick="openNav()"><img src="https://i.ibb.co/Fx17DyW/menu-icon.png" alt="Menu icon"></span>
    <div id="myNav" class="overlay">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>

        <%
            Users use = (Users) session.getAttribute("user");
            if (use.getEmail() == null) {
        %>
        <div class="overlay-content">
            <a href="/login" >Login</a>
            <a href="/register" >Register</a>
        </div>
        <%
        } else {
        %>
        <div class="overlay-content">
            <a href="/profile"> <%=user.getLogin()%></a>
            <a href="/logout"> Logout</a>
            <a href="/MyProgramm"> My programm</a>
            <a href="/Programm"> ProgrammStore</a>
        </div>
        <%
            }
        %>
    </div>

    </div>

</header>