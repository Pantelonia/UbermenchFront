<%@ page import="java.util.Enumeration" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>MusicOn</title>
    <meta charset="UTF-8"/>
    <style>
    </style>
</head>

<body>
<%@include file="header.jsp"%>
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