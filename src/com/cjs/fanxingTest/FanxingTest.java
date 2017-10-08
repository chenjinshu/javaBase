package com.cjs.fanxingTest;

public class FanxingTest {
	
	public static void printNum(Num<Integer> number) {
		System.out.println(number.getNum());
	}

	public static void main(String[] args) {
		Num<Integer> intNum = new Num<Integer>(10);
        Num<Double> doubleNum = new Num<Double>(3.14);
        printNum(intNum);
        //printNum(doubleNum);        // 提示有错误，类型不一致  
	}

}

class Num<T> {
	private T num;
	
	public Num(T num) {
		this.num = num;
	}
	
	public T getNum() {
		return num;
	}
	
	public void setNum(T num) {
		this.num = num;
	}
}
