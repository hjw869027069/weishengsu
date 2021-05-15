package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.dao.StudentCourseDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 操作更新数据
 * @author HJW
 */
@WebServlet("/updateStudentEvaluateServlet")
public class UpdateStudentEvaluateServlet extends HttpServlet {
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

        StudentCourseDao studentCourseDao = new StudentCourseDao();

        String words = request.getParameter("words");
        double score = Double.parseDouble(request.getParameter("score"));
        int courseId = Integer.parseInt(request.getParameter("courseId"));

        studentCourseDao.updateStudentEvaluate(courseId,words,score);

        request.setAttribute("add_success","添加成功！");

        request.getRequestDispatcher("courseEvaluateServlet").forward(request,response);
    }
}
