package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.UserDao;
import com.huangjunwei.www.po.User;

/**
 * 测试
 * @author HJW
 */
public class Test2 {
    public static void main(String[] args) {
        UserDao dao=new UserDao();
        User user=new User();
        user.setName("黄俊玮");
        user.setUsername("hjw1234567");
        user.setPassword("hjw123456");

        dao.insertUser(user);
    }
}
