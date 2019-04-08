package com.cjs.jvmTiaoyouTest;

/**
 * 模拟堆空间溢出
 * 点击顶部栏的Run选项，然后EditConfigurations设置虚拟机参数
 * @author chen.jinshu (青禾)
 * 2019/03/29
 */
public class Test {

    private static String base = "cjs";

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < Integer.MAX_VALUE; i++){
            base = base + base;
        }
    }
}
