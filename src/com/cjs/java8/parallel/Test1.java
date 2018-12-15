package com.cjs.java8.parallel;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author chen.jinshu (青禾)
 * 2018/12/15
 */
public class Test1 {

    public static void main(String[] args) {
        long[] arrayOfLong = new long[20000];

        Arrays.parallelSetAll(arrayOfLong, index ->
            ThreadLocalRandom.current().nextInt(1000000));
        Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));

        System.out.println("");
        System.out.println("====================");

        // 并行排序，对于多核cpu可有效加快排序速度
        Arrays.parallelSort(arrayOfLong);
        Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
    }
}
