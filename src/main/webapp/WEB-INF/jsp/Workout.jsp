<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>
    <title>Workout</title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles.css"/>"/>
</head>
<body>
    <%@include file="/WEB-INF/jsp/Header.jsp" %>
    <main>
        <h1>Workouts</h1>
    <c:choose>
        <%--If the session doesn't have a login attribute--%>
        <c:when test="${empty sessionScope.login}">
            <h1>You have to be logged in to view your workouts!</h1>
        </c:when>

        <%--If the session has a login attribute--%>
        <c:otherwise>
            <!-- Hér kemur listi af workouts, titill sem hægt er að ýta á -->

            <div class="add__item">
                <a class="button" href="/workout/create">Create a new workout</a>
            </div>

        </c:otherwise>
    </c:choose>
    </main>

<%-- Unfinished --%>


</body>
<footer>Class HBV501G, University of Iceland</footer>
</html>
