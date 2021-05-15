<%--
  Created by IntelliJ IDEA.
  User: HJW
  Date: 2021/5/15
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
      <td>请输入评分:<input type="number" name="score" value="${requestScope.studentCourse.score}"></td>
    </tr>
    <tr>
      <td>请输入评价:<textarea name="words" placeholder="${requestScope.studentCourse.words}" rows="10" cols="10" ></textarea></td>
    </tr>
    <tr>
      <td><button type="submit" name="courseId" value="${requestScope.studentCourse.courseId}">确定修改</button></td>
    </tr>
  </table>
</form>
<span id="error"><strong>${requestScope.search_error}</strong></span>

</body>
</html>
