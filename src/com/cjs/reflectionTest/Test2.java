package com.cjs.reflectionTest;

import java.lang.reflect.Method;

// 获取类方法
public class Test2 {

    public static Method[] getMethods(Object obj) {
        return obj.getClass().getMethods();    // 包括从父类继承而来的对象
    }

    public static Method[] getDeclaredMethods(Object obj) {
        return obj.getClass().getDeclaredMethods();   // 只包括类中自己声明的对象
    }

    public static void main(String[] args) {
        Word word = new Word();
        Method[] methods = getMethods(word);
        for(Method method : methods) {
            System.out.println("方法名：" + method.getName());

            Class returnType = method.getReturnType();
            System.out.println("返回值类型：" + returnType.getName());

            Class[] parametersType = method.getParameterTypes();
            for(Class cls : parametersType) {
                System.out.println("参数类型：" + cls.getName());
            }
            System.out.println("------------");
        }

        System.out.println("=============================================");

        methods = getDeclaredMethods(word);
        for(Method method : methods) {
            System.out.println(" 方法名：" + method.getName());

            Class returnType = method.getReturnType();
            System.out.println(" 返回值类型：" + returnType.getName());

            Class[] parametersType = method.getParameterTypes();
            for(Class cls : parametersType) {
                System.out.println(" 参数类型：" + cls.getName());
            }
            System.out.println("------------");
        }

        System.out.println("==========================*****************************==================");

        A a = new A();
        Class ac = a.getClass();
        try {
            Method m = ac.getDeclaredMethod("print", int.class, int.class); // 获取具有两个int型参数的print方法的Method对象
            m.invoke(a, new Object[]{3, 4});     // 通过反射来调用a对象的print方法

            m = ac.getDeclaredMethod("print", String.class, String.class); // 获取具有两个String型参数的print方法的Method对象
            Object o = m.invoke(a, new Object[]{"cjs", "lq"});     // 通过反射来调用a对象的print方法, 这个print方法是有返回值的, 如果没有返回值，则o就是null
            System.out.println(o.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class A {
    public void print(int a, int b) {
        System.out.println(a + b);
    }

    public String print(String a, String b) {
        return a + "," + b;
    }
}

