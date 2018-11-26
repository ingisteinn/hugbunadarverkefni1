<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>PIGS Workout Tracker</title>

        <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles.css"/>"/>
    </head>
    <body>
        <%@include file="/WEB-INF/jsp/Header.jsp" %>
        <main>
            <h1>Choose an exercise category</h1>
            <div class="exercise__category">
                <div class="exercise__category--chest">
                    <h3><a href="/category/chest">Chest</a></h3>
                </div>
                <div class="exercise__category--back">
                    <h3><a href="/category/back">Back</a></h3>
                </div>
                <div class="exercise__category--legs">
                    <h3><a href="/category/legs">Legs</a></h3>
                </div>
                <div class="exercise__category--core">
                    <h3><a href="/category/core">Core</a></h3>
                </div>
                <div class="exercise__category--arms">
                    <h3><a href="/category/arms">Arms</a></h3>
                </div>
                <div class="exercise__category--shoulders">
                    <h3><a href="/category/shoulders">Shoulders</a></h3>
                </div>
            </div>
            <div class="add">
                <div class="add__item">
                    <p>Can't find the exercise you want?</p>
                    <a class="button" href="/exercise">Add new Exercise</a>
                </div>
                <div class="add__item">
                    <p>Add/view your progress</p>
                    <a class="button" href="/progress">Add/view progress</a>
                </div>
            </div>
        </main>

        <footer>Class HBV501G, University of Iceland</footer>
    </body>
</html>
