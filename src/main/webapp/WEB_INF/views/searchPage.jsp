<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8"%>
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

    </style>
</head>

<body>
<div class = "header">
    <div class="icon">
        <h1>MusicOn</h1>
    </div>
    <div class="searchInput">
        <form method="post" action="/search">
            <input type="text" name="title"/>
            <input type="submit" value="Find"/>
        </form>
    </div>
</div>
<div class="mainContent">

    <div class="searchResults">
    <%--@elvariable id="soundtrackList" type="java.util.ArrayList<com.pokorili.musicOn.entity.Soundtrack>"--%>
    <c:forEach items="${soundtrackList}" var="soundtrack">
        <p>${soundtrack.author} - ${soundtrack.title}</p>
    </c:forEach>
    </div>
</div>
</body>

</html>