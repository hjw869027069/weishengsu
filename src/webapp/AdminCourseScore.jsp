<%--
  Created by IntelliJ IDEA.
  User: HJW
  Date: 2021/5/16
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("utf-8");%>
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>课程评分情况</title>
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
            <a href="adminMainServlet">用户管理</a>
        </td>
        <td class="td1">
            <a href="adminApplicationServlet">查看申请 </a>
        </td>
        <td class="td1">
            <a>课程评分情况 </a>
        </td>
        <td class="td1">
            <a href="AdminCenter.jsp">个人中心</a>
        </td>
    </tr>
</table>

<table class="table2">
    <tr>
        <th>编号</th>
        <th>课程</th>
        <th>课程老师</th>
        <th>分数</th>
        <th>评分人</th>
    </tr>

    <c:forEach items="${requestScope.studentCourses}" var="studentCourse" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${requestScope.courseNames[s.count-1]}</td>
            <td>${requestScope.teacherNames[s.count-1]}</td>
            <td>${studentCourse.score}</td>
            <td>${requestScope.names[s.count-1]}</td>
        </tr>

    </c:forEach>
</table>

<span id="error"><strong>${requestScope.search_error}</strong></span>

</body>
</html>
