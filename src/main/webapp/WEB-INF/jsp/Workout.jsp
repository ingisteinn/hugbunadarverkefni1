<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>
    <title>Workout</title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles.css"/>"/>
</head>
<body>
    <%@include file="/WEB-INF/jsp/Header.jsp" %>
    <main>

    <c:choose>
        <%--If the session doesn't have a login attribute--%>
        <c:when test="${empty sessionScope.login}">
            <h1>You have to be logged in to view your workouts!</h1>
        </c:when>
        <c:otherwise>
            <%--If the session has a login attribute--%>
            <h2>My workouts</h2>
            <div>
                <c:forEach var="userWork" items="${userWorkouts}">
                    <div>${userWork.name}</div>
                    <ul>
                        <c:forEach var="ex" items="${userWork.exercises}">
                            <li> ${ex.name}</li>
                        </c:forEach>
                    </ul>
                </c:forEach>
            </div>
            <h2> Create a new workout: </h2>
            <sf:form method="POST" modelAttribute="exercise" action="/addExerciseToWorkout">
                <div>
                    <label for="exercise" class="label">Exercise: </label>
                    <sf:select class="workout--dropdown" id="exercise" path="id">
                        <c:forEach items="${exercises}" var="exercise">
                            <sf:option value="${exercise.id}">
                                ${exercise.name}
                            </sf:option>
                        </c:forEach>
                    </sf:select>
                </div>


                <div class="input--div">
                    <label for="sets" class ="label">Sets: </label>
                    <sf:input id="sets" path="sets" type="number" required="required" class="input"/>
                </div>
                <div class="input--div">
                    <label for="reps" class="label">Reps: </label>
                    <sf:input id="reps" path="reps" type="number" required="required" class="input"/>
                </div>
                <div class="input--div">
                    <label for="weight" class="label">Weight: </label>
                    <sf:input id="weight" path="weight" type="number" required="required" class="input"/>
                </div>
                <input class="button" type="submit" VALUE="Add exercise"/>
            </sf:form>
            <sf:form method="POST" modelAttribute="workout" action="/workout">

                <div class="input--div">
                    <label for="name" class="label">Name: </label>
                    <sf:input id="name" path="name" type="text" required="required" class="input"/>
                </div>
                <div class="input--div">
                    <label for="category" class="label">Category: </label>
                    <sf:input id="category" path="category" type="text" required="required" class="input"/>
                </div>

                <input class="button" type="submit" VALUE="Create workout"/>
            </sf:form>

            <h2>Exercises in workout: </h2>
            <ul>
                <c:forEach var="ex" items="${workout.exercises}">
                    <li> ${ex.name}</li>
                </c:forEach>
            </ul>

        </c:otherwise>
    </c:choose>

    </main>

<%-- Unfinished --%>


</body>
<footer>Class HBV501G, University of Iceland</footer>
</html>
