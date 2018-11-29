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

    <div class="workoutList">
        <ul class="workoutOfDay"></ul>
    </div>


    <script src="/js/vanillaCalendar.js" type="text/javascript"></script>
    <script>
        window.addEventListener('load', function () {
            vanillaCalendar.init({
                disablePastDays: false
            });
        })

        var day, month, year;

        function getMonthFromString(mon){
            return new Date(Date.parse(mon +" 1, 2012")).getMonth()+1
        }

        let workoutList = document.querySelector('.workoutList')
        let ul = document.querySelector('.workoutOfDay');

        function removeAll(){
            while(workoutList.firstChild){
                workoutList.removeChild(workoutList.firstChild);
            }
            while(ul.firstChild){
                ul.removeChild(ul.firstChild);
            }
        }

        function getDate(_day,_month,_year){
            day = Number(_day);
            month = getMonthFromString(_month);
            year = Number(_year);
            console.log(day + " " + month);
            removeAll();

            const h2 = document.createElement('h2');
            h2.appendChild(document.createTextNode('Workout of selected day:'));
            workoutList.appendChild(h2);

            var x = 0;

            <c:forEach items="${workout}" var="workout">
            //Add to array if the progress is for the selected exercise
            var li = document.createElement('li');
            li.classList.add('workout');

            var workoutName = document.createElement('h3');
            workoutName.classList.add("workoutName");
            workoutName.appendChild(document.createTextNode("${workout.name}"));

            li.appendChild(workoutName);

            var ul2 = document.createElement('ul');
            ul2.classList.add('exercisesList');

            <c:forEach items="${workout.exercises}" var = "workoutExercise">
                var li2 = document.createElement('li');
                li2.classList.add('exercises');
                var exerciseName = document.createElement('h4');
                exerciseName.appendChild(document.createTextNode("${workoutExercise.name}"));
                li2.appendChild(exerciseName);

                var ul3 = document.createElement('ul');
                ul3.classList.add('exercisesInWorkout');
                var sets = document.createElement('li');
                var reps = document.createElement('li');
                var weights = document.createElement('li');

                sets.appendChild(document.createTextNode("Sets : ${workoutExercise.sets}"));
                reps.appendChild(document.createTextNode("Reps : ${workoutExercise.sets}"));
                weights.appendChild(document.createTextNode("Weights : ${workoutExercise.sets}"));

                ul3.appendChild(sets);
                ul3.appendChild(reps);
                ul3.appendChild(weights);


                li2.appendChild(ul3);
                ul2.appendChild(li2);
            </c:forEach>

            li.appendChild(ul2);
            ul.appendChild(li);

            x = 0;
            workoutList.appendChild(ul);
            </c:forEach>
        }


    </script>

    <c:choose>
        <%--If the session has a login attribute--%>
    <c:when test="${empty sessionScope.login}">
    <h1>You have to be logged in to add to schedule!</h1>
    </c:when>

        <%--If the session doesn't have a login attribute--%>
    <c:otherwise>
    <sf:form method="POST" modelAttribute="newWorkout" action="/schedule">
    <h1 class="login__heading">Add to schedule</h1>
    <c:if test="${not empty error}"><h4>${error}</h4></c:if>
    <div>
        <label for="workout">Workout: </label>
        <select  id="workout">
            <c:forEach items="${workout}" var="workout">
                <option value="${workout.id}" path="id">
                    ${workout.name}
                </option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label for="date">Date: </label>
        <sf:input id="date" path="date" type="date" required="required"/>
    </div>


    <input class="button" type="submit" VALUE="Add to schedule"/>

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
