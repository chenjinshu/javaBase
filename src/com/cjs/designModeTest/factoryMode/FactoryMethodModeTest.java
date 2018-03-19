package com.cjs.designModeTest.factoryMode;

// 工厂方法模式
class BMW520Factory implements BMWFactory {
	
	@Override
	public BMW createBMW() {
		return new BMW520();
	}
}

class BMW74Factory implements BMWFactory {
	
	@Override
	public BMW createBMW() {
		return new BMW74();
	}
}


public class FactoryMethodModeTest {

	public static void main(String[] args) {
		BMW520Factory bmw520Factory = new BMW520Factory();
		BMW b1 = bmw520Factory.createBMW();
		
		BMW74Factory bmw74Factory = new BMW74Factory();
		BMW b2 = bmw74Factory.createBMW();
	}
}
