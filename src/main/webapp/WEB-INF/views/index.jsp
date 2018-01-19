<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/index.css">

    <title></title>
</head>
<body>
<div class="head">
    <table>
        <tr>
            <td style="width: 50px">
                <a href="/index"><img src="../../resources/images/logo.gif"></a>
            </td>
            <td style="width: 1000px">
                <form:form method="post" action="/menu">
                    <div id="button-menu-group">
                        <button class="btnMenu" name="about"><spring:message code="about"/></button>
                        <button class="btnMenu" name="kat"><spring:message code="production"/></button>
                        <button class="btnMenu" name="contacts"><spring:message code="contacts"/></button>
                        <button class="btnMenu" name="basket"><spring:message code="basket"/></button>
                        <button class="btnMenu" name="login"><spring:message code="login"/></button>

                        <c:choose>
                            <c:when test="${username=='admin'}">
                                <button class="btnMenu" name="admin"><spring:message code="admin"/></button>
                            </c:when>
                        </c:choose>
                    </div>
                </form:form>
            </td>
            <%--<td style="color: #ffa70b;">${username}</td>--%>
            <td>
                 <span style="float: right; right: 15px;">
    <a href="?lang=en"><img src="${pageContext.request.contextPath}/resources/images/en_local.jpg"
                            style="width: 23px; height: 15px;"></a>
    <a href="?lang=ru"><img src="${pageContext.request.contextPath}/resources/images/ru_local.jpg"
                            style="width: 23px; height: 15px;"></a>
    </span>
            </td>
        </tr>
    </table>
</div>

<div id="context">
    <jsp:include page="${context}"/>
</div>


<div id="bottom">
    <p>
        (495) 775-27-96,
        (495) 745-74-34
        Россия, 142771 г.Москва, ул. Адмирала Корнилова (п. Мосрентген), владение 28.</p>
</div>

</body>
</html>

