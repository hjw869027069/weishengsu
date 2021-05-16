package com.huangjunwei.www.Test;

import com.huangjunwei.www.service.SearchService;

/**
 * 测试查询course
 * @author HJW
 */
public class Test21 {
    public static void main(String[] args) {
        SearchService searchService = new SearchService();

        System.out.println(searchService.searchCourseTest(1));
    }
}
