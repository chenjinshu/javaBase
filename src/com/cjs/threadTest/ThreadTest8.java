package com.cjs.threadTest;

class Calculator2 extends Thread {
    private int result;

    public void setResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void calculate(int n) {
        int sum = 0;
        for(int i=1; i<=n; i++) {
            sum += i;
        }
        this.setResult(sum);
    }

    @Override
    public void run() {
        System.out.println("1111");
    }
}


public class ThreadTest8 extends Thread {

    private Calculator2 calculator;

    public ThreadTest8(Calculator2 calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        synchronized (calculator) {
            System.out.println("正在等待计算结果...");
            try {
                //calculator.wait();    // 线程在calculator对象上等待，并释放出calculator的锁
                Thread.sleep(5000);    // 线程休眠，并不会释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hahaha");
        }
    }

    public static void main(String[] args) {
        Calculator2 calculator = new Calculator2();
        ThreadTest8 thread1 = new ThreadTest8(calculator);
        thread1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        calculator.start();
    }

}
