package com.cjs.reflectionTest;

import java.lang.reflect.Constructor;

// 获取类构造方法
public class Test4 {

    public static Constructor[] getConstructor(Object obj) {
        return obj.getClass().getConstructors();     // 只能获取public修饰的构造方法
    }

    public static Constructor[] getDeclaredConstructor(Object obj) {
        return obj.getClass().getDeclaredConstructors();     // 获取类中所声明的所有构造方法
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Constructor[] constructors = getConstructor(animal);
        for(Constructor constructor: constructors) {
            System.out.println("构造函数名称：" + constructor.getName());

            Class[] paramsType = constructor.getParameterTypes();    // 成员变量的类类型
            for(Class param : paramsType) {
                System.out.println("构造函数参数类型：" + param.getName());
            }
            System.out.println("---------------");
        }

        System.out.println("====================");

        constructors = getDeclaredConstructor(animal);
        for(Constructor constructor : constructors) {
            System.out.println("构造函数名称：" + constructor.getName());

            Class[] paramsType = constructor.getParameterTypes();    // 成员变量的类类型
            for(Class param : paramsType) {
                System.out.println("构造函数参数类型：" + param.getName());
            }
            System.out.println("----------------");
        }
    }
}
