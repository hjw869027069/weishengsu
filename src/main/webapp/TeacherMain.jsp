<%--
  Created by IntelliJ IDEA.
  User: HJW
  Date: 2021/5/15
  Time: 6:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("utf-8");%>
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教师端主页面</title>

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
            <a >我的课程</a>
        </td>
        <td class="td1">
            <a href="TeacherCenter.jsp">个人中心</a>
        </td>
    </tr>
</table>

<table class="table2">
    <tr>
        <th>编号</th>
        <th>课程名字</th>
        <th>选/必修</th>
        <th>教室</th>
        <th>上课人数</th>
        <th>专业</th>
        <th class="time">上课时间</th>
        <th class="time">下课时间</th>
        <th>评分</th>
        <th class="words">留言</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${requestScope.courses}" var="course" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${course.name}</td>
            <td>${course.course}</td>
            <td>${course.classroom}</td>
            <td>${course.maxNumber}</td>
            <td>${course.major}</td>
            <td>${course.beginTime}</td>
            <td>${course.endTime}</td>
            <td>${requestScope.studentCourses[s.count-1].score}</td>
            <td>${requestScope.studentCourses[s.count-1].words}</td>
            <td>
                <form action="updateCourseServlet">
                    <button type="submit" name="courseId" value="${course.id}">修改课程</button>
                </form>
            </td>

        </tr>

    </c:forEach>
</table>
<span id="error"><strong>${requestScope.search_error}</strong></span>
<span id="error"><strong>${requestScope.add_success}</strong></span>
</body>
</html>
