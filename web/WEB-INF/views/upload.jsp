<%--
  Created by IntelliJ IDEA.
  User: kazac
  Date: 15.01.2017
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Загрузить</title>
</head>
<body>
    <h>Выберите фал с лекцией</h>
    ${res} <br>
    <form enctype="multipart/form-data" method="post" >
        <p><input type="file" name="lecture" >
            <input type="submit" value="Отправить"></p>
    </form>
</body>
</html>
