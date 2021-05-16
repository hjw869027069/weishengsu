package com.huangjunwei.www.Servlet;

import com.huangjunwei.www.dao.NumberDao;
import com.huangjunwei.www.dao.UserDao;
import com.huangjunwei.www.po.Number;
import com.huangjunwei.www.po.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理管理员主界面
 * @author HJW
 */
@WebServlet("/adminMainServlet")
public class AdminMainServlet extends HttpServlet {
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

        /*从服务器中获取管理员对象*/
        HttpSession session =request.getSession();
        User user = (User) session.getAttribute("user");

        /*查找所有的用户*/
        UserDao userDao = new UserDao();
        List<User> allUser = userDao.findAllUser();

        /*遍历allUser，剔除管理员user对象,最终返回users集合*/
        List<User> users = new ArrayList<>();
        for (User value : allUser) {
            if (value.getLever() != user.getLever()) {
                users.add(value);
            }
        }

        /*遍历users集合，返回所有的number对象存入集合,并获取所有的权限等级，存入lever集合中*/
        List<Number> numbers = new ArrayList<>();
        List<String> levers = new ArrayList<>();
        List<String> updates = new ArrayList<>();
        NumberDao numberDao = new NumberDao();
        for (User value : users) {
            numbers.add(numberDao.findNumber(value.getId()));
            if (value.getLever() == 1){
                levers.add("学生");
                updates.add("升级为老师");
            }else {
                levers.add("教师");
                updates.add("降级为学生");
            }
        }

        /*把users和numbers和lever转发到管理员主页面上*/
        request.setAttribute("numbers",numbers);
        request.setAttribute("users",users);
        request.setAttribute("levers",levers);
        request.setAttribute("updates",updates);

        /*从别的servlet获取信息并转发*/
        request.setAttribute("search_error",request.getParameter("search_error"));

        /*返回管理员主页面*/
        request.getRequestDispatcher("AdminMain.jsp").forward(request,response);
    }
}
