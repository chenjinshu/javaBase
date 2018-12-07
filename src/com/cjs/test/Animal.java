package com.cjs.test;

public interface Animal {

    void say();

    default void eat() {
        System.out.println("i am eating!");
    }
}
