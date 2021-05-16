package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.po.Course;
import com.huangjunwei.www.po.Number;
import com.huangjunwei.www.po.User;
import com.huangjunwei.www.service.FreshService;
import com.huangjunwei.www.service.SearchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * 加载学生主页面
 * @author HJW
 */
@WebServlet("/studentMainServlet")
public class StudentMainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /*设置utf-8*/
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session =request.getSession();
        FreshService freshService = new FreshService();
        SearchService searchService = new SearchService();
        List<String> names = new ArrayList<>();

        /*获取服务器中user和number对象*/
        User user = (User) session.getAttribute("user");
        Number number = (Number) session.getAttribute("number");

        /*更新学生课表*/
        freshService.freshStudentCourse(number);
        List<Course> courses = searchService.searchStudentCourse(user);



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
