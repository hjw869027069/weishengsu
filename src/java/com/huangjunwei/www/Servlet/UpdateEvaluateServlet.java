package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.dao.StudentCourseDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 修改评价表
 * @author HJW
 */
@WebServlet("/updateEvaluateServlet")
public class UpdateEvaluateServlet extends HttpServlet {
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
        StudentCourseDao studentCourseDao = new StudentCourseDao();

        request.setAttribute("studentCourse",studentCourseDao.findCourseEvaluate(courseId));

        request.getRequestDispatcher("UpdateEvaluate.jsp").forward(request,response);
    }
}
