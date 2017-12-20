package com.cjs.fanxingTest;

public class FanxingTest1 {
	
	public static void printNum(Num1<?> number) {         // 这里的?就是类型实参，而不能看作类型形参
		System.out.println(number.getNum());
	}

	public static void main(String[] args) {
		Num1<Integer> intNum = new Num1<Integer>(10);
        Num1<Double> doubleNum = new Num1<Double>(3.14);
        printNum(intNum);
        printNum(doubleNum); 
	}

}

class Num1<T> {
	private T num;
	
	public Num1(T num) {
		this.num = num;
	}
	
	public T getNum() {
		return num;
	}
	
	public void setNum(T num) {
		this.num = num;
	}
}