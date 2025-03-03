<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>考试信息管理界面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/PublishExam.css">
</head>
<body>
<header class="publicHeader">
    <h1>网络安全协会考试系统</h1>
    <span class="publicHeaderR"></span>
</header>
<div class="container">
    <div class="sidebar">
        <ul>
            <li class="menu-item">
                <a href="${pageContext.request.contextPath }/jsp/homepageManage.jsp"><h3 class="h3">首页</h3></a>
            </li>
            <li class="menu-item">
                <a href="${pageContext.request.contextPath }/jsp/PublishExam.jsp"><h3 class="h3">发布考试</h3></a>
            </li>
            <li class="menu-item">
                <a href="${pageContext.request.contextPath }/jsp/ExaminationInformation.jsp"><h3 class="h3">考试报名信息</h3></a>
            </li>
            <li class="menu-item">
                <a href="${pageContext.request.contextPath }/jsp/ManagerLaboratory.jsp"><h3 class="h3">实验室申请</h3></a>
            </li>
            <li class="menu-item">
                <a href="${pageContext.request.contextPath }/jsp/ManagerInformation.jsp"><h3 class="h3">个人信息</h3></a>
            </li>
            <li class="menu-item">
                <a href="${pageContext.request.contextPath }/indout.do"><h3 class="h3">退出登录</h3></a>
            </li>
        </ul>
    </div>
    <div class="main-content">
        <div class="box">
            <form method="post" action="${pageContext.request.contextPath}/public.do">
                <ul>
                    <li>
                        <label for="examTime">考试时间：</label>
                        <input type="datetime-local" id="examTime" name="examTime" required>
                    </li>
                    <li>
                        <label for="deadline">考试截止时间：</label>
                        <input type="datetime-local" id="deadline" name="deadline" required>
                    </li>
                    <li>
                        <label for="examAddress">考试地址：</label>
                        <input type="text" id="examAddress" name="examAddress" required>
                    </li>
                    <li>
                        <label for="maxParticipants">最大报名人数：</label>
                        <input type="number" id="maxParticipants" name="maxParticipants" min="1" required>
                    </li>
                    <li>
                        <input type="submit" value="发布考试">
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>
</body>
</html>