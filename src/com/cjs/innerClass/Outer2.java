package com.cjs.innerClass;

// 静态内部类
public class Outer2 {

    // 外部类中的静态变量score
    private static int score = 84;

    // 创建静态内部类    只能访问外部类中的静态成员变量
    public static class SInner {
        // 内部类中的变量score
        int score = 91;

        public void show() {
            System.out.println("访问外部类中的score：" +  Outer2.score );
            System.out.println("访问内部类中的score：" + score);
        }
    }

    // 测试静态内部类
    public static void main(String[] args) {
        // 直接创建内部类的对象
        SInner si = new SInner();

        // 调用show方法
        si.show();
    }
}