<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户端</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/examination.css">
</head>
<body>
<header class="publicHeader">
    <h1>网络安全协会考试系统</h1>
    <span class="publicHeaderR">

    </span>
</header>
<div class="container">
    <div class="sidebar">
        <ul>
            <li class="menu-item">
                <a href="${pageContext.request.contextPath }/jsp/homepage.jsp"><h3 class="h3">首页</h3></a>
            </li>
            <li class="menu-item">
                <a href="${pageContext.request.contextPath }/jsp/examination.jsp"><h3 class="h3">考试报名</h3></a>
            </li>
            <li class="menu-item">
                <a href="${pageContext.request.contextPath }/jsp/viewExamInformation.jsp"><h3 class="h3">考试报名信息</h3></a>
            </li>
            <li class="menu-item">
                <a href="${pageContext.request.contextPath }/jsp/laboratoryadmission.jsp"><h3 class="h3">进入实验室申请</h3></a>
            </li>
            <li class="menu-item">
                <a href="${pageContext.request.contextPath }/jsp/information.jsp"><h3 class="h3">个人信息</h3></a>
            </li>
            <li class="menu-item">
                <a href="${pageContext.request.contextPath }/indout.do"><h3 class="h3">退出登录</h3></a>
            </li>
        </ul>
    </div>
    <div class="main-content">
        <div  id="content-placeholder">
            <!-- 动态内容将在这里加载 -->
            <section class="info-section">
                <h2>报名须知</h2>
                <p>请仔细阅读以下报名须知，确保您符合报名条件并准备好所有必要的材料。</p>
                <ul id="examNeed"></ul>
            </section>
            <section class="form-section">
                <h2>报名表单</h2>
                <form id="registrationForm" action="${pageContext.request.contextPath}/exam.do">
                    <label for="project">考试项目：</label>
                    <select id="project" name="project">
                        <option value="java">java</option>
                        <option value="javaweb" selected>javaweb</option>
                        <option value="computer">网络安全</option>
                    </select>

                    <label for="name">姓名：</label>
                    <input type="text" id="name" name="name" required>

                    <label for="major">专业名称：</label>
                    <input type="tel" id="major" name="major" required>

                    <label for="phone">联系电话：</label>
                    <input type="tel" id="phone" name="phone" required>

                    <button type="submit">提交报名</button>
                </form>
            </section>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/examination.js"></script>
</body>
</html>
