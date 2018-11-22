<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>
    <title>Exercise</title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles.css"/>"/>
</head>
<body>

<c:choose>
    <%--If the session has a login attribute--%>
    <c:when test="${not empty sessionScope.login}">
        <h1>You are already logged in!</h1>
    </c:when>

    <%--If the session doesn't have a login attribute--%>
    <c:otherwise>
        <sf:form class="login__form" method="POST" modelAttribute="login" action="/login">
            <h1>Login</h1>
            <c:if test="${not empty error}"><h4>${error}</h4></c:if>
            <div>
                <label for="username">Username: </label>
                <sf:input id="username" path="username" type="text" placeholder="Username" required="required"/>
            </div>
            <div>
                <label for="password">Password: </label>
                <sf:input id="password" path="password" type="password" placeholder="Password" required="required"/>
            </div>



            <input class="button" type="submit" VALUE="Login"/>

        </sf:form>
    </c:otherwise>
</c:choose>


</body>
</html>
