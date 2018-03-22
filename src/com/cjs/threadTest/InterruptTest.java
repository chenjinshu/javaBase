package com.cjs.threadTest;

// 线程中断测试
public class InterruptTest extends Thread {
	
	private Thread outThread;
	
	public InterruptTest(Thread outThread) {
		this.outThread = outThread;
	}
	
	public InterruptTest() {}
	
	@Override
	public void run() {
		outThread.interrupt();
	}

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					System.out.println(Thread.currentThread().isInterrupted());
					// 当线程在休眠时如果被中断，会触发InterruptedException，此时线程的中断状态会被重置为未中断，
					// 所以需要再次手动将其中断
				}
			}
		});
		t.start();
		
		InterruptTest it = new InterruptTest(t);
		it.start();
	}
}
