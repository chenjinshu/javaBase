package com.cjs.java8.functionalCode.consumerTest;

import java.util.function.Consumer;

public class ConsumerTest {

    private static void test1() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test1 start>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("cjs");

        Consumer<String> consumer1 = (param) -> {
            System.out.println(param);
        };
        consumer1.accept("lq");

        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("ylp");

        consumer.andThen(consumer1).andThen(consumer2).accept("->end...");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test1 end>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    private static void test2() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test2 start>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        Consumer<Integer> consumer1 = System.out::println;

        Consumer<Integer> consumer2 = num -> {
            System.out.println(num * 2);
        };

        Consumer<Integer> consumer3 = num -> {
            System.out.println(num * num);
        };

        consumer1.andThen(consumer2).andThen(consumer3).accept(4);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>test2 end>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
