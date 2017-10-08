package com.cjs.collection;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static  void main(String[] args){
        String str = new String("cjs");
        List<String> list = new ArrayList<>();
        list.add(str);
        list.add(str);
        String s1 = null;
        String s2 = null;
        for(String s : list) {
            if(s1 == null) {
                s1 = s;
            } else {
                s2 = s;
            }
        }
        System.out.println(s1 == s2);

        for(String s : list) {
            System.out.println(s);
        }

        System.out.println("=========");

        String ss = list.get(0);
        list.remove(ss);
        //list.remove(0);
        for(String s : list) {
            System.out.println(s);
        }
    }
}
