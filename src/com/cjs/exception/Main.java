package com.cjs.exception;

public class Main {

    public static void f() {
        System.out.println("hehe");
        throw new RuntimeException("exception!");
    }

    public static void main(String[] args) {
        System.out.println("haha");
        f();
        System.out.println("lalala");
    }
}
