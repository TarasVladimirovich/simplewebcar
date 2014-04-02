<%@ page import="org.tarascar.webapp.User" %>
<%@ page import="org.tarascar.webapp.models.Car" %>
<%--
  Created by IntelliJ IDEA.
  User: iAmater
  Date: 02.04.14
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<div>
    <table align="right">
        <tr>
            <td>
                <b>Welcome  <%= ((User) session.getAttribute("user")).getLogin()%>!</b>
            </td>
        </tr>
        <tr>
            <td>
                <form action="exit" method="POST">
                    <input type="submit" value="exit">
                </form>
            </td>
        </tr>
        </tr>
    </table>
</div>
</br>

<%
    Car car = (Car) request.getAttribute("editcar");
%>

<table>
    <tr>
        Brand <input name="Brand" value="<%=car.getBrand()%>" disabled>
        Type<input name="CarType" value="<%=car.getCarType()%>" disabled>
        Color <input name="Color" value="<%=car.getColor()%>" disabled>
        Age<input name="Age" value="<%=car.getAge()%>" disabled>
        Number<input name="bodyNumber" value="<%=car.getBodyNumber()%>" disabled>
    </tr>
    </br>
    Input new information for Car
    </br>
    <tr>
        <form action="editCarSecond" method="POST">
            Brand <label for="Brand"/> <input id="Brand" name="Brand" value="<%=car.getBrand()%>">
            Type<label for="CarType"/> <input id="CarType" name="CarType" value="<%=car.getCarType()%>">
            Color <label for="Color"/> <input id="Color" name="Color" value="<%=car.getColor()%>">
            Age <label for="Age"/> <input id="Age" name="Age" value="<%=car.getAge()%>">
            Number <label for="bodyNumber"/> <input id="bodyNumber" name="bodyNumber" value="<%=car.getBodyNumber()%>">


            <input type="hidden" name="userEdit" value="<%=car.getBodyNumber()%>"/>
            <input type="submit" value="edit">

        </form>
    </tr>
</table>

</body>
</html>
