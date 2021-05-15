<%--
  Created by IntelliJ IDEA.
  User: HJW
  Date: 2021/5/13
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录页面</title>
    <style>

        body{
            background: url("img/bg.jpg") no-repeat fixed center;
            /*设置图片为无重复居中的背景图片*/

            background-size:cover;
            /*将背景图片覆盖整个屏幕*/
        }

        .login{
            width:300px;
            height:200px;
            border:5px solid #EEEEEE;
            /*background-color:#EFFBFB;*/
            border-radius:10px;
            /*设置登录框长啥样*/

            margin: 2% auto auto;
            padding-top: 10px;
            /*设置登录框位置*/
        }

        .td_right{
            padding-top: 20px;
            padding-left: 40px;
            /*设置输入框的位置*/
        }

        #username,#password{
            width:200px;
            height:30px;
            border:1px solid #A6A6A6;
            border-radius:5px;
            /*设置输入框为圆角*/
            padding-left: 8px;
            /*设置输入框的大小和位置*/
        }


        .td_aaa{
            padding-top: 7px;
            padding-left: 100px;
        }
        /*设置注册链接标签的位置*/

        #sub{
            padding-top: 7px;
            padding-left: 100px;
        }
        /*设置登录按钮的位置*/

        #button{
            width:80px;
            height: 30px;

            background-color:#CEECF5 ;
            border:1px solid #CEECF5;
            color: deeppink;
        }
        /*设置登录按钮的大小和样式*/

        #img{
            width: 80px;
            padding-left: 720px;
            padding-top: 100px;
        }
        /*设置维生素图标的位置和大小*/

        #error{
            padding-left: 650px;
        }
        /*设置错误消息的位置*/

    </style>
</head>
<body>
<img src="img/bgp.jpg" id="img" alt="图标">

<div class="login">
    <form action="loginServlet" method="post" id="form">
        <table id="login">
            <tr>
                <td></td>
                <td class="td_right"><label for="username"></label><input type="text" name="username" id="username" placeholder="USERNAME"><span id="s_username"></span></td>
            </tr>

            <tr>
                <td></td>
                <td class="td_right"><label for="password"></label><input type="password" name="password" id="password" placeholder="PASSWORD"><span id="s_password"></span></td>
            </tr>
            <tr>
                <td class="td_aaa" colspan="2">
                    <a href="Register.jsp"><font size="5px">Register</font></a>
                </td>
            </tr>
            <tr>
                <td colspan="2" id="sub"><input type="submit" id="button" value="Login"></td>
            </tr>
        </table>
    </form>
</div>

<span id="error"><strong>${login_error}</strong></span>
<%--设置错误信息--%>
</body>
</html>
