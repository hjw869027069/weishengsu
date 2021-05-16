package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.dao.CourseDao;
import com.huangjunwei.www.dao.StudentTestDao;
import com.huangjunwei.www.dao.TestDao;
import com.huangjunwei.www.po.Course;
import com.huangjunwei.www.po.StudentTest;
import com.huangjunwei.www.po.Test;
import com.huangjunwei.www.po.User;
import com.huangjunwei.www.service.SearchService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理查询课表
 * @author HJW
 */
@WebServlet("/searchTestServlet")
public class SearchTestServlet extends HttpServlet {
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
        StudentTestDao studentTestDao = new StudentTestDao();
        TestDao testDao = new TestDao();
        List<StudentTest> studentTests;
        CourseDao courseDao = new CourseDao();
        SearchService searchService = new SearchService();

        List<Test> tests = new ArrayList<>();
        List<Double> scores = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

        /*获取服务器中user对象*/
        User user = (User) session.getAttribute("user");

        studentTests = studentTestDao.findStudentTest(user.getId());

        /*遍历集合，将考试分数和考试信息存进集合*/
        if (studentTests.size()>0){
            for (StudentTest studentTest : studentTests) {
                scores.add(studentTest.getScore());
                /*遍历拿出考试分数*/
                Test test1 =testDao.findTest(studentTest.getTestId());
                if (test1 != null) {
                    tests.add(test1);
                }
            }

            for (Test test : tests) {
                courses.add(courseDao.findCourse(test.getCourseId()));
                names.add(searchService.teacherName(courseDao.findCourse(test.getCourseId())));
            }

            /*将集合转发到学生主页面上*/
            request.setAttribute("scores",scores);
            request.setAttribute("tests",tests);
            request.setAttribute("names",names);
            request.setAttribute("courses",courses);
        }else {
            request.setAttribute("search_error","查询不到结果");
        }

        request.getRequestDispatcher("SearchTest.jsp").forward(request,response);

    }
}
