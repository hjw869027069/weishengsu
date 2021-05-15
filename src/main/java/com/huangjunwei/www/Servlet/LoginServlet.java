package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.dao.NumberDao;
import com.huangjunwei.www.dao.UserDao;
import com.huangjunwei.www.po.Number;
import com.huangjunwei.www.po.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 处理登录操作
 * @author HJW
 */
@SuppressWarnings("AlibabaUndefineMagicConstant")
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =request.getSession();

        /*设置utf-8*/
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        /*获取username和password，若用login找出user，则存在session里服务器可用*/
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);

        Number number;
        NumberDao dao = new NumberDao();

        if (user == null)
        {
            /*把登录错误的信息转发到登录页面上*/
            request.setAttribute("login_error","账号或密码有误！请重新登录！");
            request.getRequestDispatcher("Login.jsp").forward(request,response);
        }else {
            session.setAttribute("user",user);
            number = dao.findNumber(user.getId());
            session.setAttribute("number",number);
            /*权限1,2,3分别进入不同servlet里处理*/
            if(user.getLever() == 1) {
                session.setAttribute("identity","学生");
                response.sendRedirect("studentMainServlet");
            }else if(user.getLever() == 2){
                session.setAttribute("identity","教师");
                response.sendRedirect("teacherMainServlet");
            }else if (user.getLever() == 3){
                session.setAttribute("identity","管理员");
                response.sendRedirect("AdminMain.jsp");
            }
        }
    }
}
