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
    <%@include file="/WEB-INF/jsp/Header.jsp" %>
    <main>
        <h1>Add new exercise</h1>
        <c:if test="${not empty success}"><h3>${success}</h3></c:if>

        <%--Post method for adding a new exercise to the database--%>
        <sf:form method="POST" modelAttribute="exercise" action="/exercise">

            <table>
                <tr>
                    <td>Name: </td>
                    <%--Name the exercise--%>
                    <td><sf:input path="name" type="text" placeholder="Name" required="required"/></td>
                </tr>
                <tr>
                    <td>Category: </td>
                    <td>
                        <%--Select appropriate category for the exercise--%>
                        <sf:select path="category">
                            <sf:option selected="selected" value="arms">Arms</sf:option>
                            <sf:option value="back">Back</sf:option>
                            <sf:option value="chest">Chest</sf:option>
                            <sf:option value="core">Core</sf:option>
                            <sf:option value="legs">Legs</sf:option>
                            <sf:option value="shoulders">Shoulders</sf:option>
                        </sf:select>
                    </td>
                </tr>
            </table>

            <input type="submit" VALUE="Add exercise"/>

        </sf:form>

        <c:choose>
            <c:when test="${not empty exercises}">
                <table class="exercises">
                    <%--Display exercises in database--%>
                    <c:forEach var="ex" items="${exercises}">
                        <tr>
                            <td><a href="/exercise/${ex.name}">${ex.name}</td>
                            <td>${ex.category}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>

            <c:otherwise>
                <h3>No exercises!</h3>
            </c:otherwise>
        </c:choose>
    </main>
</body>
</html>
