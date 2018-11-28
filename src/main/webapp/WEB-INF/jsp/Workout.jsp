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
        <h1>Workouts</h1>
    <c:choose>
        <%--If the session doesn't have a login attribute--%>
        <c:when test="${empty sessionScope.login}">
            <h1>You have to be logged in to view your workouts!</h1>
        </c:when>
        <c:otherwise>
        <%--If the session has a login attribute--%>

            <!-- Hér kemur listi af workouts sem eru til -->
            <h2> Create a new workout: </h2>
            <sf:form method="POST" modelAttribute="exercise" action="/addExerciseToWorkout">
                <div>
                    <label for="exercise" class="workout--label">Exercise: </label>
                    <sf:select class="workout--dropdown" id="exercise" path="id">
                        <c:forEach items="${exercises}" var="exercise">
                            <sf:option value="${exercise.id}">
                                ${exercise.name}
                            </sf:option>
                        </c:forEach>
                    </sf:select>
                </div>


                <div class="workout--div">
                    <label for="sets" class ="workout--label">Sets: </label>
                    <sf:input id="sets" path="sets" type="number" required="required" class="workout--input"/>
                </div>
                <div class="workout--div">
                    <label for="reps" class="workout--label">Reps: </label>
                    <sf:input id="reps" path="reps" type="number" required="required" class="workout--input"/>
                </div>
                <div class="workout--div">
                    <label for="weight" class="workout--label">Weight: </label>
                    <sf:input id="weight" path="weight" type="number" required="required" class="workout--input"/>
                </div>
                <input class="button" type="submit" VALUE="Add exercise"/>
            </sf:form>
            <sf:form method="POST" modelAttribute="workout" action="/workout">

                <div class="workout--div">

                    <label for="name" class="workout--label">Name: </label>
                    <sf:input id="name" path="name" type="text" required="required" class="workout--input"/>
                </div>
                <div class="workout--div">
                    <label for="category" class="workout--label">Category: </label>
                    <sf:input id="category" path="category" type="text" required="required" class="workout--input"/>
                </div>
                <input class="button" type="submit" VALUE="Create workout"/>
            </sf:form>

            <ul>
                <c:forEach var="ex" items="${workout.exercises}">
                    <li> ${ex.name}</li>
                </c:forEach>
            </ul>



        </c:otherwise>
    </c:choose>
        <h2>My workouts</h2>
        <div>
            <c:forEach var="userWork" items="${userWorkouts}">
                <div>${userWork.name}</div>
                <div>
                    <c:forEach var="ex" items="${userWork.exercises}">
                        <li> ${ex.name}</li>
                    </c:forEach>
                </div>
            </c:forEach>
        </div>
    </main>

<%-- Unfinished --%>


</body>
<footer>Class HBV501G, University of Iceland</footer>
</html>
