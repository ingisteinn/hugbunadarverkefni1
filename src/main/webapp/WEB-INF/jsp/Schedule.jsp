<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>
    <title>PIGS Workout Tracker</title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/vanillaCalendar.css"/>"/>

</head>
<body>
<%@include file="/WEB-INF/jsp/Header.jsp" %>
<main>
    <div id="v-cal">
        <div class="vcal-header">
            <button class="vcal-btn" data-calendar-toggle="previous">
                <svg height="24" version="1.1" viewbox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg">
                    <path d="M20,11V13H8L13.5,18.5L12.08,19.92L4.16,12L12.08,4.08L13.5,5.5L8,11H20Z"></path>
                </svg>
            </button>

            <div class="vcal-header__label" data-calendar-label="month">
                March 2017
            </div>


            <button class="vcal-btn" data-calendar-toggle="next">
                <svg height="24" version="1.1" viewbox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg">
                    <path d="M4,11V13H16L10.5,18.5L11.92,19.92L19.84,12L11.92,4.08L10.5,5.5L16,11H4Z"></path>
                </svg>
            </button>
        </div>
        <div class="vcal-week">
            <span>Mon</span>
            <span>Tue</span>
            <span>Wed</span>
            <span>Thu</span>
            <span>Fri</span>
            <span>Sat</span>
            <span>Sun</span>
        </div>
        <div class="vcal-body" data-calendar-area="month"></div>
    </div>

    <p class="demo-picked">
        Date picked:
        <span data-calendar-label="picked"></span>
    </p>


    <script src="/js/vanillaCalendar.js" type="text/javascript"></script>
    <script>
        window.addEventListener('load', function () {
            vanillaCalendar.init({
                disablePastDays: false
            });
        })

        var day,month,year;

        function getDate(_day,_month,_year){
            day = _day;
            month = _month;
            year = _year;
        }




    </script>

    <c:choose>
        <%--If the session has a login attribute--%>
    <c:when test="${empty sessionScope.login}">
    <h1>You have to be logged in to add to schedule!</h1>
    </c:when>

        <%--If the session doesn't have a login attribute--%>
    <c:otherwise>
    <sf:form method="POST" modelAttribute="newSchedule" action="/schedule">
    <h1 class="login__heading">Add to schedule</h1>
    <c:if test="${not empty error}"><h4>${error}</h4></c:if>
    <div>
        <label for="workout">Workout: </label>
        <sf:select  id="workout" path="workoutId">
            <c:forEach items="${workouts}" var="workout">
                <sf:option value="${workout.id}">
                    ${workout.name}
                </sf:option>
            </c:forEach>
        </sf:select>
    </div>
    <div>
        <label for="date">Date: </label>
        <sf:input id="date" path="date" type="date" required="required"/>
    </div>


    <input class="button" type="submit" onsubmit="updateCalendar()" VALUE="Add to schedule"/>

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



<footer>Class HBV501G, University of Iceland</footer>
</body>
</html>
