package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.dao.CourseDao;
import com.huangjunwei.www.dao.StudentCourseDao;
import com.huangjunwei.www.po.Course;
import com.huangjunwei.www.po.StudentCourse;
import com.huangjunwei.www.po.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 教师主页面
 * @author HJW
 */
@WebServlet("/teacherMainServlet")
public class TeacherMainServlet extends HttpServlet {
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

        HttpSession session =request.getSession();
        User user = (User) session.getAttribute("user");
        StudentCourseDao studentCourseDao = new StudentCourseDao();
        CourseDao courseDao = new CourseDao();
        List<Course> courses;
        List<StudentCourse> studentCourses = new ArrayList<>();

        courses = courseDao.findCourseTeacher(user.getId());
        if (courses.size()>0) {
            for (Course course : courses) {
                studentCourses.add(studentCourseDao.findCourseEvaluate(course.getId()));
            }

            /*将课表转发到老师主页面上*/
            request.setAttribute("studentCourses",studentCourses);
            request.setAttribute("courses",courses);
        }else {
            request.setAttribute("search_error","您没有课程");
        }

        request.getRequestDispatcher("TeacherMain.jsp").forward(request,response);
    }
}
