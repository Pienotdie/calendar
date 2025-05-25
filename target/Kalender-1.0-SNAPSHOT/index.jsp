<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <link href="main.css" rel="stylesheet" type="text/css">
    <title>Kalender</title>

</head>
<body>
<h1>Hello World</h1>

<div class="calendar-container">

    <!-- Wochentage -->
    <div class="days-container">
        <ul class="days">
            <c:forEach var="day" items="${weekDays}">
                <li>${day.dayOfWeek}, ${day.dayOfMonth}</li>
            </c:forEach>
        </ul>
    </div>

    <!-- Zeit -->
    <div class="time-container">
        <ul class="times">
            <c:forEach var="h" begin="8" end="20">
                <li>${h}:00</li>
            </c:forEach>
        </ul>
    </div>

    <!-- Events -->
    <c:forEach var="e" items="${events}">
        <div class="event"
             style="top:${e.topPx}px; left:${60 + (e.dayOfWeekIndex - 1) * (1000 / 7)}px;
                     height:${e.heightPx}px; width:${(1000 / 7) - 4}px;">
            <strong>${e.title}</strong><br>
            <small>${e.formattedTimeRange}</small>
        </div>
    </c:forEach>
</div>

</body>
</html>
