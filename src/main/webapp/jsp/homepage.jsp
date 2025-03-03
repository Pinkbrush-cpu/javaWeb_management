<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户端</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/homepage.css">
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
                <a href="${pageContext.request.contextPath }/jsp/homepage.jsp">
                    <h3 class="h3">首页</h3>
                </a>
            </li>
            <li class="menu-item">
                <a href="${pageContext.request.contextPath }/jsp/examination.jsp">
                    <h3 class="h3">考试报名</h3>
                </a>
            </li>
            <li class="menu-item">
                <a href="${pageContext.request.contextPath }/jsp/viewExamInformation.jsp">
                    <h3 class="h3">考试报名信息</h3>
                </a>
            </li>
            <li class="menu-item">
                <a href="${pageContext.request.contextPath }/jsp/laboratoryadmission.jsp">
                    <h3 class="h3">进入实验室申请</h3>
                </a>
            </li>
            <li class="menu-item">
                <a href="${pageContext.request.contextPath }/jsp/information.jsp">
                    <h3 class="h3">个人信息</h3>
                </a>
            </li>
            <li class="menu-item">
                <a href="${pageContext.request.contextPath }/indout.do">
                    <h3 class="h3">退出登录</h3>
                </a>
            </li>

        </ul>
    </div>
    <div class="main-content" >
        <div class="chi-content" >

        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/homepage.js"></script>
</body>
</html>
