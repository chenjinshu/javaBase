package com.cjs.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAsListTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("cjs", "lq");
//        list.add("hqt");  // 这里的这个list只是Arrays的一个内部类，调用add方法会报错
        System.out.println(list);

        List<String> list1 = new ArrayList<>(Arrays.asList("cjs", "lq"));         // 通过new ArrayList转换为标准的ArrayList则不会报错
        list1.add("hqt");
//        System.out.println(list1);
    }
}
