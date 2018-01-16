<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.01.2018
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
ADMIN PAGE


<form method="POST" action="uploadFile" enctype="multipart/form-data">
    File to upload: <input type="file" name="file"><br />

    <input type="submit" value="Upload">
    Press here to upload the file!
</form>

<%--<table>--%>
    <%--<tr>--%>
        <%--<td>--%>
            <%--<div class="div-production">--%>
                <%--<p>Окно выбора</p>--%>
                <%--<form:form method="post" enctype="multipart/form-data">--%>
                    <%--<input name="image" type="file">--%>
                <%--</form:form>--%>
            <%--</div>--%>
        <%--</td>--%>
        <%--<td>--%>
            <%--<div class="description_production_admin">--%>
                <%--<table>--%>
                    <%--<tr>--%>
                        <%--<td><img src="">--%>
                        <%--</td>--%>
                        <%--<td><img src="">--%>
                        <%--</td>--%>
                        <%--<td><img src="">--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td><p>dssssssssssssssssssssss</p></td>--%>
                    <%--</tr>--%>
                <%--</table>--%>
                <%--<input type="text">--%>
            <%--</div>--%>
        <%--</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--&lt;%&ndash;<form:input path=""></form:input>&ndash;%&gt;--%>
    <%--</tr>--%>
<%--</table>--%>
</body>
</html>
