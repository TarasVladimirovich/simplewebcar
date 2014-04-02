<%@ page import="org.tarascar.webapp.User" %>
<%@ page import="org.tarascar.webapp.models.*" %>
<%@ page import="java.util.HashSet" %>
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

<table width="200" border="1" cellpadding="0" cellspacing="0">
    <tr>
        <form action="filter" method="POST">
            <td>
                <SELECT name="brand">
                    <option selected disabled>Select car</option>
                    <%
                        for (Brand brand : Brand.values()) {
                    %>
                    <OPTION name="brand" value="<%=brand.toString()%>"><%=brand.toString()%>
                    </OPTION>

                    <%
                        }
                    %>
                </SELECT>
            </td>
            <td>
                <SELECT name="carType">
                    <option selected disabled>Select Type</option>
                    <%
                        for (CarType carType : CarType.values()) {
                    %>
                    <OPTION name="carType" value="<%=carType.toString()%>"><%=carType.toString()%>
                    </OPTION>

                    <%
                        }
                    %>
                </SELECT>
            </td>
            <td>
                <SELECT name="color">
                    <OPTION selected disabled>Select Color</OPTION>
                    <%
                        for (Color color : Color.values()) {
                    %>
                    <OPTION name="color" value="<%=color.toString()%>"><%=color.toString()%>
                    </OPTION>

                    <%
                        }
                    %>
                </SELECT>
            </td>
            <td>
                <SELECT name="age">
                    <option selected disabled>Select Age</option>
                    <%
                        for (Age age : Age.values()) {
                    %>
                    <OPTION name="age" value="<%=age.toString()%>"><%=age.toString()%>
                    </OPTION>

                    <%
                        }
                    %>
                </SELECT>
            </td>
            <td align="center"><input type="submit" value="filter"></td>
        </FORM>
        <td align="center">
            <form action="users" method="get">
                <input type="submit" value="reset filter">
            </form>
        </td>
    </tr>

    <tr align="center" style="color:red;">
        <th width="100" scope="col">Brand</th>
        <th width="100" scope="col">Car Type</th>
        <th width="100" scope="col">Color</th>
        <th width="100" scope="col">Age</th>
        <th width="100" scope="col">bodyNumber</th>
        <th width="100" scope="col">DeleteButton</th>
        <th width="100" scope="col">EditButton</th>
    </tr>

    <%
        HashSet<Car> cars = (HashSet<Car>) request.getAttribute("cars");
        for (Car car : cars) {
    %>

    <tr align="center" style="color:green;">
        <td><%=car.getBrand()%>
        </td>
        <td><%=car.getCarType()%>
        </td>
        <td><%=car.getColor()%>
        </td>
        <td><%=car.getAge()%>
        </td>
        <td><%=car.getBodyNumber()%>
        </td>
        <td>
            <form action="del" method="POST">
                <input type="hidden" name="bodyNumber" value=<%=car.getBodyNumber()%>>
                <input type="submit" value="delete">
            </form>
        </td>
        <td>
            <form action="edit" method="POST">
                <input type="hidden" name="bodyNumber" value=<%=car.getBodyNumber()%>>
                <input type="submit" value="edit">
            </form>
        </td>
    </tr>
    <%
        }
    %>
    <tr>
        <form action="addCar" method="POST">
            <td>
                <SELECT name="brand">
                    <option selected disabled>Select car</option>
                    <%
                        for (Brand brand : Brand.values()) {
                    %>
                    <OPTION name="brand" value="<%=brand.toString()%>"><%=brand.toString()%>
                    </OPTION>

                    <%
                        }
                    %>
                </SELECT>
            </td>
            <td>
                <SELECT name="carType">
                    <option selected disabled>Select Type</option>
                    <%
                        for (CarType carType : CarType.values()) {
                    %>
                    <OPTION name="carType" value="<%=carType.toString()%>"><%=carType.toString()%>
                    </OPTION>

                    <%
                        }
                    %>
                </SELECT>
            </td>
            <td>
                <SELECT name="color">
                    <OPTION selected disabled>Select Color</OPTION>
                    <%
                        for (Color color : Color.values()) {
                    %>
                    <OPTION name="color" value="<%=color.toString()%>"><%=color.toString()%>
                    </OPTION>

                    <%
                        }
                    %>
                </SELECT>
            </td>
            <td><label/> <input name="age"></td>
            <td><label/> <input name="bodyNumber"></td>
            <td><input type="submit" value="add car"></td>
        </form>
    </tr>
</table>
</body>
</html>
