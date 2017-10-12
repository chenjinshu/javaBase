package com.cjs.streamTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) {
		File ifile = new File("/Users/chenjinshu/IdeaProjects/javaBase/src/com/cjs/streamTest/fileInputStream.txt");
		if(ifile.exists()) {
			try {
			    FileInputStream fis = new FileInputStream(ifile);
//			    int c;
//				while((c=fis.read()) != -1) {
//					System.out.println(c);
//				}
				
				System.out.println("===============================");
				
				byte[] bty = new byte[1024];
				int k = fis.read(bty);
				fis.close();
				System.out.println(k);
				System.out.println(bty[0]);
				System.out.println(new String(bty, 0, k));  // 将字节数组转换为字符串输出
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("fileInputStream.txt文件不存在！");
		}
	}

}
