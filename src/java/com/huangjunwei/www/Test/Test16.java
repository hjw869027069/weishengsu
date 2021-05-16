package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.StudentTestDao;
import com.huangjunwei.www.dao.TestDao;
import com.huangjunwei.www.po.StudentTest;
import com.huangjunwei.www.po.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试查询考试
 * @author HJW
 */
public class Test16 {
    public static void main(String[] args) {
        StudentTestDao studentTestDao = new StudentTestDao();
        TestDao testDao = new TestDao();

        List<StudentTest> studentTests;
        List<Test> tests = new ArrayList<>();

        studentTests = studentTestDao.findStudentTest(2);

        for (StudentTest studentTest : studentTests) {
            System.out.println(studentTest.getScore());
            tests.add(testDao.findTest(studentTest.getTestId()));
        }

        System.out.println(tests);
    }
}
