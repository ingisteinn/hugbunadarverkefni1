<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>Workout</title>
</head>
<body>

<%-- Unfinished --%>

<h1>Workout page</h1>

<div class="exercise__category">
    <ul class="exercise__list">
        <c:forEach var="ex" items="${exercises}">
            <li class="exercise__list-item"><a href="/exercise/${ex.name}">${ex.name}</a></li>
        </c:forEach>
    </ul>
</div>

</body>
<footer>Class HBV501G, University of Iceland</footer>
</html>
