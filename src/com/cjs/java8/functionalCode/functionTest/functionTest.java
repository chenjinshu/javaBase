package com.cjs.java8.functionalCode.functionTest;

import java.util.function.Function;

public class functionTest {

    private static void test1() {
        System.out.println(">>>>>>>>>>>>>>>>>> test1 start >>>>>>>>>>>>>>>>>>");
        Function<Integer, Integer> function1 = param -> param + 1;
        System.out.println(function1.apply(3));
        System.out.println(">>>>>>>>>>>>>>>>>> test1 end >>>>>>>>>>>>>>>>>>");
    }

    private static void test2() {
        System.out.println(">>>>>>>>>>>>>>>>>> test2 start >>>>>>>>>>>>>>>>>>");
        Function<Integer, Integer> fun = res -> res + 1;
        Function<Integer, Integer> fun1 = res -> res * 10;
        Integer i = fun.compose(fun1).apply(2);          // 2 * 10 + 1    先执行fun1，再将fun1的结果作为入参执行fun
        System.out.println(i);
        System.out.println(">>>>>>>>>>>>>>>>>> test2 end >>>>>>>>>>>>>>>>>>");
    }

    private static void test3() {
        System.out.println(">>>>>>>>>>>>>>>>>> test3 start >>>>>>>>>>>>>>>>>>");
        Function<Integer, Integer> fun = res -> res + 1;
        Function<Integer, Integer> fun1 = res -> res * 10;
        Integer i = fun.andThen(fun1).apply(2);        // (2 + 1) * 10    先执行fun，再将fun的结果作为入参执行fun1
        System.out.println(i);
        System.out.println(">>>>>>>>>>>>>>>>>> test3 end >>>>>>>>>>>>>>>>>>");
    }

    private static void test4() {
        System.out.println(">>>>>>>>>>>>>>>>>> test4 start >>>>>>>>>>>>>>>>>>");
        Function<String, String> function = Function.identity();
        System.out.println(function.apply("测试。。"));
        System.out.println(">>>>>>>>>>>>>>>>>> test4 end >>>>>>>>>>>>>>>>>>");
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
}
