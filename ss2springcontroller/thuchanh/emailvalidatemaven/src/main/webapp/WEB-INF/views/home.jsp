<%--
  Created by IntelliJ IDEA.
  User: tinh3
  Date: 01/03/2022
  Time: 09:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Email validate</h1>
<h3>${message}</h3>
<form action="/validate" method="post">
<input type="text" name="email"><br>
<input type="submit" value="validate" >
</form>
</body>
</html>
