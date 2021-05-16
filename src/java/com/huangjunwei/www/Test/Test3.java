package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.StudentCourseDao;

/**
 * 测试t_course_student表的数据插入
 * @author HJW
 */
public class Test3 {
    public static void main(String[] args) {
        StudentCourseDao studentCourseDao = new StudentCourseDao();

        studentCourseDao.addStudentCourse(1,2);
    }
}
