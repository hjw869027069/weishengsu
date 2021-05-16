package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.service.UpdateService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 处理更新用户权限
 * @author HJW
 */
@WebServlet("/updateLeverServlet")
public class UpdateLeverServlet extends HttpServlet {
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

        int userId = Integer.parseInt(request.getParameter("userId"));

        /*通过userId修改身份*/
        UpdateService updateService = new UpdateService();
        updateService.updateLever(userId);

        request.setAttribute("search_error","修改成功！");
        request.getRequestDispatcher("adminMainServlet").forward(request,response);
    }
}
