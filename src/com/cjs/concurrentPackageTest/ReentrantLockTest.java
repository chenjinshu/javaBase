package com.cjs.concurrentPackageTest;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest implements Runnable {

    static int i;

    static ReentrantLock reentrantLock = new ReentrantLock();   // 可重入锁（同一线程不受锁的限制，但不同线程会受到限制）

    @Override
    public void run () {
        for(int k = 0; k < 10000000; k++) {
            reentrantLock.lock();   // 加锁
            try {
                i++;
            } finally {
                reentrantLock.unlock();   // 解锁，在解锁前其他任何线程都无法进入加锁后的区域。解锁操作必须写在finally里，因为需要确保
                                          // 锁被释放，如果因为中途有异常锁没有被释放，则其他所有线程都无法进入该区域。
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        Thread t1 = new Thread(reentrantLockTest);
        Thread t2 = new Thread(reentrantLockTest);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
