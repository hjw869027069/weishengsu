package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.StudentCourseDao;

public class Test13 {
    public static void main(String[] args) {
        StudentCourseDao studentCourseDao = new StudentCourseDao();
        studentCourseDao.updateStudentEvaluate(2,"你好，我测试一下是否正常插入",88.0);
    }
}
