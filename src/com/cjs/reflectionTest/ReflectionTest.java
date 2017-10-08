package com.cjs.reflectionTest;

public class ReflectionTest {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Student stu = new Student();
		System.out.println(stu.getName());
		new Test().test(stu);
	}

}

class Student {
	
	private String name="cjs";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class Test {
	public void test(Object obj) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> Cls = Class.forName(obj.getClass().getName());
		Student stu = (Student) Cls.newInstance();
		stu.setName("liqing");
		System.out.println(stu.getName());
	}
}
