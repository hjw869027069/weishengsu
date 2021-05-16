package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.dao.CourseDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 处理修改课程信息的操作
 * @author HJW
 */
@WebServlet("/updateTeacherCourseServlet")
public class UpdateTeacherCourseServlet extends HttpServlet {
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

        CourseDao courseDao = new CourseDao();

        String name = request.getParameter("name");
        String major = request.getParameter("major");
        int classroom = Integer.parseInt(request.getParameter("classroom"));
        String course = request.getParameter("course");
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        String beginTime = request.getParameter("beginTime");
        String endTime = request.getParameter("endTime");
        int maxNumber = Integer.parseInt(request.getParameter("maxNumber"));


        courseDao.updateTeacherCourse(courseId,name,major,course,maxNumber,classroom,beginTime,endTime);

        request.setAttribute("add_success","添加成功！");

        request.getRequestDispatcher("teacherMainServlet").forward(request,response);
    }
}
