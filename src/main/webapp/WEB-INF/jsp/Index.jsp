<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>PIGS Workout Tracker</title>

        <link rel="stylesheet" type="text/css" href="<c:url value="/css/postitnote.css"/>"/>
    </head>
    <body>

    <div class="header">
    <h1>Choose an exercise category</h1>
    <div class="login">
    <input class="loginButton" type="button" onclick="location.href='/login';" VALUE="Login"/>
    <a href="/register">Create new account</a>
    </div>
    </div>


    <%--                                  --Unfinished--
    List of exercise categories, when a category is selected a list of exercises in that category is displayed
    and can be added to your workout. --%>
            <ul>
                <li><a href="/chest">Chest</a></li>
                <li><a href="/back">Back</a></li>
                <li><a href="/legs">Legs</a></li>
                <li><a href="/abs">Abs</a></li>
            </ul>

    <div class="add">
    <p>Can't find the exercise you want?</p>
    <input class="addButton" type="button" onclick="location.href='/exercise';" VALUE="Add new Exercise"/>
    </div>
    </body>
    <footer>Class HBV501G, University of Iceland</footer>
</html>
