package com.cjs.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test5 {
    public static  void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(15);
        list.add(39);
        list.add(26);
        list.add(109);
        list.add(4);

        Collections.sort(list);       // 对list进行排序（默认升序），前提条件是集合中的元素类型必须实现comparable接口

        Iterator<Integer> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("=============");

        List<Student> list1 = new ArrayList<>();
        Student stu1 = new Student("lq", 24);
        Student stu2 = new Student("zxl", 23);
        Student stu3 = new Student("cjs", 22);
        list1.add(stu1);
        list1.add(stu2);
        list1.add(stu3);

        Collections.sort(list1);

        Iterator<Student> it1 = list1.iterator();
        while(it1.hasNext()) {
            System.out.println(it1.next().getAge());
        }
    }
}
