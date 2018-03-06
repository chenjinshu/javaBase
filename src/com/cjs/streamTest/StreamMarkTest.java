package com.cjs.streamTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamMarkTest {
	
	public static void writeToFile() throws IOException {
		File file = new File("G:/EclipseWorkspace/javaBase/src/com/cjs/streamTest/streamMarkTest.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		byte[] bt = new byte[20];
		for(int i=0; i<20; i++) {
			bt[i] = (byte) i;
		}
		bos.write(bt);
		
		bos.close();
	}
	
	public static void readFromFile() throws IOException {
		File file = new File("G:/EclipseWorkspace/javaBase/src/com/cjs/streamTest/streamMarkTest.txt");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		
		if(!bis.markSupported()) {
			System.out.println("stream mark is not supported!");
			bis.close();
			return;
		}
		
		int count = 0;
		int pos;
		boolean marked = false;
	    while((pos = bis.read()) != -1) { 
	    	System.out.println(pos);
	    	
	    	if(pos == 4 && !marked) {
	    		bis.mark(10);     // 标记指针当前的位置, 10的意思是在这个标记失效之前所能读取的最大字节数, 
	    		                  // 如果超过了此限制，则标记会失效。但实际上不完全如此，还和缓冲区的大小有关。
	    		                  // mark和reset方法只对Buffered类的stream有效
	    	}
	    	
	    	if(pos == 8 && count < 2) {
	    		bis.reset();      // 将指针指向标记的位置
	    		count++;
	    	}
	    }
	    
	    bis.close();
	}
	
	public static void main(String[] args) throws IOException {
		writeToFile();
		readFromFile();
	}

}
