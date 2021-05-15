package com.huangjunwei.www.service;

import com.huangjunwei.www.dao.CourseDao;
import com.huangjunwei.www.dao.StudentCourseDao;
import com.huangjunwei.www.po.Number;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理更新业务
 * @author HJW
 */
public class FreshService {

    /**
     * 更新学生课表的数据
     */
    public void freshStudentCourse(Number number){
        CourseDao courseDao = new CourseDao();
        StudentCourseDao studentCourseDao = new StudentCourseDao();
        List<Integer> list1;
        List<Integer> list2;

        /*先查询所有必修的课表*/
        list1 = courseDao.findAllStudentCourseId(number.getGrade(),"必修");

        /*再查询数据库里该学生的课表*/
        list2 = studentCourseDao.findStudentCourseId(number.getUserId());

        /*遍历两个集合，找出数据库还没添加的必修课表id集合，直接添加进去*/
        List<Integer> resultList = new ArrayList<>();
        for (Integer one : list1) {
            boolean flag = true;
            for (Integer two : list2) {
                if (one.equals(two)) {
                    flag = false;
                    break;
                }

            }

            if (flag) {
                resultList.add(one);
            }
        }
        if (list1.size()>0){
            for (Integer integer : resultList) {
                studentCourseDao.addStudentCourse(number.getUserId(), integer);
            }
        }

    }


}
