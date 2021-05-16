package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.TestDao;

/**
 * 测试查询考试
 * @author HJW
 */
public class Test15 {
    public static void main(String[] args) {
        TestDao testDao = new TestDao();

        System.out.println(testDao.findTest(1));
    }
}
