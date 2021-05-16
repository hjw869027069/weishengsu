<%--
  Created by IntelliJ IDEA.
  User: HJW
  Date: 2021/5/16
  Time: 1:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员主页面</title>

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


        .error{
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
            <a >用户管理</a>
        </td>
        <td class="td1">
            <a href="adminApplicationServlet">查看申请 </a>
        </td>
        <td class="td1">
            <a href="adminCourseScoreServlet">课程评分情况 </a>
        </td>
        <td class="td1">
            <a href="AdminCenter.jsp">个人中心</a>
        </td>
    </tr>
</table>

<table class="table2">
    <tr>
        <th>编号</th>
        <th>用户名字</th>
        <th>年级</th>
        <th>专业</th>
        <th>身份</th>
        <th>身份操作</th>
    </tr>

    <c:forEach items="${requestScope.users}" var="user" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${user.name}</td>
            <td>${requestScope.numbers[s.count-1].grade}</td>
            <td>${requestScope.numbers[s.count-1].major}</td>
            <td>${requestScope.levers[s.count-1]}</td>
            <td>
                <form action="updateLeverServlet">
                    <button type="submit" name="userId" value="${user.id}">${requestScope.updates[s.count-1]}</button>
                </form>
            </td>

        </tr>

    </c:forEach>
</table>
<span class="error"><strong>${requestScope.search_error}</strong></span>
<span class="error"><strong>${requestScope.add_success}</strong></span>

</body>
</html>
