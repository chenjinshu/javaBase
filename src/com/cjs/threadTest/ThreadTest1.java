package com.cjs.threadTest;

/**
 * 实现Runnable接口
 */

public class ThreadTest1 implements Runnable {
	
	private String threadName;
	
	public ThreadTest1(String threadName) {
		this.threadName = threadName;
	}
	
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(this.threadName + "线程正在打印" + i);
		}
	}

	public static void main(String[] args) {
		ThreadTest1 threadTest1 = new ThreadTest1("thread1");
		ThreadTest1 threadTest2 = new ThreadTest1("thread2");
		Thread thread1 = new Thread(threadTest1);
		Thread thread2 = new Thread(threadTest2);
		thread1.start();
		thread2.start();
	}

}
