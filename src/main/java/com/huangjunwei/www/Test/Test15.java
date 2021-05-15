package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.TestDao;

public class Test15 {
    public static void main(String[] args) {
        TestDao testDao = new TestDao();

        System.out.println(testDao.findTest(1));
    }
}
