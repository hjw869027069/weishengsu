package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.CourseDao;
import com.huangjunwei.www.po.Course;
import com.huangjunwei.www.po.User;
import com.huangjunwei.www.service.SearchService;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试模糊查询
 * @author HJW
 */
public class Test17 {
    public static void main(String[] args) {
        String courseName = "线";

        SearchService searchService = new SearchService();
        List<String> names = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        CourseDao courseDao = new CourseDao();

        /*获取服务器中user对象*/
        User user = new User();
        user.setId(2);

        /*获取该学生所有课程*/
        List<Course> allCourses = searchService.searchStudentCourse(user);

        /*遍历所有课程，找到符合条件的课程，填进courses集合*/
        for (Course course : allCourses) {
            if (courseDao.searchStudentCourse(course.getId(), courseName) != null) {
                courses.add(courseDao.searchStudentCourse(course.getId(), courseName));
            }
        }

        /*遍历学生现在的课表集合，把教师名字按顺序存入集合*/
        if (courses.size() > 0) {
            for (Course course : courses) {
                names.add(searchService.teacherName(course));
            }
        }

        System.out.println(names);
    }
}
