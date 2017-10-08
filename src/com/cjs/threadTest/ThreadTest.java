package com.cjs.threadTest;

/**
 * 继承Thread类
 */

public class ThreadTest extends Thread {
	
	private String threadName;
	
	public ThreadTest(String threadName) {
		this.threadName = threadName;
	}
	
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(this.threadName + "线程正在打印" + i);
		}
	}

	public static void main(String[] args) {
		ThreadTest thread1 = new ThreadTest("thread1");
		ThreadTest thread2 = new ThreadTest("thread2");
		ThreadTest thread3 = new ThreadTest("thread3");
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
