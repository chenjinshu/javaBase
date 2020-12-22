package com.cjs.java8.functionalCode.predicateTest;

import java.util.Objects;
import java.util.function.Predicate;

public class predicateTest {

    private static class Dog {
        private String name;
        private int age;
        public Dog(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dog dog = (Dog) o;
            return age == dog.age &&
                    Objects.equals(name, dog.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }

    private static void test1() {
        System.out.println(">>>>>>>>>>>>>>>>>> test1 start >>>>>>>>>>>>>>>>>>");
        Predicate<String> predicate = "cjs"::equals;
        System.out.println(predicate.test("lq"));
        System.out.println(predicate.test("cjs"));
        System.out.println(">>>>>>>>>>>>>>>>>> test1 end >>>>>>>>>>>>>>>>>>");
    }

    private static void test2() {
        System.out.println(">>>>>>>>>>>>>>>>>> test2 start >>>>>>>>>>>>>>>>>>");
        Predicate<Integer> predicate = num -> num % 3 == 0;
        Predicate<Integer> predicate1 = num -> num % 4 == 0;
        Predicate<Integer> predicate2 = num -> num % 5 == 0;
        System.out.println(predicate.and(predicate1).and(predicate2).test(10));
        System.out.println(predicate.and(predicate1).and(predicate2).test(60));
        System.out.println(">>>>>>>>>>>>>>>>>> test2 end >>>>>>>>>>>>>>>>>>");
    }

    private static void test3() {
        System.out.println(">>>>>>>>>>>>>>>>>> test3 start >>>>>>>>>>>>>>>>>>");
        Predicate<Integer> predicate = num -> num % 3 == 0;
        Predicate<Integer> predicate1 = num -> num % 4 == 0;
        System.out.println(predicate.negate().and(predicate1).test(12));
        System.out.println(predicate.negate().and(predicate1).test(16));        // true 不能被3整除但能被4整除
        System.out.println(">>>>>>>>>>>>>>>>>> test3 end >>>>>>>>>>>>>>>>>>");
    }

    private static void test4() {
        System.out.println(">>>>>>>>>>>>>>>>>> test4 start >>>>>>>>>>>>>>>>>>");
        Predicate<Integer> predicate = num -> num % 3 == 0;
        Predicate<Integer> predicate1 = num -> num % 4 == 0;
        System.out.println(predicate.or(predicate1).test(7));
        System.out.println(predicate.or(predicate1).test(8));
        System.out.println(predicate.or(predicate1).test(9));
        System.out.println(predicate.or(predicate1).test(12));
        System.out.println(">>>>>>>>>>>>>>>>>> test4 end >>>>>>>>>>>>>>>>>>");
    }

    private static void test5() {
        System.out.println(">>>>>>>>>>>>>>>>>> test5 start >>>>>>>>>>>>>>>>>>");
        Dog dog = new Dog("peiqi", 15);
        Dog dog1 = new Dog("qiaozhi", 15);
        Dog dog2 = new Dog("peiqi", 15);
        Predicate<Dog> predicate = Predicate.isEqual(dog);
        System.out.println(predicate.test(dog1));
        System.out.println(predicate.test(dog2));
        System.out.println(">>>>>>>>>>>>>>>>>> test5 end >>>>>>>>>>>>>>>>>>");
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }
}
