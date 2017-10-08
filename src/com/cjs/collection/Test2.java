package com.cjs.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test2 {
    public static  void main(String[] args){
        Integer[] a = {2, 4, 6, 8};
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(a));   // Arrays.asList方法将数组转变为集合
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("================");

        list.set(0, 1);
        for(Integer i : list) {
            System.out.println(i);
        }

        System.out.println("================");


    }
}
