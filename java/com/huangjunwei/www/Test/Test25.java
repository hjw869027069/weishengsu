package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.UserDao;
import com.huangjunwei.www.po.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试查看用户列表
 * @author HJW
 */
public class Test25 {
    public static void main(String[] args) {
        /*查找所有的用户*/
        UserDao userDao = new UserDao();
        List<User> allUser = userDao.findAllUser();

        /*遍历allUser，剔除管理员user对象,最终返回users集合*/
        List<User> users = new ArrayList<>();
        for (User value : allUser) {
            if (value.getLever() != 3) {
                users.add(value);
            }
        }

        System.out.println(allUser);
        System.out.println(users);
    }
}
