<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.01.2018
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

</head>
<body>
<h1>Продуция</h1>
<table class="table-production">
    <tr>
        <jsp:useBean id="production" scope="request" type="java.util.List"/>
        <c:forEach var="production" items="${production}">
            <td>
                <form:form method="post" action="kat" class="div-production">
                    <button value="${production.getNameProduction()}" name="mgp">
                        <img src="${pageContext.request.contextPath}${production.getMainImage()}">
                        <p>${production.getMainText()}</p>
                    </button>
                </form:form>
            </td>
            ${production.getNewLine()}
        </c:forEach>
    </tr>
</table>
</body>
</html>
