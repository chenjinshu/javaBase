package com.cjs.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test4 {
    public static  void main(String[] args){

        Set<String> set1 = new HashSet<>();
        set1.add(new String("cjs"));
        set1.add(new String("cjs"));

        Iterator<String> it = set1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        Set<Object> set2 = new HashSet<>();
        set2.add(new Object());
        set2.add(new Object());

        Iterator<Object> it2 = set2.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }

    }
}
