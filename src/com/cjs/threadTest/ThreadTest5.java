package com.cjs.threadTest;

class Calculator extends Thread {
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
	
	@Override
	public void run() {
		synchronized (this) {
			this.calculate(100);
			this.notify();   // 会唤醒在this对象上等待的所有线程，作用等效于this.notifyAll()
		}
	}
}


public class ThreadTest5 extends Thread {
	
	private Calculator calculator;
	
	public ThreadTest5(Calculator calculator) {
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
		Calculator calculator = new Calculator();
        ThreadTest5 thread1 = new ThreadTest5(calculator);
        ThreadTest5 thread2 = new ThreadTest5(calculator);
        ThreadTest5 thread3 = new ThreadTest5(calculator);
        thread1.start();
        thread2.start();
        thread3.start();
        
        calculator.start();
	}

}
