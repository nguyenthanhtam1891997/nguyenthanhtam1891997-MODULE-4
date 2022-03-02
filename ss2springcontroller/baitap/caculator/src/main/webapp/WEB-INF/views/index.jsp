<%--
  Created by IntelliJ IDEA.
  User: tinh3
  Date: 02/03/2022
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
 <form action="calculator" method="post">
     <input type="number" name="num1">
     <input type="number" name="num2"><br>
     <input type="submit" name="calculate" value="+">
     <input type="submit" name="calculate" value="-">
     <input type="submit" name="calculate" value="*">
     <input type="submit" name="calculate" value="/"><br>
 </form>
  <h3>${result}</h3>

  </body>
</html>
