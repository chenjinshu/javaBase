package com.cjs.streamTest;

import java.io.*;

public class BufferedInputStreamTest {

    public static void main(String[] args) throws IOException {

        File srcFile = new File("/Users/chenjinshu/IdeaProjects/javaBase/src/com/cjs/streamTest/bufferedInputStream.txt");
        File desFile = new File("/Users/chenjinshu/IdeaProjects/javaBase/src/com/cjs/streamTest/bufferedOutputStream.txt");
        if(!srcFile.exists()) {
            srcFile.createNewFile();
        }
        if(!desFile.exists()) {
            desFile.createNewFile();
        }

        // 利用带缓冲的字节流进行文件拷贝，速度快
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desFile));
//        int c;
//        while((c = bis.read()) != -1) {
//            bos.write(c);
//        }
        byte[] bt = new byte[1024];     // 采用字节数组的形式是速度最快的
        int m = bis.read(bt, 0, bt.length);
        bos.write(bt, 0, m);
        bis.close();
        bos.close();
    }
}
