<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tinh3
  Date: 02/03/2022
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<form:form action="name" method="post" modelAttribute="login">
    <fieldset>
        
        <legend>Login</legend>
        <table class="table">
            <tr>
               
                <td><form:label path="account">Account: </form:label></td>
                <td><form:input path="account" /></td>
            </tr>
            <tr>
                <td><form:label path="password">Password: </form:label></td>
                <td><form:input path="password" /></td>

            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">Submit</button>

                </td>

            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
