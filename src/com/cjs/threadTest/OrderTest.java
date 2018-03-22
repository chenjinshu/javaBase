package com.cjs.threadTest;

// 有序性测试
public class OrderTest {
	
	private static boolean flag;
	
	private static int a;

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				a = 10;   // 指令重排序有可能使得flag = true先执行，a = 10后执行。
				flag = true;
			}			
		});
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				if(flag) {
					System.out.println(a);      // 有可能打印出0，，但貌似概率极小，反正我没有测出来过
				}
			}			
		});
		
		t1.start();
		t2.start();
	}
}
