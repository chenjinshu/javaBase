package com.cjs.innerClass;

//外部类HelloWorld
public class Outer {

    private String immoc = "imooc";

    // 内部类Inner，类Inner在类HelloWorld的内部
    public class Inner {

        // 内部类的方法
        public void show() {
            System.out.println(immoc);
        }
    }

    public static void main(String[] args) {

        // 创建外部类对象
        Outer outer = new Outer();
        // 创建内部类对象
        Inner i = outer.new Inner();
        // 调用内部类对象的方法
        i.show();
    }
}