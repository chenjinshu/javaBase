package com.cjs.ioTest;

public class encodeDemo {
    public static void main(String[] args) throws Exception {
        String s = "慕课ABC";
        byte[] bt = s.getBytes();    // idea默认是utf-8编码
        for(byte b : bt) {
            // 把字节（转换成了int）以十六进制显示
            System.out.println(Integer.toHexString(b));    // utf-8编码方式，中文占用3个字节，英文占用1个字节
        }
        System.out.println(new String(bt));

        System.out.println("================");

        bt = s.getBytes("gbk");    // 以bgk编码方式获取字节数组
        for(byte b : bt) {
            // 把字节（转换成了int）以十六进制显示
            System.out.println(Integer.toHexString(b));   // gbk编码方式，中文占用2个字节，英文占用1个字节
        }
        System.out.println(new String(bt, "gbk"));

        System.out.println("================");

        bt = s.getBytes("utf-16be");    // 以utf-16be编码方式获取字节数组(java采用的就是这种双字节编码方法)
        for(byte b : bt) {
            // 把字节（转换成了int）以十六进制显示
            System.out.println(Integer.toHexString(b));   // utf-16be编码方式，中文占用2个字节，英文占用2个字节
        }
        System.out.println(new String(bt, "utf-16be"));

    }

}
