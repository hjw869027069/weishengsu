package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.po.User;
import com.huangjunwei.www.service.DeleteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 处理注销账号
 * @author HJW
 */
@WebServlet("/sureDeleteServlet")
public class SureDeleteServlet extends HttpServlet {
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
        DeleteService deleteService = new DeleteService();

        int sure = Integer.parseInt(request.getParameter("sure"));
        if (sure == 0){
            request.getRequestDispatcher("StudentCenter.jsp").forward(request,response);
        }else {
            deleteService.deleteStudent(user);
            request.setAttribute("login_error","已注销，请重新登录！");
            request.getRequestDispatcher("Login.jsp").forward(request,response);
        }
    }
}
