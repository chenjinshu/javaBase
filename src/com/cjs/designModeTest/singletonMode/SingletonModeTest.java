package com.cjs.designModeTest.singletonMode;

// 单例模式
class Singleton {       // 懒汉式

	private static Singleton singleton;
	
	private Singleton() {}
	
	public static synchronized Singleton getInstance() {
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
}

class Singleton1 {       // 饿汉式（推荐）

	private static Singleton1 singleton1 = new Singleton1();
	
	private Singleton1() {}
	
	public static Singleton1 getInstance() {
		return singleton1;
	}
}

public class SingletonModeTest {
	
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println("======");
		
		Singleton1 s3 = Singleton1.getInstance();
		Singleton1 s4 = Singleton1.getInstance();
		System.out.println(s3);
		System.out.println(s4);
	}
}
