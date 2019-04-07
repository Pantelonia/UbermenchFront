<%--@elvariable id="title" type="java.lang.String"--%>
<%--@elvariable id="soundtrackTitle" type="java.lang.String"--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>MusicOn</title>
    <meta charset="UTF-8"/>
    <style>
        * {
            padding: 0;
            margin: 0;
        }

        .header {
            height: 100px;
            border: 1px solid darkgray;
            background-color: antiquewhite;
        }

        .icon {
            display: inline-block;
            height: fit-content;
            width: fit-content;
            border: 1px solid darkgray;
            margin: 30px;
        }

        .searchInput {
            display: inline-block;
            margin: 30px;
        }

        a:visited {
            color: black;
        }

        a {
            color: black;
            text-decoration: none;
        }

        .searchType {
            margin-top: 20px;
            margin-left: 10px;
            width: fit-content;
            padding: 2px;
            border: 2px solid black;
            padding: 3px;
        }

        .searchChoose {
            display: inline-block;
            float: left;
        }

        .container {
            display: inline-block;
            margin: 0 100px;
        }

        .forminput {
            margin-top: 20px;
        }

        .searchResults {
            margin-top: 20px;
        }

        .songs {
            padding: 5px;
            margin-top: 4px;
            border: 1px solid black;
        }

        .playlists {
            padding: 5px;
            margin-top: 4px;
            border: 1px solid black;
        }
    </style>
</head>

<body>
<div class="header">
    <div class="icon">
        <h1>MusicOn</h1>
    </div>
    <div class="searchInput">
        <form method="get" action="/search">
            <input type="text" name="title" value="${title}"/>
            <input type="hidden" name="searchtype" value="soundtrackByTitle">
            <input type="submit" value="Find"/>
        </form>
    </div>
</div>
<div class="mainContent">
    <div class="searchChoose">
        <div class="searchType">
            <a href="/search?title=${title}&searchtype=playlist">Искать по плейлисту</a>
        </div>
        <div class="searchType">
            <a href="/search?title=${title}&searchtype=soundtrackByAuthor">Искать по автору</a>
        </div>
        <div class="searchType">
            <a href="/search?title=${title}&searchtype=soundtrackByTitle">Искать по названию песни</a>
        </div>
    </div>
    <div class="container">
        <div class="forminput">
            <form method="get" action="/search">
                <input type="text" name="title" value="${title}">
                <input type="hidden" name="searchtype" value="${searchtype}">
                <input type="submit">
            </form>
        </div>

        <div class="searchResults">

            <% if (request.getAttribute("searchtype") != "playlist") {%>

            <c:forEach items="${searchList}" var="soundtrack">
                <div class="songs">
                    <p>${soundtrack.author} - ${soundtrack.title}</p>
                </div>
            </c:forEach>

            <% } else {%>

            <c:forEach items="${searchList}" var="playlist">
                <div class="playlists">
                    <p>${playlist.title} - ${playlist.description}</p>
                </div>
            </c:forEach>
            <% } %>
        </div>
    </div>
</div>
</body>

</html>