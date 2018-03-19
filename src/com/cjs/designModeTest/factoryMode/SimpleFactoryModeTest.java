package com.cjs.designModeTest.factoryMode;

// 简单工厂模式
class SimpleBMWFactory {
	
	public BMW getBMW(int type) {
		switch (type) {
		
		case 520: {
			return new BMW520();
		}
		
		case 74: {
			return new BMW74();
		} 
		
		default: {}
		
		}
		
		return null;
	}

}

public class SimpleFactoryModeTest {
	
	public static void main(String[] args) {
		SimpleBMWFactory simpleBMWFactory = new SimpleBMWFactory();
		BMW b1 = simpleBMWFactory.getBMW(74);
		BMW b2 = simpleBMWFactory.getBMW(520);
	}
}


/*
 * 简单工厂模式的缺点：每增加一个BMW类的实现类，就需要在getBMW方法里添加相应的业务逻辑，比较繁琐，也违背了开闭原则。
 * */