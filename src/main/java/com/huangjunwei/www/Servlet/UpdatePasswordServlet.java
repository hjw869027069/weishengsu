package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.dao.UserDao;
import com.huangjunwei.www.po.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 修改密码操作
 * @author HJW
 */
@WebServlet("/updatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
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
        User updateUser = new User();
        UserDao userDao = new UserDao();

        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        updateUser.setUsername(user.getUsername());
        updateUser.setPassword(oldPassword);

        if (userDao.login(updateUser)==null){
            request.setAttribute("update_error","旧密码输错了！");
        }else if (oldPassword.equals(newPassword)){
            request.setAttribute("update_error","前后密码一致！");
        }else {
            userDao.updatePassword(user.getId(),newPassword);
            request.setAttribute("update_success","修改成功！");
        }


        request.getRequestDispatcher("StudentCenter.jsp").forward(request,response);
    }
}
