<%--
  Created by IntelliJ IDEA.
  User: kazac
  Date: 18.01.2017
  Time: 4:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${term.name}</h1>
    <c:set var="i" value="${param.get(\"in\")}" scope="page"/>
    ${ocs.contents}
<a href="?in=${param.get("in")+1}">Следующий</a>
</body>
</html>