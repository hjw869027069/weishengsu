package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.dao.StudentCourseDao;
import com.huangjunwei.www.po.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 处理添加选修课程的操作
 * @author HJW
 */
@WebServlet("/addStudentChooseCourseServlet")
public class AddStudentChooseCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*设置utf-8*/
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        StudentCourseDao studentCourseDao = new StudentCourseDao();


        /*获取页面中提交按钮的参数courseId中的值*/
        int courseId = Integer.parseInt(request.getParameter("courseId"));

        HttpSession session =request.getSession();
        User user = (User) session.getAttribute("user");

        /*把该选修课程添加进表里*/
        studentCourseDao.addStudentCourse(user.getId(), courseId);

        request.setAttribute("add_success","添加成功！");

        request.getRequestDispatcher("studentChooseCourseServlet").forward(request,response);

    }
}
