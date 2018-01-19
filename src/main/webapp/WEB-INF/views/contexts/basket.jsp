<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.08.2017
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<p>Корзина</p>

<div>
    <form:form method="post" action="/buy">
        <input type="submit" name="submit" value="Купить">
    </form:form>
</div>
</body>
</html>
