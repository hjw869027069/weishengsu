package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.ApplicationDao;
import com.huangjunwei.www.dao.CourseDao;
import com.huangjunwei.www.dao.TestDao;
import com.huangjunwei.www.po.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试添加申请表后的展示情况
 * @author HJW
 */
public class Test22 {
    public static void main(String[] args) {
        ApplicationDao applicationDao = new ApplicationDao();
        List<Application> applications = applicationDao.findApplication(4);
        TestDao testDao = new TestDao();
        CourseDao courseDao = new CourseDao();
        List<String> names = new ArrayList<>();
        List<String> situations = new ArrayList<>();

        if (applications.size() > 0) {
            for (Application application : applications) {
                names.add(courseDao.findCourse(application.getCourseId()).getName());
                if (testDao.findCourseTest(application.getCourseId()).getSituation() == 1) {
                    situations.add("申请通过");
                } else {
                    situations.add("正在申请");
                }
            }

            System.out.println(applications);
            System.out.println(names);
            System.out.println(situations);
        }
    }
}