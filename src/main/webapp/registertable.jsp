<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/registertable.css">
</head>
<body>
<div class="container">
    <header>
        <h1>用户注册</h1>
    </header>

    <main>
        <form id="register-form" action="${pageContext.request.contextPath}/register.do"  name="registerForm" id="registerForm"  method="post">
            <div class="form-group01">
                <label for="inputName">真实姓名:
                    <span id="nameDiv"></span>
                </label>
                <input type="text" id="inputName" name="name" required>
            </div>

            <div class="form-group02">
                <label for="inputUsername">账号:
                    <span id="usernameDiv"></span>
                </label>
                <input type="text" id="inputUsername" name="username" required>
            </div>

            <div class="form-group03">
                <label for="inputPassword">密码:
                    <span id="passwordDiv"></span>
                </label>
                <input type="password" id="inputPassword" name="password" required>
            </div>

            <div class="form-group04">
                <label for="inputSex">性别:
                    <span id="sexDiv"></span>
                </label>
                <input type="text" id="inputSex" name="sex" required>
            </div>

            <div class="form-group05">
                <label for="inputPhonenumber">手机号:
                    <span id="phonenumberDiv"></span>
                </label>
                <input type="tel" id="inputPhonenumber" name="phonenumber" required>
            </div>

            <div class="form-group06">
                <label for="inputEmail">邮箱:
                    <span id="emailDiv"></span>
                </label>
                <input type="email" id="inputEmail" name="email">
            </div>

            <div class="links">
                <a href="${pageContext.request.contextPath}/index.jsp">已有账号，去登陆</a>
                <button type="submit"> 注册 </button>
            </div>

        </form>
    </main>
</div>

<script src="${pageContext.request.contextPath}/js/registertable.js"></script>
</body>
</html>