package com.cjs.streamTest;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamTest {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/chenjinshu/IdeaProjects/javaBase/src/com/cjs/streamTest/dataOutputStream.txt");
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        int i  = dis.readInt();
        System.out.println(i);

        int p  = dis.readInt();
        System.out.println(p);

        long q  = dis.readLong();
        System.out.println(q);

        double m = dis.readDouble();
        System.out.println(m);

        char n = dis.readChar();
        System.out.println(n);

//        char l = dis.readChar();
//        System.out.println(l);
//
//        char h = dis.readChar();
//        System.out.println(h);

        String s = dis.readUTF();
        System.out.println(s);

        dis.close();
    }
}
