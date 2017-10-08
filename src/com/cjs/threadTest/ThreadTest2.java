package com.cjs.threadTest;

/**
 * 继承Thread类不易实现资源共享 
 */

public class ThreadTest2 extends Thread {
	
	private int count = 5;
	private String threadName;
	
	public ThreadTest2(String threadName) {
		this.threadName = threadName;
	}
	
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(this.threadName + "线程正在执行     count=" + count--);
			try {
				Thread.sleep((int)Math.random() * 10);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ThreadTest2 thread1 = new ThreadTest2("thread1");
        ThreadTest2 thread2 = new ThreadTest2("thread2");
        thread1.start();
        thread2.start();
	}
	
	/**
	 * 由于每个线程都有自己独立的count和run方法，所以不能实现资源共享 。
	 */

}
