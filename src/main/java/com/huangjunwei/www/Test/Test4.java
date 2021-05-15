package com.huangjunwei.www.Test;

import com.huangjunwei.www.dao.NumberDao;
import com.huangjunwei.www.service.FreshService;

/**
 * 检测更新学生课表方法是否准确
 * @author HJW
 */
public class Test4 {
    public static void main(String[] args) {
        FreshService service = new FreshService();
        NumberDao dao = new NumberDao();



        service.freshStudentCourse(dao.findNumber(2));
    }
}
