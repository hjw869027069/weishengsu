package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.CourseDao;

/**
 * 测试修改课程
 * @author HJW
 */
public class Test18 {
    public static void main(String[] args) {
        CourseDao courseDao = new CourseDao();
        String name = "111";
        String major = "111";
        int classroom = 111;
        String course = "11";
        int courseId = 7;
        String beginTime = "2011-1-10 8:20:00";
        String endTime ="2011-1-10 8:20:00";


        courseDao.updateTeacherCourse(courseId,name,major,course,50,classroom,beginTime,endTime);
    }
}
