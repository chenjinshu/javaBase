package com.cjs.exception;

public class Main1 {

    private static int num = 100;
    private static int count = 200;

    public static int divide1() {
        try {
            return 1;
        } catch(Exception e) {
            e.printStackTrace();
            return 2;
        } finally {
            return 3;   // 返回优先级从大到小为 finally ->  catch -> try
        }
    }

    public static int divide2() {
        try {

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            num++;
        }
        return num;
    }

    public static int divide3() {
        try {
            return count;     // 先将count的值暂存起来，然后执行finally，最后返回暂存的count的值
        } catch(Exception e) {
            e.printStackTrace();
            return count;
        } finally {
            count++;
        }
    }

    public static void main(String[] args) {
        System.out.println(divide1());       // 3
        System.out.println(divide2());       // 101
        System.out.println(divide3());       // 200
    }

}
