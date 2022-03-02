<%--
  Created by IntelliJ IDEA.
  User: tinh3
  Date: 01/03/2022
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
 <h3>Sandwich Condiments</h3>
  <form action="/sandwich" method="post">
        <input type="checkbox" name="list" value="Lettuce" id="Lettuce">
      <label for="Lettuce">Lettuce</label><br>
      <input type="checkbox" name="list" value="Tomato" id="Tomato">
      <label for="Tomato">Tomato</label><br>
      <input type="checkbox" name="list" value="Mustard" id="Mustard">
      <label for="Mustard">Mustard</label><br>
      <input type="checkbox" name="list" value="Sprouts" id="Sprouts">
      <label for="Sprouts">Sprouts</label><br>


      <input type="submit" value="save">
  </form>
  <h3>${check} </h3>
<c:forEach var="item" items="${list}">
    <span>${item}</span><br>
</c:forEach>
  </body>
</html>
