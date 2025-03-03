<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录界面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index_styles.css">

</head>
<body>
<section class="loginBox">
    <div class="container">
        <div class="login-box">
            <h2>登录</h2>
            <form class="loginForm" action="${pageContext.request.contextPath}/index.do"  name="loginForm" id="loginForm"  method="post" >
                <div class="input-group">
                    <label for="username">账号</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="input-group">
                    <label for="password">密码</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <button type="submit">登录</button>
            </form>
            <div class="links">
                <a href="${pageContext.request.contextPath}/registertable.jsp">还没有账号？注册</a>
                <a href="${pageContext.request.contextPath}/forgotpassword.jsp">忘记密码？</a>
            </div>
        </div>
    </div>
<%--<script src="${pageContext.request.contextPath}/js/scripts.js"></script>--%>
</section>
</body>
</html>