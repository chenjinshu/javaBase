package com.cjs.threadTest;

class Calculator1 {
    private int result;
    
    public void setResult(int result) {
    	this.result = result;
    }
    
    public int getResult() {
    	return result;
    }
	
	public void calculate(int n) {
		int sum = 0;
		for(int i=1; i<=n; i++) {
			sum += i;
		}
		this.setResult(sum);
	}
	
}


public class ThreadTest6 extends Thread {
	
	private Calculator1 calculator;
	
	public ThreadTest6(Calculator1 calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		synchronized (calculator) {
			System.out.println("正在等待计算结果...");
			try {
				calculator.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("计算结果为:" + calculator.getResult());
		}
	}

	public static void main(String[] args) {
		Calculator1 calculator = new Calculator1();
        ThreadTest6 thread1 = new ThreadTest6(calculator);
        ThreadTest6 thread2 = new ThreadTest6(calculator);
        ThreadTest6 thread3 = new ThreadTest6(calculator);
        thread1.start();
        thread2.start();
        thread3.start();
        
        try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
        
        synchronized (calculator) {
	        calculator.calculate(100);
	        // calculator.notify();   // 仅唤醒在calculator对象上等待的一个线程
	         calculator.notifyAll();  // 唤醒在calculator对象上等待的所有线程
		}
	}

}
