package com.huangjunwei.www.Test;

import com.huangjunwei.www.po.Course;
import com.huangjunwei.www.service.SearchService;

/**
 * 测试查询老师名字
 * @author HJW
 */
public class Test7 {
    public static void main(String[] args) {
        SearchService service = new SearchService();

        Course course = new Course();
        course.setId(1);

        System.out.println(service.teacherName(course));

        course.setId(2);

        System.out.println(service.teacherName(course));

        course.setId(3);

        System.out.println(service.teacherName(course));
    }
}
