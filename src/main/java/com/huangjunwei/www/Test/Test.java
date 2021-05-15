package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.CourseDao;

/**
 * 测试数据库时间读取写入
 * @author HJW
 */
public class Test {
    public static void main(String[] args) {
        CourseDao dao=new CourseDao();


        System.out.println(dao.findCourseTeacher(1));
    }
}
