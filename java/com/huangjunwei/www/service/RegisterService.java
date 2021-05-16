package com.huangjunwei.www.service;

import com.huangjunwei.www.dao.NumberDao;
import com.huangjunwei.www.po.Number;
import com.huangjunwei.www.po.User;

/**
 * 处理注册业务
 * @author HJW
 */
public class RegisterService {

    public void register(User user, Number number){
        NumberDao dao=new NumberDao();
        int userId=user.getId();
        number.setUserId(userId);
        dao.insertNumber(number);
    }
}
