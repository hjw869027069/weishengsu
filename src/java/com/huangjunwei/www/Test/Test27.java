package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.StudentCourseDao;

/**
 * 测试查询所有学生集合
 * @author HJW
 */
public class Test27 {
    public static void main(String[] args) {
        StudentCourseDao studentCourseDao = new StudentCourseDao();

        System.out.println(studentCourseDao.findAllStudentCourse());
    }
}
