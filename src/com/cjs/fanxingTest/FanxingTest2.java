package com.cjs.fanxingTest;

public class FanxingTest2 {
	
	public static <T> T genericMethod(Class<T> tClass) throws InstantiationException, IllegalAccessException{ // 这里的T是类型形参
	        T instance = tClass.newInstance();
	        return instance;
	}

	public static void main(String[] args) {
		try {
			Object obj = genericMethod(Class.forName("com.cjs.fanxingTest.FanxingTest"));
			System.out.println(obj.getClass().getName());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
