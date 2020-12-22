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
			this.notify();   // 会唤醒在this对象上等待的某一个线程，但并不会立即释放锁
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
				calculator.wait();    // 线程在calculator对象上等待，并释放出calculator的锁
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

        try {
        	Thread.sleep(2000);
		} catch (InterruptedException e) {
        	e.printStackTrace();
		}
		calculator.start();
	}

	/**
	 * 这里有个需要注意的地方，在第26行代码，我们使用的是notify方法，这个方法只会唤醒在calculator对象上等待的一个线程，
	 * 那么讲道理最终只会出现一个 '计算结果为:5050'，另外两个线程依旧处于阻塞状态，但实际上出现了3个 '计算结果为:5050'，
	 * 程序运行结束。其实这是因为由于我们锁住的是一个线程对象，当启动这个线程对象后，在该线程执行完毕后会自动唤醒在自身上
	 * 等待的所有其他线程, 所以如果注释掉第26行代码，也会得到同样的结果。有人会有疑问，不是说notify或者notifyAll方法必须
	 * 在获得了该对象的锁之后才能执行吗，万一线程结束时该对象的锁被其他线程占用了呢？这大可不必担心，因为当我们启动某个线程，
	 * 及调用某个线程的start方法后，线程会去尝试获取自身的锁，只有在获取自身的锁成功后，线程才会真正执行run方法，所以能保证
	 * 线程在结束前都不会有其他线程占据自身的锁，所以也就能够正常唤醒在自身上等待的所有其他线程。
	 * 案例参考ThreadTest8
	 * */
}
