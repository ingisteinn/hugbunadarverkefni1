<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script type="text/javascript">
        window.onload = function() {

            var dps = [[]];
            var chart = new CanvasJS.Chart("chartContainer", {
                theme: "light2", // "light1", "dark1", "dark2"
                animationEnabled: true,
                title: {
                    text: "Your progress"
                },
                axisX: {
                    valueFormatString: "MMM YYYY"
                },
                axisY: {
                    title: "Weight(in kg)",
                    suffix: " kg"
                },
                data: [{
                    type: "line",
                    xValueType: "dateTime",
                    xValueFormatString: "D MMM YYYY",
                    yValueFormatString: "#.# kg",
                    dataPoints: dps[0]
                }]
            });

            var xValue;
            var yValue;

            <c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">
            <c:forEach items="${dataPoints}" var="dataPoint">
            xValue = parseInt("${dataPoint.x}");
            yValue = parseFloat("${dataPoint.y}");
            dps[parseInt("${loop.index}")].push({
                x : xValue,
                y : yValue
            });
            </c:forEach>
            </c:forEach>

            chart.render();

        }
    </script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles.css"/>"/>
</head>
<body>
<%@include file="/WEB-INF/jsp/Header.jsp" %>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>