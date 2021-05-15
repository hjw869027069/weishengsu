package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.UserDao;

public class Test14 {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        userDao.updatePassword(1,"zs123456");
    }

}
