<%--
  Created by IntelliJ IDEA.
  User: kazac
  Date: 18.01.2017
  Time: 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Top</title>
</head>
<body>
    <h1>Самые важные термины:</h1>
    <table>
        <c:set var="i" value="${0}" scope="page"/>
        <c:forEach items="${toplist}" var="term">
            <tr>
                <td>
                    <a href="/easyL/topterms/${i}"/> ${term.name}
                </td>
                <td>
                    ${term.occureness}
                </td>
            </tr>
            <c:set var="i" value="${i+1}"/>
        </c:forEach>
    </table>
</body>
</html>
