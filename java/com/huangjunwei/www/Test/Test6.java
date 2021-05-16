package com.huangjunwei.www.Test;

import com.huangjunwei.www.po.User;
import com.huangjunwei.www.service.SearchService;

/**
 * 测试查找学生课表
 * @author HJW
 */
public class Test6 {
    public static void main(String[] args) {
        SearchService service = new SearchService();
        User user = new User();

        user.setId(2);

        System.out.println(service.searchStudentCourse(user));
    }
}
