<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>Postit Notes</title>

        <link rel="stylesheet" type="text/css" href="<c:url value="/css/postitnote.css"/>"/>
    </head>
    <body>

    <h1><a href="/Chest">Exercise</a></h1>

    <%--Note that the `commandName` given here HAS TO MATCH the name of the attribute--%>
    <%--that is added to the model that is passed to the view.--%>
    <%--See PostitNoteController, method postitNoteViewGet(), and find where this attribute is added to the model.--%>
    <sf:form method="POST" modelAttribute="postitNote" action="/Chest">

        <table>
            <tr>
                <td>Weights:</td>
                <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="name" type="number" placeholder="Weights used"/></td>
                <td>Kg</td>
            </tr>
            <tr>
                <td>Reps:</td>
                    <%--the `path` attribute matches the `note` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="note" type="number" placeholder="Reps performed"/></td>
            </tr>
        </table>

        <input type="submit" VALUE="Add to workout!"/>

    </sf:form>

    <%--Choose what code to generate based on tests that we implement--%>
    <c:choose>
        <%--If the model has an attribute with the name `postitNotes`--%>
        <c:when test="${not empty postitNotes}">
            <%--Create a table for the Postit Notes--%>
            <table class="notes">

                <%--For each postit note, that is in the list that was passed in the model--%>
                <%--generate a row in the table--%>
                <%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
                <c:forEach var="postit" items="${postitNotes}">
                    <tr>
                        <%--We can reference attributes of the Entity by just entering the name we gave--%>
                        <%--it in the singular item var, and then just a dot followed by the attribute name--%>

                        <%--Create a link based on the name attribute value--%>
                        <td><a href="/postit/${postit.name}">${postit.name}</a></td>
                        <%--The String in the note attribute--%>
                        <td>${postit.note}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>

        <%--If all tests are false, then do this--%>
        <c:otherwise>
            <h3>No exercises!</h3>
        </c:otherwise>
    </c:choose>

    </body>
</html>
