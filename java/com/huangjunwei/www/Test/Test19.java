package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.CourseDao;
import com.huangjunwei.www.po.Course;

import java.util.List;

/**
 * 测试查询结果
 * @author HJW
 */
public class Test19 {
    public static void main(String[] args) {
        CourseDao courseDao = new CourseDao();
        List<Course> courses = courseDao.findCourseTeacher(10);

        if (courses.size()==0){
            System.out.println(123);
        }else {
            System.out.println(courses);
        }
    }
}
