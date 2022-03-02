<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: tinh3
  Date: 02/03/2022
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<form:form modelAttribute="mail" method="post" action="name">
    <table class="table">


        <tr>

            <td>Languages</td>
            <td colspan="4" >
                <form:select path="language">
                    <form:option value="English">English</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                    <form:option value=" Chinese">Chinese</form:option>
                </form:select>
            </td>
        </tr>
        <tr>

            <td>Page Size</td>
            <td>Show</td>
            <td>
                <form:select path="fontSize">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100">100</form:option>
                </form:select>
            </td>
            <td colspan="2">emails per page</td>
        </tr>
        <tr>
            <td>Page Size</td>
            <td><form:checkbox path="filter" value="1"></form:checkbox></td>
            <td colspan="3">Enable spams filter</td>

        </tr>
        <tr>
            <td>Signature</td>
            <td colspan="4"><form:textarea path="signature" ></form:textarea></td>

        </tr>
        <tr>
            <td></td>
            <td colspan="2"><input type="submit" value="Update"></td>
            <td colspan="2"><input type="reset" value="Cancel"></td>

        </tr>

    </table>
</form:form>

</body>
</html>
