<%--
  Created by IntelliJ IDEA.
  User: HJW
  Date: 2021/5/15
  Time: 3:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>确定注销账号吗</title>

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

            background-color: #EEEEEE;

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


        .error{
            padding-left: 650px;
        }

        .delete{
            height: 100px;
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
            <a>添加选修</a>
        </td>
        <td class="td1">
            <a>课程评价</a>
        </td>
        <td class="td1">
            <a>个人中心</a>
        </td>
    </tr>

</table>

<form action="updatePasswordServlet" method="post">
    <table class="table2">
        <tr>
            <td colspan="3">修改密码</td>
        </tr>
        <tr>
            <td><label>
                请输入旧密码:
                <input type="password" placeholder="确保密码正确" name="oldPassword">
            </label></td>
            <td><label>
                请输入新密码:
                <input type="password" placeholder="新旧密码不一致" name="newPassword">
            </label></td>
            <td><input type="submit" value="确认"></td>
        </tr>
    </table>
</form>

<form action="searchTestServlet">
    <table class="table2">
        <tr class="delete">
            <td><button >查询考试</button></td>
        </tr>
    </table>
</form>

<form action="sureDeleteServlet">
    <table class="table2">
        <tr class="delete">
            <td><button type="submit" name="sure" value="0">取消注销</button></td>
            <td><button type="submit" name="sure" value="1">确定注销</button></td>
        </tr>
    </table>
</form>

<form action="Login.jsp">
    <table class="table2">
        <tr class="delete">
            <td><button >登出账号</button></td>
        </tr>
    </table>
</form>


<span class="error"><strong>${requestScope.update_error}</strong></span>
<span class="error"><strong>${requestScope.update_success}</strong></span>

</body>
</html>
