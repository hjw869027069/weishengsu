package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.CourseDao;
import com.huangjunwei.www.dao.StudentTestDao;
import com.huangjunwei.www.dao.TestDao;
import com.huangjunwei.www.po.Course;
import com.huangjunwei.www.po.StudentTest;
import com.huangjunwei.www.po.Test;
import com.huangjunwei.www.service.SearchService;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试学生的考试查询
 * @author HJW
 */
public class Test23 {
    public static void main(String[] args) {
        StudentTestDao studentTestDao = new StudentTestDao();
        TestDao testDao = new TestDao();
        List<StudentTest> studentTests;
        CourseDao courseDao = new CourseDao();
        SearchService searchService = new SearchService();

        List<com.huangjunwei.www.po.Test> tests = new ArrayList<>();
        List<Double> scores = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

        studentTests = studentTestDao.findStudentTest(2);

        /*遍历集合，将考试分数和考试信息存进集合*/
        if (studentTests.size()>0){
            for (StudentTest studentTest : studentTests) {
                scores.add(studentTest.getScore());
                /*遍历拿出考试分数*/
                Test test = testDao.findTest(studentTest.getTestId());
                if (test!=null) {
                    tests.add(test);
                }
            }

            for (Test test : tests) {
                courses.add(courseDao.findCourse(test.getCourseId()));
                names.add(searchService.teacherName(courseDao.findCourse(test.getCourseId())));
            }
    }
        System.out.println(scores);
        System.out.println(names);
        System.out.println(courses);
        System.out.println(studentTests);
}
}
