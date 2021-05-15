package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.CourseDao;
import com.huangjunwei.www.po.Course;
import com.huangjunwei.www.po.User;
import com.huangjunwei.www.service.SearchService;

import java.util.ArrayList;
import java.util.List;

public class Test11 {
    public static void main(String[] args) {
        User user=new User();
        user.setId(2);

        SearchService searchService = new SearchService();
        List<Course> allCourses = searchService.searchStudentCourse(user);
        CourseDao courseDao = new CourseDao();

        List<Course> courses = new ArrayList<>();

        for (Course course : allCourses) {
            if (courseDao.searchStudentCourse(course.getId(), "算")!=null) {
                courses.add(courseDao.searchStudentCourse(course.getId(), "算"));
            }
        }

        System.out.println(courses);
    }
}
