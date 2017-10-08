package com.cjs.TCPTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleTCPClient {

	public static void main(String[] args) {
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;
		
		// 服务器ip地址
		String serverIP = "127.0.0.1";
		
		// 端口号
		int port = 10008;
		
		// 发送内容
		String msg = "Hello~";

		try {
			// 建立连接
			socket = new Socket(serverIP, port);
			
			// 获得输出流
			os = socket.getOutputStream();
			
			for(int i=0; i<3; i++) {     // 复用socket
				// 发送数据
				os.write(msg.getBytes());
				
				// 获得输入流
				is = socket.getInputStream();
				
				// 接收数据
				byte[] bt = new byte[1024];
				int n = is.read(bt);
				
				// 输出反馈数据
				System.out.println("服务器反馈：" + new String(bt, 0, n));
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭输入输出流
				os.close();
				is.close();
				
				// 关闭连接
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
