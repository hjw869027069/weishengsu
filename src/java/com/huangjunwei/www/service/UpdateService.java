package com.huangjunwei.www.service;

import com.huangjunwei.www.dao.TestDao;
import com.huangjunwei.www.dao.UserDao;
import com.huangjunwei.www.po.Test;
import com.huangjunwei.www.po.User;

/**
 * 执行复杂修改的业务操作
 * @author HJW
 */
public class UpdateService {

    /**
     * 直接修改用户权限，1修改为2，2修改为1
     */
    public void updateLever(int userId){
        UserDao userDao = new UserDao();
        User user = userDao.findTeacher(userId);
        int lever = user.getLever();

        if (lever == 1){
            userDao.updateLeverUserId(userId,2);
        }else {
            userDao.updateLeverUserId(userId,1);
        }

    }

    /**
     * 直接修改申请表情况
     */
    public void updateSituation(int courseId){
        TestDao testDao = new TestDao();

        Test test = testDao.findCourseTest(courseId);
        int situation = test.getSituation();

        if (situation == 0){
            testDao.updateTestSituation(courseId,1);
        }else {
            testDao.updateTestSituation(courseId,0);
        }
    }
}
