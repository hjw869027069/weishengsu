package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.dao.CourseDao;
import com.huangjunwei.www.po.Course;
import com.huangjunwei.www.po.User;
import com.huangjunwei.www.service.SearchService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理利用课名查询课表的操作
 * @author HJW
 */
@WebServlet("/searchCourseServlet")
public class SearchCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =request.getSession();

        /*设置utf-8*/
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        /*获取搜索的东西*/
        String courseName = request.getParameter("courseName");

        SearchService searchService = new SearchService();
        List<String> names = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        CourseDao courseDao = new CourseDao();

        /*获取服务器中user对象*/
        User user = (User) session.getAttribute("user");

        /*获取该学生所有课程*/
        List<Course> allCourses = searchService.searchStudentCourse(user);

        /*遍历所有课程，找到符合条件的课程，填进courses集合*/
        for (Course course : allCourses) {
            if (courseDao.searchStudentCourse(course.getId(), courseName)!=null) {
                courses.add(courseDao.searchStudentCourse(course.getId(), courseName));
            }
        }

        /*遍历学生现在的课表集合，把教师名字按顺序存入集合*/
        if (courses.size()>0) {
            for (Course course : courses) {
                names.add(searchService.teacherName(course));
            }
            /*将课表转发到学生主页面上*/
            request.setAttribute("names",names);
            request.setAttribute("courses",courses);
        }else {
            request.setAttribute("search_error","查询不到结果");
        }


        request.getRequestDispatcher("StudentMain.jsp").forward(request,response);
    }
}
