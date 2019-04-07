<%@ page import="com.pokorili.musicOn.entity.Visitor" %>
<style>
    * {
        padding: 0;
        margin: 0;
    }
    a:visited {
        color: black;
    }
    a {
        color: black;
        text-decoration: none;
    }
    .header {
        height: 100px;
        border: 1px solid darkgray;
        background-color: antiquewhite;
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
</style>
<div class = "header">
    <div class="icon inline-block">
        <h1><a href="/">MusicOn</a></h1>
    </div>
    <div class="searchInput inline-block">
        <form method="get" action="/search">
            <input type="text" name="title" value="${title}"/>
            <input type="hidden" name="searchtype" value="soundtrackByTitle">
            <input type="submit" value="Find"/>
        </form>
    </div>
    <%
        Visitor user = (Visitor) session.getAttribute("user");
        if (user.getStatus().equals("UnAuth")) {
    %>
    <div class="right-block inline-block">
        <div class="login inline-block">
            <a href="/login">Login</a>
        </div>
        <div class="register inline-block">
            <a href="/register">Register</a>
        </div>
    </div>
    <%
        } else {
    %>
    <div class="right-block inline-block">
        <div class="inline-block">
            <a href="/profile"><%=user.getNickname()%></a>
        </div>
        <div class="inline-block">
            <a href="/logout">Logout</a>
        </div>
    </div>
    <%
        }
    %>
</div>