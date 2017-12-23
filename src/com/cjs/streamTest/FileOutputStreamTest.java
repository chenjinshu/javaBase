package com.cjs.streamTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	public static void main(String[] args) {
		File file = new File("/Users/chenjinshu/IdeaProjects/javaBase/src/com/cjs/streamTest/fileOutputStream.txt");
		if(file.exists()) {
			file.delete();
		}
		try {
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file, true);  // true 的意思是在文件后追加内容。false则是重新创建该文件，如果已经存在，则删除后重建，默认为false
			byte[] bty = "李晴".getBytes();
			System.out.println(bty.length);
			for(byte b : bty) {
				System.out.println(b);
			}
			fos.write(bty);
			fos.flush();    // 最好加上这句，不加也没啥大问题
			fos.close();
			System.out.println("写入完毕");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
