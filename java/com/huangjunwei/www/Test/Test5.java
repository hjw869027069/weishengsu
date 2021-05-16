package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.CourseDao;

/**
 * 检测在course表中的查询操作
 * @author HJW
 */
public class Test5 {
    public static void main(String[] args) {
        CourseDao dao = new CourseDao();
        System.out.println(dao.findCourse(3));
    }
}
