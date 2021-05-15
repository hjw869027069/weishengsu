package com.huangjunwei.www.Test;

import java.util.ArrayList;
import java.util.List;

public class Test9 {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        /*oneList.add(1);
        oneList.add(2);
        oneList.add(3);
        oneList.add(4);
        twoList.add(2);
        twoList.add(3);
        twoList.add(5);*/
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

        System.out.println(resultList);

    }
}
