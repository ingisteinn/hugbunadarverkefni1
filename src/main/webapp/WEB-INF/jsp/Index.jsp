<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>PIGS Workout Tracker</title>

        <link rel="stylesheet" type="text/css" href="<c:url value="/css/postitnote.css"/>"/>
    </head>
    <body>

    <div class="header">
    <h1>Choose an exercise category</h1>
    <div class="login">
    <input class="loginButton" type="button" onclick="location.href='/login';" VALUE="Login"/>
    <a href="/register">Create new account</a>
    </div>
    </div>

    <%--
    <sf:form method="POST" modelAttribute="category" action="/">

                <td>
                    <sf:select path="category">
                        <sf:option selected="selected" value="Chest">Chest</sf:option>
                        <sf:option value="Back">Back</sf:option>
                        <sf:option value="Legs">Legs</sf:option>
                        <sf:option value="Abs">Abs</sf:option>
                    </sf:select>
                </td>

    </sf:form>
    --%>




    <c:choose>
        <%--If the model has an attribute with the name `postitNotes`--%>
        <c:when test="${not empty exercisesInCategory}">
            <%--Create a table for the Postit Notes--%>
            <table class="exercisesInCategory">

                    <%--For each postit note, that is in the list that was passed in the model--%>
                    <%--generate a row in the table--%>
                    <%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
                <c:forEach var="ex" items="${exercisesInCategory}">
                    <tr>
                            <%--We can reference attributes of the Entity by just entering the name we gave--%>
                            <%--it in the singular item var, and then just a dot followed by the attribute name--%>

                            <%--Create a link based on the name attribute value--%>
                        <td><a href="/exercise/${ex.name}">${ex.name}</a></td>
                            <%--The String in the note attribute--%>
                        <td>${ex.category}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>

        <%--If all tests are false, then do this--%>
        <c:otherwise>
            <ul>
                <li><a href="/chest">Chest</a></li>
                <li><a href="/back">Back</a></li>
                <li><a href="/legs">Legs</a></li>
                <li><a href="/abs">Abs</a></li>
            </ul>
        </c:otherwise>
    </c:choose>

    <div class="add">
    <p>Can't find the exercise you want?</p>
    <input class="addButton" type="button" onclick="location.href='/exercise';" VALUE="Add new Exercise"/>
    </div>
    </body>
    <footer>Class HBV501G, University of Iceland</footer>
</html>
