package com.cjs.reflectionTest;

import java.lang.reflect.Field;

// 获取类成员变量
public class Test3 {

    public static Field[] getFields(Object obj) {
        return obj.getClass().getFields();     // 只能获取public修饰的成员变量
    }

    public static Field[] getDeclaredFields(Object obj) {
        return obj.getClass().getDeclaredFields();     // 获取类中声明的所有成员变量，包括private
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        Field[] fields = getFields(dog);
        for(Field field : fields) {
            Class fieldType = field.getType();    // 成员变量的类类型
            System.out.println("成员变量的类型：" + fieldType.getName());
            System.out.println("成员变量的名称：" + field.getName());
            System.out.println("---------------");
        }

        System.out.println("====================");

        fields = getDeclaredFields(dog);
        for(Field field : fields) {
            Class fieldType = field.getType();    // 成员变量的类类型
            System.out.println("成员变量的类型：" + fieldType.getName());
            System.out.println("成员变量的名称：" + field.getName());
            System.out.println("--------------");
        }
    }
}
