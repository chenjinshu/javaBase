package com.cjs.threadTest;

public class ThreadTest4 implements Runnable {
	
	private int count = 10;
	
	@Override
	public void run() {
		synchronized(this) {              // 线程同步
			for(; count>=0; ) {
				try {
					Thread.sleep(200);
					System.out.println(count);
					count--;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
    
	public static void main(String[] args) {
		ThreadTest4 threadTest4 = new ThreadTest4();
        Thread thread1 = new Thread(threadTest4);
        Thread thread2 = new Thread(threadTest4);
        Thread thread3 = new Thread(threadTest4);
        thread1.start();
        thread2.start();
        thread3.start();
	}

}
