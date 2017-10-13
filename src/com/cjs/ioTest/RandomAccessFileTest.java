package com.cjs.ioTest;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RandomAccessFileTest {

    public static void main(String[] args) throws IOException {
        File file = new File("AccessDemo");
        if(!file.exists()) {
            file.mkdir();
        }

        File file1 = new File(file, "raf.dat");
        if(!file1.exists()) {
            file1.createNewFile();
        }

        RandomAccessFile raf = new RandomAccessFile(file1, "rw");

        // 指针的位置
        System.out.println(raf.getFilePointer());

        raf.write('A');   // 一个字符占用两个字节，但write方法只写入一个字节（后8位）
        System.out.println(raf.getFilePointer());

        int i = 0x7fffffff;   // 32位的最大带符号整数,要想写入这个数，write方法得写4次
//        raf.write(i >>> 24);     // 高8位
//        raf.write(i >>> 16);
//        raf.write(i >>> 8);
//        raf.write(i);   // 低8位
        raf.writeInt(i);   // 这个方法等价于上面的注释
        System.out.println(raf.getFilePointer());

        String s = "中";
        byte[] bt = s.getBytes("utf-8");
        raf.write(bt);
        System.out.println(raf.getFilePointer());      // 这里的值其实就是这个文件内容共有多少个字节


        // 读文件，必须把指针移到头部
        raf.seek(0);

        // 一次性读取，把文件的内容都读到字节数组中
        byte[] buf = new byte[(int) raf.length()];
        raf.read(buf);
        System.out.println(Arrays.toString(buf));
        String str = new String(buf, 0, buf.length);
        System.out.println(str);

        raf.close();
    }
}
