<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<body>
<header class="header">
    <div class="header__links">
        <a class="header__heading" href="/">Workout tracker</a>
        <a class="header__link" href="/chart">Analysis</a>
        <a class="header__link" href="/workout">Workouts</a>
    </div>

    <div class="login">
        <c:choose>
            <%--If the session has a login attribute--%>
            <c:when test="${not empty sessionScope.login}">
                <a class="button" href="/logout">Logout</a>
            </c:when>

            <%--If the session doesn't have a login attribute--%>
            <c:otherwise>
                <a class="login__button button" href="/login">Login</a>
                <a class="register" href="/register">Create new account</a>
            </c:otherwise>
        </c:choose>
    </div>
</header>


</body>
</html>
