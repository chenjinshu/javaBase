package com.cjs.stringTest;

public class StringTest1 {

	public static void main(String[] args) {
		String s0 = new String("hello");
		String s1 = "hello";
		String s2 = "hel" + "lo";            // JVM会无视这个拼接操作，直接当作hello处理
		System.out.println(s0 == s1);        // false
		System.out.println(s0.equals(s1));   // true
		System.out.println(s1 == s2);     // true
		System.out.println(s1.equals(s2));   // true
		
		System.out.println("=========");
		
		String s3 = "hel";
		String s4 = s3 + "lo";              // 这里的s4和s5都相当于new String("hello")
		String s5 = s3 + "lo";
		System.out.println(s1 == s4);       // false
		System.out.println(s1.equals(s4));   // true
		System.out.println(s4 == s5);        // false
		
		System.out.println("=========");
		
		System.out.println(s1 == s0.intern());   // true  由于字符串的intern方法会返回一个字符串常量池中与自身内容一致的字符串的引用。
		                                         //       而s0指向的是堆内存，s1指向的是常量池，所以这里的结果是true
		System.out.println(s0 == s1.intern());   // false s1.intern得到的就是s1本身，所以结果是false
	}
}
