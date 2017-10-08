package com.cjs.collection;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public static  void main(String[] args){

        List<String> list1 = new ArrayList<>();
        list1.add("cjs");
        list1.add("lq");
        list1.add("llp");

        List<String> list2 = new ArrayList<>();
        list2.add("lq");
        list2.add("jzy");
        list2.add("zxl");

        list1.retainAll(list2);     // 取交集

        for(String s : list1) {
            System.out.println(s);
        }

    }
}
