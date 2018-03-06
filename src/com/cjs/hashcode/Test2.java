package com.cjs.hashcode;

public class Test2 {

	public static void main(String[] args) {
		String str1 = "Aa";
		String str2 = "BB";
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str1.equals(str2));
		
		System.out.println("===========");
		
		String str3 = new String("Aa");
		String str4 = new String("BB");
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		System.out.println(str3.equals(str4));  
		System.out.println(str3 == str4);      // 判断对象的地址
		
		System.out.println("===========");
		
		System.out.println(str1 == str3);
		
		System.out.println("===========");
		
		String str5 = new String("CC");
		String str6 = new String("CC");
		System.out.println(str5.hashCode());
		System.out.println(str6.hashCode()); 
		System.out.println(str5.equals(str6));  // String类的equals方法比较的是字符串的内容
		System.out.println(str5 == str6);      //  判断对象的地址
	}
}
