package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.ApplicationDao;

/**
 * 测试查询申请表
 * @author HJW
 */
public class Test20 {
    public static void main(String[] args) {
        ApplicationDao applicationDao = new ApplicationDao();

        System.out.println(applicationDao.findApplication(4));
    }
}
