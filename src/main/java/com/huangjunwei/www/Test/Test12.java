package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.StudentCourseDao;

public class Test12 {
    public static void main(String[] args) {
        StudentCourseDao studentCourseDao = new StudentCourseDao();

        System.out.println(studentCourseDao.findStudentCourse(2));
    }
}
