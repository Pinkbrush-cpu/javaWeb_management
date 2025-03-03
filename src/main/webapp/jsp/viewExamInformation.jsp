<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户端</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/viewExamInformation.css">
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
        <div id="content-placeholder">
            <div class="query-box">
                <h1>考试报名信息</h1>
            </div>

            <table id="studentTable" >
                <thead>
                <tr>
                    <th>考试id</th>
                    <th>id</th>
                    <th>姓名</th>
                    <th>考试科目</th>
                    <th>电话</th>
                    <th>专业</th>
                    <th>考试时间</th>
                    <th>成绩</th>
                </tr>
                </thead>
                <tbody id="examTbody" class="examTbody">
                <!-- 学生信息将通过JavaScript动态填充 -->
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/viewExamInformation.js"></script>
</body>
</html>
