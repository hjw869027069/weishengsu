package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.ApplicationDao;
import com.huangjunwei.www.dao.CourseDao;
import com.huangjunwei.www.dao.TestDao;
import com.huangjunwei.www.po.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试查找所有申请表
 * @author HJW
 */
public class Test26 {
    public static void main(String[] args) {
        ApplicationDao applicationDao = new ApplicationDao();
        TestDao testDao = new TestDao();
        CourseDao courseDao = new CourseDao();

        List<String> situations = new ArrayList<>();
        List<String> names = new ArrayList<>();

        List<Application> applications = applicationDao.findAllApplication();

        /*遍历集合，若是获取的situation等于1，则按顺序存入申请通过*/
        if (applications.size() > 0) {
            for (Application application : applications) {
                names.add(courseDao.findCourse(application.getCourseId()).getName());
                if (testDao.findCourseTest(application.getCourseId()).getSituation() == 1) {
                    situations.add("申请通过");
                } else {
                    situations.add("正在申请");
                }
            }
        }

        System.out.println(applications);
        System.out.println(names);
        System.out.println(situations);
    }
}
