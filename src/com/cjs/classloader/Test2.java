package com.cjs.classloader;

import java.io.InputStream;

/**
 * @author chen.jinshu (青禾)
 * 2019/03/29
 */
public class Test2 {

    public static void main(String[] args) throws Exception {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("com/cjs/streamTest/bufferedInputStream.txt");
        byte[] bt = new byte[1024];
        int k = is.read(bt, 0, bt.length);
        System.out.println(new String(bt, 0, k));
    }
}
