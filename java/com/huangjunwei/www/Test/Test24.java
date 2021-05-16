package com.huangjunwei.www.Test;

import com.huangjunwei.www.po.Number;
import com.huangjunwei.www.service.SearchService;

/**
 * 测试查询选修
 * @author HJW
 */
public class Test24 {
    public static void main(String[] args) {
        Number number = new Number();
        number.setUserId(2);
        number.setGrade(2);
        SearchService searchService = new SearchService();

        System.out.println(searchService.searchStudentChooseCourse(number));
    }
}
