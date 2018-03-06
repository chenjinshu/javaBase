package com.cjs.array;

import java.util.Arrays;
import java.util.Vector;

public class ArrayTest {

    public static void  main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        // int[] a = new int[5]{1,2,3,4,5};    // 错误，在数组声明同时赋值时不能指定数组长度

        String[] b = { "liqing", "jinzhanyi", "chenjinshu"};
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));

        String ai = "";
        Vector<String> vector = new Vector<>();
        vector.add("345");
        System.out.println(vector.get(0));
    }
}
