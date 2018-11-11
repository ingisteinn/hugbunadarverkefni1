<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>
    <title>Exercise</title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/postitnote.css"/>"/>
</head>
<body>

<h1>Login</h1>

<c:choose>
    <%--If the session has a login attribute--%>
    <c:when test="${not empty sessionScope.login}">
        <h1>You are already logged in!</h1>
    </c:when>

    <%--If the session doesn't have a login attribute--%>
    <c:otherwise>
        <c:if test="${not empty error}"><h3>${error}</h3></c:if>

        <sf:form method="POST" modelAttribute="login" action="/login">

            <table>
                <tr>
                    <td>Username: </td>
                    <td><sf:input path="username" type="text" placeholder="Username" required="required"/></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><sf:input path="password" type="password" placeholder="Password" required="required"/></td>
                </tr>
            </table>

            <input type="submit" VALUE="Login"/>

        </sf:form>
    </c:otherwise>
</c:choose>


</body>
</html>
