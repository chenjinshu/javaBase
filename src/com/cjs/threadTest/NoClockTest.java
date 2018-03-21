package com.cjs.threadTest;

import java.util.concurrent.atomic.AtomicInteger;

// 无锁测试
public class NoClockTest implements Runnable {

    private static NoClockTest nct = new NoClockTest();

    private static Integer a = 0;

    private static AtomicInteger b = new AtomicInteger(0);   // 线程安全

    @Override
    public void run() {
        for(int k=0; k<10000000; k++) {
            a++;
            b.addAndGet(1);   // 无锁操作
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(nct);
        Thread t2 = new Thread(nct);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(a);
        System.out.println(b.get());   // 始终是20000000
    }
}
