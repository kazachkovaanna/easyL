<%--
  Created by IntelliJ IDEA.
  User: kazac
  Date: 16.01.2017
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Кратко</title>
</head>
<body>
<h1>Краткое содержание курса</h1>
<c:forEach items="${map}" var="item" >
    <h3>${item.key.name}</h3>
    ${item.value.contetns}<br>
</c:forEach>
</body>
</html>
