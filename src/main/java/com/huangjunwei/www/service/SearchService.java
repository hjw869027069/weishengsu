package com.huangjunwei.www.service;

import com.huangjunwei.www.dao.CourseDao;
import com.huangjunwei.www.dao.StudentCourseDao;
import com.huangjunwei.www.dao.UserDao;
import com.huangjunwei.www.po.Course;
import com.huangjunwei.www.po.Number;
import com.huangjunwei.www.po.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理查找业务
 * @author HJW
 */
public class SearchService {

    /**
     * 直接通过学生对象查找数据库里所有学生课表，返回course对象集合
     */
    public List<Course> searchStudentCourse(User user){

        StudentCourseDao studentCourseDao = new StudentCourseDao();
        CourseDao courseDao = new CourseDao();
        List<Integer> courseId;
        List<Course> courses = new ArrayList<>();

        /*查找该学生的所有课表id，返回arraylist集合*/
        courseId = studentCourseDao.findStudentCourseId(user.getId());

        /*遍历所有课表id集合，通过id查找课程，返回course对象集合*/
        for (Integer integer : courseId) {
            courses.add(courseDao.findCourse(integer));
        }
        return courses;
    }

    /**
     * 直接通过课程对象来查询该课程老师的名字，返回String类型
     */
    public String teacherName(Course course){
        CourseDao courseDao = new CourseDao();
        UserDao userDao = new UserDao();

        /*查询该课程的老师id*/
        int teacherId = courseDao.findTeacherId(course);

        /*通过老师id查出老师名字*/
        userDao.findTeacher(teacherId);

        return userDao.findTeacher(teacherId).getName();
    }

    /**
     * 直接通过学生成员对象查找数据库里学生所有未选择的选修课程，返回course对象集合
     */
    public List<Course> searchStudentChooseCourse(Number number){
        CourseDao courseDao = new CourseDao();
        StudentCourseDao studentCourseDao = new StudentCourseDao();
        List<Integer> list1;
        List<Integer> list2;
        List<Course> courses = new ArrayList<>();

        /*先查询所有选修的课表*/
        list1 = courseDao.findAllStudentCourseId(number.getGrade(),"选修");

        /*再查询数据库里该学生的课表*/
        list2 = studentCourseDao.findStudentCourseId(number.getUserId());

        /*遍历，结果得到未选择的选修课程id集合*/
        for (int i = 0; i < list1.size(); i++) {
            for (Integer integer : list2) {
                if (list1.get(i).equals(integer)) {
                    list1.remove(i);
                }
            }
        }

        /*遍历，通过课程id来查询课程对象，然后加入集合里面，最后返回集合*/
        for (Integer integer : list1) {
            courses.add(courseDao.findCourse(integer));
        }
        return courses;
    }




}
