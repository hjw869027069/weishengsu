<%--
  Created by IntelliJ IDEA.
  User: HJW
  Date: 2021/5/15
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("utf-8");%>
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>申请记录</title>
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
            <a href="teacherMainServlet">我的课程</a>
        </td>
        <td class="td1">
            <a href="TeacherCenter.jsp">个人中心</a>
        </td>
    </tr>
</table>

<table class="table2">
    <caption>申请记录</caption>
    <tr>
        <th>编号</th>
        <th>课程</th>
        <th>考试教室</th>
        <th>考试人数</th>
        <th class="time">申请时间</th>
        <th class="time">开始时间</th>
        <th class="time">结束时间</th>
        <th>申请情况</th>
    </tr>

    <c:forEach items="${requestScope.applications}" var="application" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${requestScope.names[s.count-1]}</td>
            <td>${application.classroom}</td>
            <td>${application.number}</td>
            <td>${application.applyTime}</td>
            <td>${application.beginTime}</td>
            <td>${application.endTime}</td>
            <td>${requestScope.situations[s.count-1]}</td>
        </tr>

    </c:forEach>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td>
            <form action="AddApplication.jsp">
                <button type="submit">添加申请表</button>
            </form>
        </td>
    </tr>
</table>

<span id="error"><strong>${requestScope.search_error}</strong></span>


</body>
</html>
