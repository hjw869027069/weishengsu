package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.dao.CourseDao;
import com.huangjunwei.www.dao.StudentCourseDao;
import com.huangjunwei.www.dao.UserDao;
import com.huangjunwei.www.po.Course;
import com.huangjunwei.www.po.StudentCourse;
import com.huangjunwei.www.service.SearchService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理查看每个学生的课程评分的操作
 * @author HJW
 */
@WebServlet("/adminCourseScoreServlet")
public class AdminCourseScoreServlet extends HttpServlet {
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

        /*查询所有的studentCourse对象，存入集合里*/
        StudentCourseDao studentCourseDao = new StudentCourseDao();
        List<StudentCourse> studentCourses = studentCourseDao.findAllStudentCourse();

        /*遍历集合，把获取的user对象的名字按顺序存入names集合里，以及获取courseNames以及teacherNames*/
        UserDao userDao = new UserDao();
        CourseDao courseDao = new CourseDao();
        SearchService searchService = new SearchService();


        List<String> names = new ArrayList<>();
        List<String> courseNames = new ArrayList<>();
        List<String> teacherNames = new ArrayList<>();

        for (StudentCourse studentCourse : studentCourses) {
            int userId = studentCourse.getStudentId();
            int courseId = studentCourse.getCourseId();
            Course course = courseDao.findCourse(courseId);
            String teacherName = searchService.teacherName(course);

            names.add(userDao.findTeacher(userId).getName());
            teacherNames.add(teacherName);
            courseNames.add(course.getName());
        }

        /*获取的信息全转发到页面上*/
        request.setAttribute("names",names);
        request.setAttribute("courseNames",courseNames);
        request.setAttribute("teacherNames",teacherNames);
        request.setAttribute("studentCourses",studentCourses);

        request.getRequestDispatcher("AdminCourseScore.jsp").forward(request,response);
    }
}
