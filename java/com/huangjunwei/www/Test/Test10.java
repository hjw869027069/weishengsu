package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.CourseDao;

/**
 * 测试模糊查询
 * @author HJW
 */
public class Test10 {
    public static void main(String[] args) {
        CourseDao courseDao = new CourseDao();



        System.out.println(courseDao.searchStudentCourse(4,"算"));
    }
}
