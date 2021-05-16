<%--
  Created by IntelliJ IDEA.
  User: HJW
  Date: 2021/5/13
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("utf-8");%>
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>课程系统学生端主页面</title>

    <style>

        body{
            background: url("img/bg.jpg") no-repeat fixed center;
            /*设置图片为无重复居中的背景图片*/

            background-size:cover;
            /*将背景图片覆盖整个屏幕*/
        }

        #img{
            width: 80px;
            padding-left: 700px;
            padding-top: 10px;
        }

        .welcome{
            padding-left: 700px;
        }

        .table1{
            border: 1px solid;

            width: 600px;
            margin-left: 450px;
        }

        .td1{
            border: 1px solid;
        }

        th{
            text-align: center;
            border: 1px solid;
        }

        .table2{
            border: 1px solid;

            border-collapse:collapse;

            margin: 10px auto auto;
        }

        tr,td{
            text-align: center;
            border: 1px solid ;
        }

        #search{
            border:1px solid #A6A6A6;
            border-radius:5px;

            margin-right: 5px;
        }

        .time{
            width: 100px;
        }

        #error{
            padding-left: 650px;
        }

    </style>
</head>
<body>
<img src="img/bgp.jpg" id="img" alt="图标"><br>
<span class="welcome">你好,${sessionScope.user.name}<br></span>
<span class="welcome">身份:${sessionScope.identity}<br></span>

<table class="table1">
    <tr class="tr1">
        <td class="td1">
            <a>我的课表</a>
        </td>
        <td class="td1">
            <a href="studentChooseCourseServlet">添加选修</a>
        </td>
        <td class="td1">
            <a href="courseEvaluateServlet">课程评价</a>
        </td>
        <td class="td1">
            <a href="StudentCenter.jsp">个人中心</a>
        </td>
    </tr>

    <tr>
        <td colspan="4">
            <form action="searchCourseServlet" method="post">
                <label for="search"></label><input type="text" placeholder="请输入课名查找" id="search" name="courseName"><input type="submit" value="搜索">
            </form>
        </td>
    </tr>
</table>

<table class="table2">
    <tr>
        <th>编号</th>
        <th>课程名字</th>
        <th>老师</th>
        <th>选/必修</th>
        <th>教室</th>
        <th>上课人数</th>
        <th>年级</th>
        <th>专业</th>
        <th class="time">上课时间</th>
        <th class="time">下课时间</th>
    </tr>

    <c:forEach items="${requestScope.courses}" var="course" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${course.name}</td>
            <td>${requestScope.names[s.count-1]}</td>
            <td>${course.course}</td>
            <td>${course.classroom}</td>
            <td>${course.maxNumber}</td>
            <td>${course.grade}</td>
            <td>${course.major}</td>
            <td>${course.beginTime}</td>
            <td>${course.endTime}</td>
        </tr>

    </c:forEach>
</table>
<span id="error"><strong>${requestScope.search_error}</strong></span>
</body>
</html>
