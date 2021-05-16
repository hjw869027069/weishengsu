package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.dao.CourseDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 修改课程的操作
 * @author HJW
 */
@WebServlet("/updateCourseServlet")
public class UpdateCourseServlet extends HttpServlet {
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

        int courseId = Integer.parseInt(request.getParameter("courseId"));
        CourseDao courseDao = new CourseDao();

        request.setAttribute("course",courseDao.findCourse(courseId));

        request.getRequestDispatcher("UpdateCourse.jsp").forward(request,response);
    }
}
