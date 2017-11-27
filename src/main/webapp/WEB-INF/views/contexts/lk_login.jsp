<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/lk.css">

</head>
<body>
<div id="login-form">
    <div class="tab">
        <button class="tablinks" onclick="openCity(event, 'login')">Вход</button>
        <button class="tablinks" onclick="openCity(event, 'registration')">Регистрация</button>
    </div>


    <div id="login" class="tabcontent">
        <form method="post" name="form_login" action="/login" class="form-4">
            <p>
                <input type="text" name="username" placeholder="Имя"/>
            </p>

            <p>
                <input type="password" name="password" placeholder="Пароль"/>
            </p>

            <p>
                <input type="submit" name="submit" value="Продолжить">
            </p>
            <p>${error}</p>
        </form>
    </div>

    <div id="registration" class="tabcontent">
        <form:form method="post" action="/registration" modelAttribute="user" cssClass="form-4">
            <p>
                <label>username</label>
                <input type="text" name="username" id="emailReg" placeholder="username" required>

                    <%--<p id="errEmailText" style="visibility: hidden; color: #FF434C;">Не верно введен адрес</p>--%>

            </p>

            <p>
                <label>Имя</label>
                <input type="text" name="firstName" placeholder="Имя" required>
            </p>

            <p>
                <label>Фамилия</label>
                <input type="text" name="lastName" placeholder="Фамилия" required>
            </p>

            <p>
                <label>Отчество</label>
                <input type="text" name="middleName" placeholder="Отчество" required>
            </p>

            <p>
                <label>Телефон</label>
                <input type="text" name="phone" id="phoneReg" placeholder="Телефон" required>
                    <%--<p id="errPhoneText" style="visibility: hidden; color: #FF434C;">Не верно введен телефон</p>--%>

            </p>

            <p>
                <label>Компания</label>
                <input type="text" name="company" placeholder="Компания" required>
            </p>

            <p>
                <label>Пароль</label>
                <input type="text" name="password" id="passwordReg" placeholder="Пароль" required>

            <p id="errPasswordText" style="visibility: hidden; color: #FF434C;">Минимальное кол-во символов 3</p>


            <p>
                <input type="submit" name="submitReg" id="submitReg" value="Продолжить">
            </p>
        </form:form>
    </div>
</div>
<script>
    function openCity(evt, cityName) {
        var i, tabcontent, tablinks;
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }
        document.getElementById(cityName).style.display = "block";
        evt.currentTarget.className += " active";
    }
    document.getElementById("login").style.display = "block";

    document.getElementById("submitReg").addEventListener("click", function () {
        if (document.getElementById("passwordReg").value.length < 3) {
            document.getElementById("passwordReg").style.cssText = "box-shadow: 0 0 20px 1px #ffa70b;";
            document.getElementById("errPasswordText").style.cssText = "visibility: visible;";
        } else {
            document.getElementById("passwordReg").style.cssText = "box-shadow: none;";
            document.getElementById("errPasswordText").style.cssText = "visibility: hidden;";
            this.submit();
        }
//        var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
//        if (pattern.test(document.getElementById("emailReg"))) {
//            document.getElementById("emailReg").style.cssText = "box-shadow: 0 0 20px 1px #ffa70b;";
//            document.getElementById("errEmailText").style.cssText = "visibility: visible;";
//        }else{
//            document.getElementById("emailReg").style.cssText = "box-shadow: none;";
//            document.getElementById("errEmailText").style.cssText = "visibility: hidden;";
//        }
    });
</script>
</body>
</html>
