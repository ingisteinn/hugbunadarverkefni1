<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title class="firstletter"><c:out value = "${category}"/></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles.css"/>"/>
</head>

<body>
<%@include file="/WEB-INF/jsp/Header.jsp" %>
<main>
<h1 class="firstletter"> <c:out value = "${category}"/> </h1>

<div class="exercise__category__listcontainer">
    <ul class="exercise__category__list">
        <c:forEach var="ex" items="${exercises}">
            <li class="exercise__category__list__item"> ${ex.name}</li>
        </c:forEach>
    </ul>
</div>
</body>
</main>
<footer>Class HBV501G, University of Iceland</footer>
</html>
