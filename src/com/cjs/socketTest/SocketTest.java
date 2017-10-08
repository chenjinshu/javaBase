package com.cjs.socketTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTest {
	
	public static void main(String[] args) {
		try {
			Socket socket1 = new Socket("192.168.88.3", 22);           // 建立socket连接
			
			OutputStream os = socket1.getOutputStream();        // 创建输出流
			
			InputStream is = socket1.getInputStream();          // 创建输入流
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
