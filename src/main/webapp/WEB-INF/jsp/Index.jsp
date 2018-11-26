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
                <a href="/category/arms">
                    <div class="exercise__category--arms">
                        <img src="../images/arms.jpg" />
                        <h3>Arms</h3>
                    </div>
                </a>
                <a href="/category/back">
                    <div class="exercise__category--back">
                        <img src="../images/back.jpg" />
                        <h3>Back</h3>
                    </div>
                </a>
                <a href="/category/chest">
                    <div class="exercise__category--chest">
                        <img src="../images/chest.jpg" />
                        <h3>Chest</h3>
                    </div>
                </a>
                <a href="/category/core">
                    <div class="exercise__category--core">
                        <img src="../images/core.jpg" />
                        <h3>Core</h3>
                    </div>
                </a>
                <a href="/category/legs">
                    <div class="exercise__category--legs">
                        <img src="../images/legs.jpg" />
                        <h3>Legs</h3>
                    </div>
                </a>
                <a href="/category/shoulders">
                    <div class="exercise__category--shoulders">
                        <img src="../images/shoulder.jpg" />
                        <h3>Shoulders</h3>
                    </div>
                </a>
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
