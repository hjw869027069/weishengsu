package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.CourseDao;
import com.huangjunwei.www.dao.NumberDao;
import com.huangjunwei.www.dao.StudentCourseDao;

/**
 * 测试数据库读取
 * @author HJW
 */
public class Test1 {
    public static void main(String[] args) {
        NumberDao dao = new NumberDao();
        CourseDao courseDao = new CourseDao();
        StudentCourseDao studentCourseDao = new StudentCourseDao();

        System.out.println(dao.findNumber(2));

        System.out.println(courseDao.findAllStudentCourseId(2,"必修").get(1));

        System.out.println(studentCourseDao.findStudentCourseId(2));
    }
}
