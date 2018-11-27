<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">

<head>
    <title>Exercise</title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles.css"/>"/>
</head>
<body>
<%@include file="/WEB-INF/jsp/Header.jsp" %>
    <main>
        <c:choose>
            <%--If the session has a login attribute--%>
            <c:when test="${empty sessionScope.login}">
                <h1>You have to be logged in to view your progress!</h1>
            </c:when>

            <%--If the session doesn't have a login attribute--%>
            <c:otherwise>
                <sf:form method="POST" modelAttribute="newProgress" action="/progress">
                    <h1 class="login__heading">Add progress</h1>
                    <c:if test="${not empty error}"><h4>${error}</h4></c:if>
                    <div>
                        <label for="exercise">Exercise: </label>
                        <sf:select  id="exercise" path="exerciseId">
                            <c:forEach items="${exercises}" var="exercise">
                                <sf:option value="${exercise.id}">
                                    ${exercise.name}
                                </sf:option>
                            </c:forEach>
                        </sf:select>
                    </div>
                    <div>
                        <label for="reps">Reps: </label>
                        <sf:input id="reps" path="reps" type="number" required="required"/>
                    </div>
                    <div>
                        <label for="sets">Sets: </label>
                        <sf:input id="sets" path="sets" type="number" required="required"/>
                    </div>
                    <div>
                        <label for="weight">Weight: </label>
                        <sf:input id="weight" path="weight" type="text" required="required"/>
                    </div>
                    <div>
                        <label for="date">Date: </label>
                        <sf:input id="date" path="date" type="date" required="required"/>
                    </div>


                    <input class="button" type="submit" onsubmit="getChart()" VALUE="Add progress"/>

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
                                <td>Date: <fmt:formatDate dateStyle = "long" value = "${prog.date}" /></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </c:otherwise>
        </c:choose>


    </main>
</body>
</html>
