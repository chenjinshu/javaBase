package com.cjs.threadTest;

public class ThreadTest7 implements Runnable{

    public void test() {
        synchronized (this) {
            System.out.println("=====");
        }
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTest7 tt = new ThreadTest7();
        Thread t1 = new Thread(tt);
        t1.start();

        Thread.sleep(5000);

        tt.test();
    }
}
