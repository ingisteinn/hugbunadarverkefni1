<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>
    <title>Register</title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles.css"/>"/>
</head>
<body>

<%--If the model has an attribute`--%>
<c:if test="${not empty error}"><h3>${error}</h3></c:if>

<%--Register the user according to the inputs in the form--%>
<sf:form class="login__form" method="POST" modelAttribute="register" action="/register">

    <h1>Register</h1>
    <div>
        <label for="username">Name: </label>
        <sf:input id="name" path="name" type="text" placeholder="Name" required="required"/>
    </div>
    <div>
        <label for="username">Username: </label>
        <sf:input id="username" path="username" type="text" placeholder="Username" required="required"/>
    </div>
    <div>
        <label for="password">Password: </label>
        <sf:input id="password" path="password" type="password" placeholder="Password" required="required"/>
    </div>

    <input class="button" type="submit" VALUE="Register"/>

</sf:form>


</body>
</html>
