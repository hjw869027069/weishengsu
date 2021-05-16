package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.dao.UserDao;
import com.huangjunwei.www.po.Number;
import com.huangjunwei.www.po.User;
import com.huangjunwei.www.service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 处理注册操作
 * @author HJW
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
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

        RegisterService registerService = new RegisterService();
        UserDao dao = new UserDao();
        User user = new User();
        Number number=new Number();

        /*获取注册页面的信息*/
        String checkCode = request.getParameter("checkCode");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String major = request.getParameter("major");
        int grade = Integer.parseInt(request.getParameter("grade"));

        /*获取验证码*/
        HttpSession session = request.getSession();
        String checkCodeSession = (String) session.getAttribute("checkCodeSession");


        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        number.setSex(gender);
        number.setMajor(major);
        number.setGrade(grade);

        if(checkCodeSession!= null && checkCodeSession.equalsIgnoreCase(checkCode)){
            if(dao.findUser(username)){
                /*把错误信息转发到注册页面上*/
                request.setAttribute("register_error","账号重复，请重新注册");
                request.getRequestDispatcher("Register.jsp").forward(request,response);
            }else {
                /*没有错误则存入数据库并且重定向到登录页面*/
                dao.insertUser(user);
                registerService.register(dao.login(user),number);
                response.sendRedirect("Login.jsp");
            }
        }else {
            /*把错误信息转发到注册页面上*/
            request.setAttribute("register_error","验证码错误,请重新注册");
            request.getRequestDispatcher("Register.jsp").forward(request,response);

        }
    }
}
