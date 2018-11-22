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

<h1>Progress</h1>
<c:choose>
    <%--If the session has a login attribute--%>
    <c:when test="${empty sessionScope.login}">
        <h1>You have to be logged in to view your progress!</h1>
    </c:when>

    <%--If the session doesn't have a login attribute--%>
    <c:otherwise>
        <h3>Add progress</h3>
        <sf:form method="POST" modelAttribute="newProgress" action="/progress">

            <table>
                <tr>
                    <td>Exercise: </td>
                    <td>
                        <sf:select  path="exerciseId">
                            <c:forEach items="${exercises}" var="exercise">
                                <sf:option value="${exercise.id}">
                                        ${exercise.name}
                                </sf:option>
                            </c:forEach>
                        </sf:select>
                    </td>
                </tr>
                <tr>
                    <td>Sets: </td>
                    <td><sf:input path="sets" type="number" required="required"/></td>
                </tr>
                <tr>
                    <td>Reps: </td>
                    <td><sf:input path="reps" type="number" required="required"/></td>
                </tr>
                <tr>
                    <td>Weight: </td>
                    <td><sf:input path="weight" type="text" required="required"/></td>
                </tr>
                <%--Not implemented yet! Not working as expected--%>
                <%--<tr>
                    <td>Reps: </td>
                    <td><sf:input path="date" type="date" required="required"/></td>
                </tr>--%>
            </table>

            <input type="submit" VALUE="Add progress"/>

        </sf:form>

        <c:if test="${not empty progress}">
            <h3>Your progress</h3>
            <%--Create a table for users progress--%>
            <table class="progress">
                <%--For each progress generate a row in the table--%>
                <c:forEach var="prog" items="${progress}">
                    <tr>
                        <td>Sets: ${prog.sets}</td>
                        <td>Reps: ${prog.reps}</td>
                        <td>Weight: ${prog.weight}</td>
                        <td>Date: ${prog.date}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </c:otherwise>
</c:choose>


</body>
</html>
