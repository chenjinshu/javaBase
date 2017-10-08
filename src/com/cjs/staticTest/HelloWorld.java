package com.cjs.staticTest;

public class HelloWorld {

    String name; // 声明变量name
    String sex; // 声明变量sex
    static int age;// 声明静态变量age

    // 构造方法
    public   HelloWorld     () {
        System.out.println("通过构造方法初始化name");
        name = "tom";
    }

    // 初始化块   在new一个这个类的对象时执行，每new一个便会执行一次，且在构造方法之前执行
    {
        System.out.println("通过初始化块初始化sex");
        sex = "男";
    }

    // 静态初始化块   在类加载的时候就执行，且只执行一次
    static    {
        System.out.println("通过静态初始化块初始化age");
        age = 20;
    }

    public void show() {
        System.out.println("姓名：" + name + "，性别：" + sex + "，年龄：" + age);
    }

    public static void main(String[] args) {

        HelloWorld hello = new HelloWorld();
        hello.show();

        System.out.println("------------------------");

        HelloWorld hello2 = new HelloWorld();
        hello2.show();

    }
}