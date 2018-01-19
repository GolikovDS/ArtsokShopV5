<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/lightbox/css/lightbox.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/lightbox/js/lightbox-plus-jquery.js"></script>
    <title></title>
</head>
<body>
<p> ${productionPage} </p>
<table class="table-description-production">
    <tr>
        <td><a href="${pageContext.request.contextPath}${production.getFirstImage()}" data-lightbox="roadtrip">
            <img src="${pageContext.request.contextPath}${production.getFirstImage()}"></a></td>
        <td><a href="${pageContext.request.contextPath}${production.getSecondImage()}" data-lightbox="roadtrip">
            <img src="${pageContext.request.contextPath}${production.getSecondImage()}"></a></td>
        <td><a href="${pageContext.request.contextPath}${production.getThirdImage()}" data-lightbox="roadtrip">
            <img src="${pageContext.request.contextPath}${production.getThirdImage()}"></a></td>
    </tr>
    <tr>

    </tr>
</table>
<div>
    <spring:message code="${production.getDescription()}"/>
</div>

<div>
    <form:form method="post" action="/order" modelAttribute="order">
        <p> ${order.getName()}:
            <form:hidden path="name"/>
            <input type="hidden" value="${productionPage}" name="productionPage"/>
            <form:input path="type"/>
            <form:input path="quantity"/>
            <input type="submit" name="submit" value="Продолжить">
        </p>
    </form:form>
</div>
</body>
</html>
