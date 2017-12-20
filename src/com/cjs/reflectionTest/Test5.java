package com.cjs.reflectionTest;

import java.util.ArrayList;
import java.util.List;

public class Test5 {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		//直接添加编译时提示错误
		//list.add("lq");
		try {
			// 通过反射机制绕过泛型限制。因为泛型只在编译时有效，而反射作用于运行时刻。
			// 至于为什么参数是Object.class而不是Integer.class是因为当代码编译完成后
			// 由于泛型被擦除，而List集合原本是可以存放任意类型的数据的，所以编译后的
			// add方法的参数就是Object类型。
			list.getClass().getDeclaredMethod("add", new Class[]{Object.class}).invoke(list, "lq");   
			System.out.println(list.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
