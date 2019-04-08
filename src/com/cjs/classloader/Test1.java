package com.cjs.classloader;

import java.lang.reflect.InvocationTargetException;

/**
 * 参考: https://blog.csdn.net/briblue/article/details/54973413
 * @author chen.jinshu (青禾)
 * 2019/03/29
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        System.out.println("主线程上下文类加载器:" + Thread.currentThread().getContextClassLoader());

        // 设置当前线程的类加载器
        Thread.currentThread().setContextClassLoader(new DiskClassLoader("/Users/chenjinshu/IdeaProjects/javaBase/customClassLoaderClassPath"));

        new Thread(() -> {
            System.out.println("子线程上下文类加载器:" + Thread.currentThread().getContextClassLoader());
            try {
                Class clazz = Thread.currentThread().getContextClassLoader().loadClass("com.cjs.testclassloader.Point");
                System.out.println(clazz.getDeclaredMethod("getX").invoke(clazz.newInstance()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * 子线程的类加载器默认情况下会继承父线程的类加载器。
     */
}
