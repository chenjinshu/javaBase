package com.cjs.volatileTest;

public class VolatileTest {
	
	private static int count = 0;
	
	private volatile static int count1 = 0;
	
	private static int count2 = 0;
	
	public static void inc() {
		try {
			Thread.sleep(1);      // 延迟1毫秒，使结果更明显
		} catch(Exception e) {
			e.printStackTrace();
		}
		count++;
		count1++;
		synchronized (VolatileTest.class) {
			count2++;
		}
	}

	public static void main(String[] args) {
        for(int i=0; i<1000; i++) {
        	new Thread(new Runnable(){
        		@Override
        		public void run() {
        			inc();
        		}
        	}).start();
        }
        
        try {
			Thread.sleep(2000);       // 确保1000个线程已执行完毕
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println("运行结果:count=" + count);
        System.out.println("运行结果:count1=" + count1);
        System.out.println("运行结果:count2=" + count2);
        /*
         * 多次运行此程序，发现除了count2的值都是1000外，count和count1都有可能不同每次运行结果都可能不一样，
         * 并不是预期的1000，这就是多线程并发所造成的问题。具体原因参考JMM(java内存模型)。即使count1加了
         * volatile关键字修饰，但这只是强制线程在取count1值的时候是去主内存中取，而不是从线程栈内存中取，
         * 并不能有效解决多 线程并发问题。而使用了synchronized进行限制后，则可以有效避免多线程并发问题。
         * */
	}

}
