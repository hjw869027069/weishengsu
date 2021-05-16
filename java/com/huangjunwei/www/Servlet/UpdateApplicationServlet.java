package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.service.UpdateService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 修改考试申请情况
 * @author HJW
 */
@WebServlet("/updateApplicationServlet")
public class UpdateApplicationServlet extends HttpServlet {
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

        /*从网页获取courseId*/
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        UpdateService updateService = new UpdateService();

        updateService.updateSituation(courseId);

        request.setAttribute("search_error","修改成功！");

        request.getRequestDispatcher("adminApplicationServlet").forward(request,response);
    }
}
