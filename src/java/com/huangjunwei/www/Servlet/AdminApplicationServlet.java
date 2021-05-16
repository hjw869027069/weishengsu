package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.dao.ApplicationDao;
import com.huangjunwei.www.dao.CourseDao;
import com.huangjunwei.www.dao.TestDao;
import com.huangjunwei.www.po.Application;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理管理员查看申请表的操作
 * @author HJW
 */
@WebServlet("/adminApplicationServlet")
public class AdminApplicationServlet extends HttpServlet {
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


        ApplicationDao applicationDao = new ApplicationDao();
        TestDao testDao = new TestDao();
        CourseDao courseDao = new CourseDao();

        List<String> situations = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<String> updates = new ArrayList<>();

        List<Application> applications = applicationDao.findAllApplication();

        /*遍历集合，若是获取的situation等于1，则按顺序存入申请通过*/
        if (applications.size()>0) {
            for (Application application : applications) {
                names.add(courseDao.findCourse(application.getCourseId()).getName());
                if (testDao.findCourseTest(application.getCourseId()).getSituation() == 1) {
                    situations.add("申请通过");
                    updates.add("取消通过");
                } else {
                    situations.add("正在申请");
                    updates.add("同意申请");
                }
            }

            /*将申请表转发到页面上*/
            request.setAttribute("names",names);
            request.setAttribute("situations",situations);
            request.setAttribute("applications",applications);
            request.setAttribute("updates",updates);

            request.setAttribute("search_error",request.getParameter("search_error"));
        }else {

            request.setAttribute("search_error","查询不到结果");
        }

        request.getRequestDispatcher("AdminApplication.jsp").forward(request,response);
    }
}
