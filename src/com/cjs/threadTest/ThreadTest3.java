package com.cjs.threadTest;

/**
 * 实现Runnable接口则很容易实现资源共享 
 */

public class ThreadTest3 implements Runnable {
    
	private String threadName;
	private int count=5;
	
	public ThreadTest3(String threadName) {
		this.threadName = threadName;
	}
	
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(this.threadName + "线程正在执行    count=" + count--);
			try {
				Thread.sleep((int)Math.random() * 10);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		ThreadTest3 threadTest1 = new ThreadTest3("thread1");
        Thread thread1 = new Thread(threadTest1);
        Thread thread2 = new Thread(threadTest1);
        thread1.start();
        thread2.start();
	}
	
	/**
	 * 从结果可以看出，两个线程不仅有同样的名字，还共享了count变量。实际上，在调用两个线程的start方法时，
	 * 都是去调用 ThreadTest3实例的run方法，线程实例本身是没有run方法的，这样很轻松的就完成了资源共享。
	 * 需要注意的是，在实例化这两个线程实例时，必须传入同一个ThreadTest3实例，否则结果就和继承Thread类
	 * 的结果一样了。
	 */

}
