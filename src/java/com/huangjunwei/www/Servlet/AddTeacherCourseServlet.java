package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.dao.CourseDao;
import com.huangjunwei.www.po.Number;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 处理添加课程操作
 * @author HJW
 */
@WebServlet("/addTeacherCourseServlet")
public class AddTeacherCourseServlet extends HttpServlet {
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

        HttpSession session = request.getSession();
        Number number = (Number) session.getAttribute("number");

        CourseDao courseDao = new CourseDao();

        /*从表单获取数据*/
        String name = request.getParameter("name");
        String major = request.getParameter("major");
        int classroom = Integer.parseInt(request.getParameter("classroom"));
        String course = request.getParameter("course");
        String beginTime = request.getParameter("beginTime");
        String endTime = request.getParameter("endTime");
        int maxNumber = Integer.parseInt(request.getParameter("maxNumber"));

        /*服务器获取数据*/
        int teacherId = number.getUserId();
        int grade = number.getGrade();

        courseDao.addCourse(teacherId,major,classroom,course,beginTime,endTime,maxNumber,grade,name);

        request.setAttribute("add_success","添加成功！");

        request.getRequestDispatcher("teacherMainServlet").forward(request,response);
    }
}
