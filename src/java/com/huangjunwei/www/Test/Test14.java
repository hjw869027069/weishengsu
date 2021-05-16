package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.UserDao;

/**
 * 修改密码
 * @author HJW
 */
public class Test14 {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        userDao.updatePassword(1,"zs123456");
    }

}
