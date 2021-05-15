<%--
  Created by IntelliJ IDEA.
  User: HJW
  Date: 2021/5/13
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("utf-8");%>
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>注册页面</title>

    <style>

        *{
            margin:0;
            padding:0;
            box-sizing:border-box;
        }

        body{
            background: url("img/bg.jpg") no-repeat fixed center;
            /*设置图片为无重复居中的背景图片*/

            background-size:cover;
            /*将背景图片覆盖整个屏幕*/
        }

        .rg_layout{
            width:750px;
            height:450px;
            border:8px solid #EEEEEE;
            background-color:white;
            /*设置注册框长啥样*/

            margin: 60px auto auto;
            /*设置注册框位置*/

        }

        .rg_left{

            float : left;
            margin : 15px;
        }

        .rg_left > p:first-child{
            color:#FFD026;
            font-size:20px;
        }

        .rg_left > p:last-child{
            color:#A6A6A6;
            font-size:20px;
        }

        .rg_center{

            float : left;

            width:450px;
        }

        .rg_right{

            float : right;
            margin : 15px;
        }

        .rg_right > p:first-child{
            font-size:15px;
        }

        .rg_right p a{
            color:pink;
        }

        .td_left{
            width:100px;
            text-align:right;
            height:45px;
        }

        .td_right{
            padding-left:30px;
        }

        #username,#password,#name{
            width:200px;
            height:30px;
            border:1px solid #A6A6A6;

            border-radius:5px;
            padding-left:10px;
        }

        #checkCode{
            width:110px;
            height:30px;
            border:1px solid #A6A6A6;

            border-radius:5px;
            padding-left:10px;
        }

        #grade{
            width:60px;
            height:30px;
            border:1px solid #A6A6A6;

            border-radius:5px;
            padding-left:10px;
        }

        #major{
            width:130px;
            height:30px;
            border:1px solid #A6A6A6;

            border-radius:5px;
            padding-left:10px;
        }

        #img_check{
            height:40px;
            vertical-align:middle;
            margin-left: 20px;
        }

        #button{
            width:150px;
            height:40px;
            background-color:#FFD026;
            border:1px solid #FFD026;
        }

        #s_username,#s_password,#s_name,#s_grade{
            color: red;
        }

        #td_sub{
            padding-left: 150px;
        }

        #error{
            padding-left: 680px;
        }

    </style>
    <%--设置注册框样式--%>

    <script>


        function checkUsername() {
            let username=document.getElementById("username").value;

            let reg_username=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/;
            /*账号限定为8-18为的英文加数字*/
            let flag = reg_username.test(username);
            /*检测机制*/
            let s_username=document.getElementById("s_username");
            if (flag){
                s_username.innerHTML="<img src='img/correct.png' alt='correct' width='35' height='30'  id='img_check'/>";
            }else {
                s_username.innerHTML="<font size='1px'>6~16位字母+数字";
            }
            return flag;
        }

        function checkPassword() {
            let password=document.getElementById("password").value;
            let reg_password=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/;
            let flag = reg_password.test(password);
            let s_password=document.getElementById("s_password");
            if (flag){
                s_password.innerHTML="<img src='img/correct.png' alt='correct' width='35' height='30' id='img_check'/>";
            }else {
                s_password.innerHTML="<font size='1px'>6~16位字母+数字";
            }
            return flag;
        }

        function checkName() {
            let name=document.getElementById("name").value;
            let reg_name=/[\u4e00-\u9fa5]/;
            let flag = reg_name.test(name);
            let s_name=document.getElementById("s_name");
            if (flag){
                s_name.innerHTML="<img src='img/correct.png' alt='correct' width='35' height='30' id='img_check'/>";
            }else {
                s_name.innerHTML="<font size='1px'>请输入纯汉字";
            }
            return flag;
        }

        function checkGrade() {
            let grade=document.getElementById("grade").value;
            let reg_grade=/^(?:0|[1-9]?|100)$/;
            let flag = reg_grade.test(grade);
            let s_grade=document.getElementById("s_grade");
            if (flag){
                s_grade.innerHTML="<img src='img/correct.png' alt='correct' width='35' height='30' id='img_check'/>";
            }else {
                s_grade.innerHTML="<font size='1px'>1~10的正整数";
            }
            return flag;
        }


    </script>
</head>
<body>
<div class="rg_layout">
    <div class="rg_left">
        <p>新用户注册</p>
        <p>USER REGISTER</p>
        <%--字体加粗--%>
    </div>

    <div class="rg_center">
        <div class="rg_form">
            <form action="registerServlet" method="post" id="form">
                <table>
                    <tr>
                        <td class="td_left"><label for="username">用户名：</label></td>
                        <td class="td_right"><input type="text" name="username" id="username" placeholder="请输入用户名"><span id="s_username"></span></td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="password">密码：</label></td>
                        <td class="td_right"><input type="password" name="password" id="password" placeholder="请输入密码"><span id="s_password"></span></td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="name">姓名：</label></td>
                        <td class="td_right"><input type="text" name="name" id="name" placeholder="请输入姓名"><span id="s_name"></span> </td>
                    </tr>


                    <tr>
                        <td class="td_left"><label>性别：</label></td>
                        <td class="td_right">
                            <label>
                                <input type="radio" name="gender" value="男" checked>
                                男
                            </label>
                            <label>
                                <input type="radio" name="gender" value="女">
                                女
                            </label>
                        </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label>专业：</label></td>
                        <td class="td_right">
                            <label for="major"></label><select name="major" id="major">
                            <option>计算机</option>
                            <option>数学</option>
                            <option>物理</option>
                            <option>生物</option>
                            <option>地理</option>
                            <option>化学</option>
                            <option>语文</option>
                            <option>英语</option>
                            <option>历史</option>
                            <option>体育</option>
                        </select>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="grade">年级：</label></td>
                        <td class="td_right"><input type="number" name="grade" id="grade" placeholder="年级"><span id="s_grade"></span> </td>
                    </tr>


                    <tr>
                        <td class="td_left"><label for="checkCode" >验证码：</label></td>
                        <td class="td_right"><input type="text" name="checkCode" id="checkCode" placeholder="请输入验证码">
                            <img src="checkCodeServlet" id="img_check" alt="验证码图片">
                        </td>
                    </tr>


                    <tr>
                        <td colspan="2" id="td_sub"><input type="submit" id="button" value="注册"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

    <div class="rg_right">
        <p>已有账号?<br/><a href="Login.jsp">立即登录</a></p>
    </div>
</div>

<script>
    /*刷新验证码*/
    window.onload = function() {
        //1.获取图片对象
        let img = document.getElementById("img_check");
        //2.绑定单击事件
        img.onclick = function () {
            //加时间戳
            let date = new Date().getTime();

            img.src = "checkCodeServlet?" + date;
        }

        document.getElementById("form").onsubmit = function () {
            return checkUsername() && checkPassword() && checkName() && checkGrade();
        }
        /*若是格式有误，阻止提交*/
    }
    window.onload=function () {


        document.getElementById("username").onblur=checkUsername;
        document.getElementById("password").onblur=checkPassword;
        document.getElementById("name").onblur=checkName;
        document.getElementById("grade").onblur=checkGrade;

        /*移开鼠标时，执行检查格式的方法*/
    }
</script>
<span id="error"><strong>${register_error}</strong></span>
</body>
</html>
