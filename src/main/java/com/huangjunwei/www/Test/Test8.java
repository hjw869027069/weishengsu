package com.huangjunwei.www.Test;

import com.huangjunwei.www.po.Number;
import com.huangjunwei.www.service.SearchService;

/**
 * 测试查询未选择的选修课程
 * @author HJW
 */
public class Test8 {
    public static void main(String[] args) {
        SearchService service = new SearchService();
        Number number = new Number();
        number.setGrade(2);
        number.setUserId(2);

        System.out.println(service.searchStudentChooseCourse(number));
        System.out.println("老师名字---"+service.teacherName(service.searchStudentChooseCourse(number).get(0)));
    }
}
