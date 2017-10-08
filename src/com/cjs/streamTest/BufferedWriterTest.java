package com.cjs.streamTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class BufferedWriterTest {

	public static void main(String[] args) {
		String[] contents = {"螃蟹在剥我的壳，笔记本在写我。", "漫天的我落在枫叶上，雪花上。", "而你在想我。"};
		
		File file = new File("G:/EclipseWorkspace/JavaTest/src/com/cjs/streamTest/bufferedWriter.txt");
        if(file.exists()) {
        	file.delete();
        }
        try {
        	FileWriter writer = new FileWriter(file);
        	BufferedWriter bfwriter = new BufferedWriter(writer);
        	for(String content : contents) {
        		bfwriter.write(content);
        		bfwriter.newLine();          // 换行
        	}
        	bfwriter.close();
        	writer.close();
        	System.out.println("写入完毕");
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}

}
