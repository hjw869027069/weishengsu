package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.dao.ApplicationDao;
import com.huangjunwei.www.dao.CourseDao;
import com.huangjunwei.www.dao.TestDao;
import com.huangjunwei.www.po.Application;
import com.huangjunwei.www.po.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 查看申请记录的操作
 * @author HJW
 */
@WebServlet("/searchApplicationServlet")
public class SearchApplicationServlet extends HttpServlet {
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

        ApplicationDao applicationDao = new ApplicationDao();
        TestDao testDao = new TestDao();
        CourseDao courseDao = new CourseDao();

        List<String> situations = new ArrayList<>();
        List<String> names = new ArrayList<>();

        List<Application> applications = applicationDao.findApplication(user.getId());

        /*遍历集合，若是获取的situation等于1，则按顺序存入申请通过*/
        if (applications.size()>0) {
            for (Application application : applications) {
                names.add(courseDao.findCourse(application.getCourseId()).getName());
                if (testDao.findCourseTest(application.getCourseId()).getSituation() == 1) {
                    situations.add("申请通过");
                } else {
                    situations.add("正在申请");
                }
            }

            /*将申请表转发到页面上*/
            request.setAttribute("names",names);
            request.setAttribute("situations",situations);
            request.setAttribute("applications",applications);

            request.setAttribute("search_error",request.getParameter("search_error"));
        }else {

            request.setAttribute("search_error","查询不到结果");
        }

        request.getRequestDispatcher("TeacherApplication.jsp").forward(request,response);
    }
}
