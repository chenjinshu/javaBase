package com.cjs.streamTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	public static void main(String[] args) {
		File file = new File("G:/EclipseWorkspace/JavaTest/src/com/cjs/streamTest/fileOutputStream.txt");
		if(file.exists()) {
			file.delete();
		}
		try {
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			byte[] bty = "李晴".getBytes();
			System.out.println(bty.length);
			for(byte b : bty) {
				System.out.println(b);
			}
			fos.write(bty);
			fos.close();
			System.out.println("写入完毕");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
