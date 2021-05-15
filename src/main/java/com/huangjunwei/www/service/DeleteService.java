package com.huangjunwei.www.service;

import com.huangjunwei.www.dao.NumberDao;
import com.huangjunwei.www.dao.StudentCourseDao;
import com.huangjunwei.www.dao.UserDao;
import com.huangjunwei.www.po.User;

/**
 * 处理注销业务
 * @author HJW
 */
public class DeleteService {

    public void deleteStudent(User user){
        UserDao userDao = new UserDao();
        NumberDao numberDao = new NumberDao();
        StudentCourseDao studentCourseDao = new StudentCourseDao();

        numberDao.deleteNumber(user);
        studentCourseDao.deleteCourse(user);
        userDao.deleteUser(user);
    }
}
