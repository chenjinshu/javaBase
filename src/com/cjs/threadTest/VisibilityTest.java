package com.cjs.threadTest;

// 可见性测试
public class VisibilityTest extends Thread {
	
	private boolean stop;
	
	@Override
	public void run() {
		int i = 0;
		while(!stop) {
			i++;
		}
		System.out.println("finish loop! i=" + i);    // server模式运行这个程序，这里将永不会打印
	}
	
	public void stopIt() {
		stop = true;
	}
	
	public boolean getStop() {
		return stop;
	}

	public static void main(String[] args) throws InterruptedException {
		VisibilityTest v = new VisibilityTest();
		v.start();
		
		Thread.sleep(1000);
		v.stopIt();
		Thread.sleep(2000);
		System.out.println("finish main");
		System.out.println(v.getStop());
	}
}
