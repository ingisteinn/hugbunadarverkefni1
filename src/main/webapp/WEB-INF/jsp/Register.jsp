<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>
    <title>Register</title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/postitnote.css"/>"/>
</head>
<body>

<%--If the model has an attribute`--%>
<c:if test="${not empty error}"><h3>${error}</h3></c:if>

<%--Register the user according to the inputs in the form--%>
<sf:form method="POST" modelAttribute="register" action="/register">

    <table>
        <tr>
            <td>Username:</td>
            <td><sf:input path="username" type="text" placeholder="Enter a username" required="required"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><sf:input path="name" type="text" placeholder="Enter your name" required="required"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><sf:input path="password" type="password" placeholder="Enter a password" required="required"/></td>
        </tr>
    </table>

    <input type="submit" VALUE="Create Account"/>

</sf:form>


</body>
</html>
