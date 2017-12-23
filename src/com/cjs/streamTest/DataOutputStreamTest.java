package com.cjs.streamTest;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamTest {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/chenjinshu/IdeaProjects/javaBase/src/com/cjs/streamTest/dataOutputStream.txt");
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeLong(10L);
        dos.writeDouble(10.5);

        // 采用utf-16be编码写出
        dos.writeChar(116);
        //dos.writeChars("陈劲树");

        // 采用utf-8编码写出
        dos.writeUTF("李晴");

        dos.close();
    }
}
