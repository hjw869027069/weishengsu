package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.CourseDao;

public class Test10 {
    public static void main(String[] args) {
        CourseDao courseDao = new CourseDao();



        System.out.println(courseDao.searchStudentCourse(4,"算"));
    }
}
