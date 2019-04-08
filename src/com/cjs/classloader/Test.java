package com.cjs.classloader;

import sun.misc.Launcher;

import java.io.InputStream;

/**
 * 参考: https://blog.csdn.net/briblue/article/details/54973413
 * @author chen.jinshu (青禾)
 * 2019/03/29
 */
public class Test {
    public static void main(String[] args) throws Exception {
        DiskClassLoader diskClassLoader = new DiskClassLoader("/Users/chenjinshu/IdeaProjects/javaBase/customClassLoaderClassPath");
        Class c = diskClassLoader.loadClass("com.cjs.testclassloader.Point");
        System.out.println(c.getClassLoader());

        System.out.println(c.getDeclaredMethod("getX").invoke(c.newInstance()));
        System.out.println(c.getDeclaredMethod("getY").invoke(c.newInstance()));
    }
}
