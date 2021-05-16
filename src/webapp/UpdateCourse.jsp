<%--
  Created by IntelliJ IDEA.
  User: HJW
  Date: 2021/5/15
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>设置课程</title>

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


    #error{
      padding-left: 650px;
    }

    #name,.time{
      width:170px;
      height:25px;
      border:1px solid #A6A6A6;
      border-radius:5px;
      /*设置输入框为圆角*/
      padding-left: 8px;
      /*设置输入框的大小和位置*/
    }

    #major,#classroom,#course,#maxNumber{
      width:100px;
      height:25px;
      border:1px solid #A6A6A6;
      border-radius:5px;
      /*设置输入框为圆角*/
      padding-left: 8px;
      /*设置输入框的大小和位置*/
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

<form action="updateTeacherCourseServlet" method="post">
  <table class="table2">
    <tr>
      <td><label for="name">请输入课名:</label><input id="name" type="text" name="name" value="${requestScope.course.name}"></td>
    </tr>
    <tr>
      <td><label for="classroom">请输入教室号:</label><input id="classroom" type="text" name="classroom" value="${requestScope.course.classroom}"></td>
    </tr>
    <tr>
      <td><label for="maxNumber">请输入上课人数:</label><input id="maxNumber" type="text" name="maxNumber" value="${requestScope.course.maxNumber}"></td>
    </tr>
    <tr>
      <td><label for="major">请输入专业:</label><input id="major" type="text" name="major" value="${requestScope.course.major}"></td>
    </tr>
    <tr>
      <td><label for="course">请输入选/必修:</label><input id="course" type="text" name="course" value="${requestScope.course.course}"></td>
    </tr>
    <tr>
      <td><label>
        请输入上课时间:
        <input class="time" type="text" name="beginTime" value="${requestScope.course.beginTime}">
      </label></td>
    </tr>
    <tr>
      <td><label>
        请输入下课时间:
        <input class="time" type="text" name="endTime" value="${requestScope.course.endTime}">
      </label></td>
    </tr>
    <tr>
      <td><button type="submit" name="courseId" value="${requestScope.course.id}">确定修改</button></td>
    </tr>
  </table>
</form>
<span id="error"><strong>${requestScope.search_error}</strong></span>

</body>
</html>
