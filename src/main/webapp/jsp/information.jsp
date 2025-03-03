<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户端</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/information.css">
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
        <!-- 动态内容将在这里加载 -->
        <div data-v-60b18741="" data-v-42925338="" id="base-info" class="base-info">
            <div data-v-60b18741="" class="base-info-head">基本信息</div>
            <div data-v-60b18741="" class="base-info-content">
                <div data-v-60b18741="" class="base-info-content-show">
                    <form data-v-60b18741="" class="el-form base-info-edit-form el-form--label-top el-form--inline" action="${pageContext.request.contextPath}/inform.do">
                        <ul data-v-60b18741="">
                            <li data-v-60b18741="">
                                <div data-v-60b18741="" class="content-show-l">真实姓名</div>
                                <div data-v-60b18741="" class="content-show-r">
                                    <input type="text" id="realName" name="realName" required>
                                </div>
                            </li>
                            <li data-v-60b18741="">
                                <div data-v-60b18741="" class="content-show-l">
                                    <span data-v-60b18741="">用</span>
                                    <span data-v-60b18741="">户</span>
                                    <span data-v-60b18741="">ID</span>
                                </div>
                                <div data-v-60b18741="" class="content-show-r">
                                    <input type="text" id="realID" name="realID" disabled="disabled" required>
                                </div>
                            </li>
                            <li data-v-60b18741="">
                                <div data-v-60b18741="" class="content-show-l">
                                    <span data-v-60b18741="">账</span>
                                    <span data-v-60b18741="">号</span>
                                </div>
                                <div data-v-60b18741="" class="content-show-r no-data">
                                    <input type="text" id="realUserName" name="realUserName" required>
                                </div>
                                <div data-v-60b18741="" class="edit-icon">
                                    <i data-v-60b18741=""></i>编辑
                                </div>
                            </li>
                            <li data-v-60b18741="">
                                <div data-v-60b18741="" class="content-show-l">
                                    <span data-v-60b18741="">性</span>
                                    <span data-v-60b18741="">别</span>
                                </div>
                                <div data-v-60b18741="" class="content-show-r">
                                    <input type="text" id="realSex" name="realSex" required>
                                </div>
                            </li>

                            <li data-v-60b18741="">
                                <div data-v-60b18741="" class="content-show-l">电话号码</div>
                                <div data-v-60b18741="" class="content-show-r no-data">
                                    <input type="text" id="realPhone" name="realPhone" required>
                                </div>
                                <div data-v-60b18741="" class="edit-icon">
                                    <i data-v-60b18741=""></i>编辑
                                </div>
                            </li>
                            <li data-v-60b18741="">
                                <div data-v-60b18741="" class="content-show-l">
                                    <span data-v-60b18741="">邮</span>
                                    <span data-v-60b18741="">箱</span>
                                </div>
                                <div data-v-60b18741="" class="content-show-r">
                                    <div data-v-60b18741="" class="add-btn-wrap">
                                        <input type="text" id="realEmail" name="realEmail" required>
                                    </div>
                                </div>
                            </li>
                            <li data-v-60b18741="">
                                <div data-v-60b18741="" class="content-show-l">
                                    <span data-v-60b18741="">学</span>
                                    <span data-v-60b18741="">校</span>
                                </div>
                                <div data-v-60b18741="" class="content-show-r no-data">
                                    <input type="text" id="realCollege" name="realCollege" required>
                                </div>
                            </li>
                        </ul>
                        <button type="submit">修改信息</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
<script src="${pageContext.request.contextPath}/js/information.js"></script>
</body>
</html>
