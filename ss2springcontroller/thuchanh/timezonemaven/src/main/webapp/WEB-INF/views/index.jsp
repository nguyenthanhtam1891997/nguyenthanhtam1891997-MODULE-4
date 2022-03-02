<%--
  Created by IntelliJ IDEA.
  User: tinh3
  Date: 01/03/2022
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Current local times around the world</h2>
<span>Current time in ${city}: <strong>${date}</strong></span>
<form id="locale" action="/world-clock" method="get">
    <select name="city" onchange="document.getElementById('locale').submit()">
        <option value="Asia/Ho_Chi_Minh" selected>Select a city</option>
        <option value="Singapore" >Singapore</option>
        <option value="Asia/Tokyo" >Tokyo</option>
        <option value="Asia/Seoul" >Seoul</option>
        <option value="Europe/London" >London</option>
        <option value="Europe/Madrid" >Madrid</option>
        <option value="America/New_York" >New_York</option>
        <option value="Australia/Sydney" >Sydney</option>
        <option value="Argentina/Buenos_Aires" >Buenos_Aires</option>
    </select>
</form>
</body>
</html>
