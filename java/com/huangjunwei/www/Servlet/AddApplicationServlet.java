package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.dao.ApplicationDao;
import com.huangjunwei.www.dao.CourseDao;
import com.huangjunwei.www.dao.TestDao;
import com.huangjunwei.www.po.Course;
import com.huangjunwei.www.po.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * 添加申请表的操作
 * @author HJW
 */
@WebServlet("/addApplicationServlet")
public class AddApplicationServlet extends HttpServlet {
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

        /*从服务器拿出user对象*/
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        CourseDao courseDao = new CourseDao();
        ApplicationDao applicationDao = new ApplicationDao();
        TestDao testDao = new TestDao();
        int courseId = 0;

        /*从表单拿出数据*/
        String name = request.getParameter("name");
        int classroom = Integer.parseInt(request.getParameter("classroom"));
        int number = Integer.parseInt(request.getParameter("number"));
        String beginTime = request.getParameter("beginTime");
        String endTime = request.getParameter("endTime");

        /*通过老师的id获取所有的课程集合*/
        List<Course> courses = courseDao.findCourseTeacher(user.getId());

        /*遍历课程集合，查看是否有课名和添加考试的课名相同，如果有获取此时的课程id*/
        for (Course course : courses) {
            if ((course.getName()).equals(name)) {
                courseId = course.getId();
                break;
            }
        }

        if (courseId > 0){
            applicationDao.addApplication(user.getId(),courseId,number,classroom,beginTime,endTime);
            testDao.addTest(courseId,number,classroom,beginTime,endTime);

            request.setAttribute("search_error","添加成功！");

            request.getRequestDispatcher("searchApplicationServlet").forward(request,response);
        }else {
            request.setAttribute("search_error","您添加不了该课名的考试！");

            request.getRequestDispatcher("AddApplication.jsp").forward(request,response);
        }
    }
}
