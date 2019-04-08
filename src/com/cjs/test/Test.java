package com.cjs.test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static List<String> readCsv(String filepath) throws Exception {
        File csv = new File(filepath);
        DataInputStream in = new DataInputStream(new FileInputStream(csv));
        BufferedReader br = new BufferedReader(new InputStreamReader(in, Charset.forName("GBK")));

        String line;
        List<String> list = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            if (line.length() > 0 && line.charAt(0) != '\"' && !list.isEmpty()) {
                String lastLine = list.get(list.size() - 1);
                list.set(list.size() - 1, (lastLine + "\n" + line).trim());
            } else {
                if (line.lastIndexOf("\"") > 0) {
                    list.add(line);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) throws Exception {
        List<String> contents = readCsv("/Users/chenjinshu/Downloads/zjipst110/ZD_BJLXDM.csv");
        for (String s : contents) {
            System.out.println(new String(s.getBytes(), "UTF-8"));
            System.out.println("===============================");
        }
    }
}
