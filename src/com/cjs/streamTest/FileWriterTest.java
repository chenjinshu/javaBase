package com.cjs.streamTest;

import java.io.File;
import java.io.FileWriter;

public class FileWriterTest {

	public static void main(String[] args) {
		File file = new File("G:/EclipseWorkspace/JavaTest/src/com/cjs/streamTest/fileWriter.txt");
        if(file.exists()) {
        	file.delete();
        }
        try {
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			writer.write("生如夏花之绚烂，死如秋叶之静美");
			writer.close();   // 关闭流，不然字符串内容不会被写入到文件中，当然也可以使用writer.flush方法强制输出。
			System.out.println("写入完毕");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
