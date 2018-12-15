package com.cjs.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chen.jinshu (青禾)
 * 2018/12/15
 */
public class LambdaTest2 {

    public static void main(String[] args) {
        LambdaTest2 lambdaTest2 = new LambdaTest2();
        lambdaTest2.testThis();
    }

    public void testThis() {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("cjs"));
        list.forEach(l -> {
            System.out.println(">>>>>>>>>>>" + this.getClass().getName());
            l.forEach(s -> {
                System.out.println("<<<<<<<<<<<" + this.getClass().getName());
            });
        });
    }
}
