<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1 style="color:#36C" align="center">Вход в simpleWebCar</h1>


<div>
    <form action="log" method="post">
        <div align="center">
            <%--@declare id="login"--%>
            <%--@declare id="passwords"--%>
            <b>Логин: </b>
            <label for="login"/><input id="login" name="login"/>
        </div>

        <div align="center">
            <b>Пароль: </b>
            <label for="passwords"/><input type="password" id="passwords"
                                           name="passwords"/>
        </div>

        <div align="center">
            <input type="submit" value="Log On">
        </div>
    </form>

    <div style="color:red" align="center">
        Внимание! Регистр букв имеет значение
    </div>
</div>


</body>
</html>
